package com.lxisoft.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.lxisoft.client.openlrw.model.MongoEvent;
import com.lxisoft.domain.Activity;
import com.lxisoft.domain.CompletedActivity;
import com.lxisoft.domain.InstructionVideo;
import com.lxisoft.domain.Media;
import com.lxisoft.domain.RegisteredUser;
import com.lxisoft.repository.ActivityRepository;
import com.lxisoft.repository.CompletedActivityRepository;
import com.lxisoft.repository.MediaRepository;
import com.lxisoft.repository.RegisteredUserRepository;
import com.lxisoft.repository.UserRepository;
import com.lxisoft.service.AggregateService;
import com.lxisoft.service.dto.ActivityDTO;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.dto.MediaDTO;
import com.lxisoft.service.dto.RegisteredUserDTO;
import com.lxisoft.service.mapper.ActivityMapper;
import com.lxisoft.service.mapper.CompletedActivityMapper;
import com.lxisoft.service.mapper.MediaMapper;
import com.lxisoft.service.mapper.RegisteredUserMapper;
import com.lxisoft.service.mapper.UserMapper;

@Service
@Transactional
public class AggregateServiceImpl implements AggregateService {

	private final Logger log = LoggerFactory.getLogger(AggregateServiceImpl.class);

	private final UserRepository userRepository;

	private final RegisteredUserRepository registeredUserRepository;

	private final RegisteredUserMapper registeredUserMapper;

	private final UserMapper userMapper;

	private final ActivityMapper activityMapper;

	private final ActivityRepository activityRepository;

	private final CompletedActivityRepository completedActivityRepository;

	private final MediaRepository mediaRepository;

	private final MediaMapper mediaMapper;

	private final CompletedActivityMapper completedActivityMapper;

	public AggregateServiceImpl(RegisteredUserRepository registeredUserRepository,
			RegisteredUserMapper registeredUserMapper, UserMapper userMapper, UserRepository userRepository,
			ActivityRepository activityRepository, ActivityMapper activityMapper, MediaRepository mediaRepository,
			MediaMapper mediaMapper, CompletedActivityRepository completedActivityRepository,
			CompletedActivityMapper completedActivityMapper) {

		this.registeredUserRepository = registeredUserRepository;
		this.registeredUserMapper = registeredUserMapper;
		this.userMapper = userMapper;
		this.userRepository = userRepository;
		this.activityRepository = activityRepository;
		this.activityMapper = activityMapper;
		this.mediaRepository = mediaRepository;
		this.mediaMapper = mediaMapper;
		this.completedActivityRepository = completedActivityRepository;
		this.completedActivityMapper = completedActivityMapper;
	}

	/**
	 * Save a reward.
	 *
	 * @param rewardDTO the entity to save
	 * @return the persisted entity
	 */

	@Override
	public RegisteredUserDTO saveRegisteredUser(RegisteredUserDTO registeredUserDTO) {
		log.debug("Request to save RegisteredUser : {}", registeredUserDTO);
		byte[] imageByte = Base64.decodeBase64(registeredUserDTO.getEncodedFile());
		Media media = new Media();
		media.setFile(imageByte);
		media = mediaRepository.save(media);
		registeredUserDTO.setProfilePicId(media.getId());
		RegisteredUser registeredUser = registeredUserMapper.toEntity(registeredUserDTO);
		registeredUser = registeredUserRepository.save(registeredUser);
		return registeredUserMapper.toDto(registeredUser);
	}

	/*
	 * @Override public User save(User user) {
	 * log.debug("Request to save User : {}", user);
	 * 
	 * user = userRepository.save(user); return user; }
	 */

	@Override
	public Page<RegisteredUserDTO> findAllRegisteredUsers(Pageable pageable) {
		log.debug("Request to get all RegisteredUser");
		List<RegisteredUser> registeredUsers = registeredUserRepository.findAll(pageable).getContent();
		List<RegisteredUserDTO> registeredUserDTOs = new ArrayList<RegisteredUserDTO>();
		for (RegisteredUser registeredUser : registeredUsers) {
			Media media = registeredUser.getProfilePic();
			RegisteredUserDTO registeredUserDTO = registeredUserMapper.toDto(registeredUser);
			String encodedFile = Base64.encodeBase64String(media.getFile());
			registeredUserDTO.setEncodedFile(encodedFile);
			registeredUserDTOs.add(registeredUserDTO);
		}
		return new PageImpl<RegisteredUserDTO>(registeredUserDTOs, pageable, registeredUserDTOs.size());

	}

	/*
	 * @Override public Page<ActivityDTO> findIncompletedActivities(List<MongoEvent>
	 * completedEvents, Pageable pageable) { Page<Activity> activities =
	 * activityRepository.findAll(pageable); List<Activity> filteredActivity = new
	 * ArrayList<Activity>(); List<Activity> activityList = activities.getContent();
	 * if (completedEvents != null && completedEvents.size() > 1) { for (Activity a
	 * : activityList) { for (MongoEvent me : completedEvents) { if
	 * (a.getId().toString().equals(me.getEvent().getObject().getId())) {
	 * filteredActivity.add(a); } } } } Page<Activity> paged = new
	 * PageImpl<Activity>(filteredActivity, pageable, filteredActivity.size());
	 * return paged.map(activityMapper::toDto);
	 * 
	 * }
	 */
	@Override
	public Optional<ActivityDTO> findActivityById(Long activityId) {
		Activity activity = activityRepository.findById(activityId).get();// .map(activityMapper::toDto);
		Set<Media> files = activity.getFiles();
		Set<String> encodedFiles = new HashSet<String>();
		for (Media media : files) {
			String encodedFile = Base64.encodeBase64String(media.getFile());
			encodedFiles.add(encodedFile);
		}
		InstructionVideo instructionVideo = activity.getInstructionVideo();
		String encodedInstructionVideo = Base64.encodeBase64String(instructionVideo.getFile());
		ActivityDTO activityDTO = activityMapper.toDto(activity);
		activityDTO.setEncodedFiles(encodedFiles);
		activityDTO.setEncodedInstructionVideo(encodedInstructionVideo);
		return Optional.of(activityDTO);
	}

	@Override
	public CompletedActivityDTO saveCompletedActivity(CompletedActivityDTO completedActivityDTO) {

		Long registeredUserId = completedActivityDTO.getId();
		RegisteredUser registeredUser = registeredUserRepository.findById(registeredUserId).get();
		registeredUser.setNoOfCoins(registeredUser.getNoOfCoins() + 100);
		RegisteredUserDTO registeredUserDTO = updateRegisteredUser(registeredUserMapper.toDto(registeredUser));
		CompletedActivity completedActivity = completedActivityRepository
				.save(completedActivityMapper.toEntity(completedActivityDTO));
		for (String s : completedActivityDTO.getEncodedProofs()) {
			byte[] imageByte = Base64.decodeBase64(s);
			Media media = new Media();
			media.setFile(imageByte);
			media = mediaRepository.save(media);
			MediaDTO mediaDTO = mediaMapper.toDto(media);
			mediaDTO.setCompletedActivityId(completedActivity.getId());
			mediaRepository.save(mediaMapper.toEntity(mediaDTO));
		}

		return completedActivityMapper.toDto(completedActivity);
	}

	@Override
	public RegisteredUserDTO updateRegisteredUser(RegisteredUserDTO registeredUserDTO) {

		RegisteredUser registeredUser = registeredUserMapper.toEntity(registeredUserDTO);
		registeredUser = registeredUserRepository.save(registeredUser);
		return registeredUserMapper.toDto(registeredUser);

	}

	@Override
	public MediaDTO saveMedia(MediaDTO mediaDTO) {
		Media media = mediaMapper.toEntity(mediaDTO);
		media = mediaRepository.save(media);
		return mediaMapper.toDto(media);
	}

	@Override
	public Optional<RegisteredUserDTO> findRegisteredUserByPhoneNumber(Long phoneNumber) {
		log.debug("Request to get all RegisteredUser");
		RegisteredUser registeredUser = registeredUserRepository.findByPhoneNumber(phoneNumber).get();
		RegisteredUserDTO registeredUserDTO = null;
		if ((registeredUser != null) && (registeredUser.getProfilePic() != null)) {
			registeredUserDTO = registeredUserMapper.toDto(registeredUser);
			Media media = registeredUser.getProfilePic();
			String encodedFile = Base64.encodeBase64String(media.getFile());
			registeredUserDTO.setEncodedFile(encodedFile);
		}
		return Optional.of(registeredUserDTO);
	}

	@Override
	public Page<ActivityDTO> findAllActivities(Pageable pageable) {
		List<Activity> activities = activityRepository.findAll(pageable).getContent();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		List<ActivityDTO> activityDTOs = new ArrayList<ActivityDTO>();
		for (Activity activity : activities) {
			System.out.println("*********************************");
			Set<String> encodedFiles = new HashSet<String>();
			Set<Media> files = activity.getFiles();
			for (Media media : files) {
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				String encodedFile = Base64.encodeBase64String(media.getFile());
				encodedFiles.add(encodedFile);
			}
			InstructionVideo instructionVideo = activity.getInstructionVideo();
			String encodedInstructionVideo = Base64.encodeBase64String(instructionVideo.getFile());
			ActivityDTO activityDTO = activityMapper.toDto(activity);
			activityDTO.setEncodedFiles(encodedFiles);
			activityDTO.setEncodedInstructionVideo(encodedInstructionVideo);
			activityDTOs.add(activityDTO);
		}

		return new PageImpl<ActivityDTO>(activityDTOs, pageable, activityDTOs.size());
	}

	@Override
	public CompletedActivityDTO findCompletedActivityById(Long completedActivityId) {
		CompletedActivity completedActivity = completedActivityRepository.findById(completedActivityId).get();
		CompletedActivityDTO completedActivityDTO = completedActivityMapper.toDto(completedActivity);
		ActivityDTO activityDTO = activityMapper.toDto(completedActivity.getActivity());
		Set<String> encodedFiles = new HashSet<String>();
		Set<Media> files = completedActivity.getActivity().getFiles();
		for (Media media : files) {
			String encodedFile = Base64.encodeBase64String(media.getFile());
			encodedFiles.add(encodedFile);
		}
		activityDTO.setEncodedFiles(encodedFiles);
		InstructionVideo instructionVideo = completedActivity.getActivity().getInstructionVideo();
		String encodedInstructionVideo = Base64.encodeBase64String(instructionVideo.getFile());
		activityDTO.setEncodedInstructionVideo(encodedInstructionVideo);
		completedActivityDTO.setActivityDTO(activityDTO);
		Set<String> encodedProofs = new HashSet<String>();
		Set<Media> proofs = completedActivity.getProofs();
		for (Media media : files) {
			String encodedFile = Base64.encodeBase64String(media.getFile());
			encodedProofs.add(encodedFile);
		}
		completedActivityDTO.setEncodedProofs(encodedProofs);
		RegisteredUserDTO registeredUserDTO = registeredUserMapper.toDto(completedActivity.getRegisteredUser());
		Media media = completedActivity.getRegisteredUser().getProfilePic();
		String encodedProfilePic = Base64.encodeBase64String(media.getFile());
		registeredUserDTO.setEncodedFile(encodedProfilePic);
		completedActivityDTO.setRegisteredUserDTO(registeredUserDTO);
		return completedActivityDTO;
	}

	@Override
	public Page<CompletedActivityDTO> findCompletedActivityByRegisteredUserId(Long registeredUserId,
			Pageable pageable) {
		RegisteredUser registeredUser = registeredUserRepository.findById(registeredUserId).get();
		List<CompletedActivity> completedActivities = completedActivityRepository.findByRegisteredUser(registeredUser);
		List<CompletedActivityDTO> completedActivityDTOs = new ArrayList<CompletedActivityDTO>();
		for (CompletedActivity completedActivity : completedActivities) {
			CompletedActivityDTO completedActivityDTO = completedActivityMapper.toDto(completedActivity);
			ActivityDTO activityDTO = activityMapper.toDto(completedActivity.getActivity());
			Set<String> encodedFiles = new HashSet<String>();
			Set<Media> files = completedActivity.getActivity().getFiles();
			for (Media media : files) {
				String encodedFile = Base64.encodeBase64String(media.getFile());
				encodedFiles.add(encodedFile);
			}
			activityDTO.setEncodedFiles(encodedFiles);
			InstructionVideo instructionVideo = completedActivity.getActivity().getInstructionVideo();
			String encodedInstructionVideo = Base64.encodeBase64String(instructionVideo.getFile());
			activityDTO.setEncodedInstructionVideo(encodedInstructionVideo);
			completedActivityDTO.setActivityDTO(activityDTO);
			Set<String> encodedProofs = new HashSet<String>();
			Set<Media> proofs = completedActivity.getProofs();
			for (Media media : files) {
				String encodedFile = Base64.encodeBase64String(media.getFile());
				encodedProofs.add(encodedFile);
			}
			completedActivityDTO.setEncodedProofs(encodedProofs);
			RegisteredUserDTO registeredUserDTO = registeredUserMapper.toDto(completedActivity.getRegisteredUser());
			Media media = completedActivity.getRegisteredUser().getProfilePic();
			String encodedProfilePic = Base64.encodeBase64String(media.getFile());
			registeredUserDTO.setEncodedFile(encodedProfilePic);
			completedActivityDTO.setRegisteredUserDTO(registeredUserDTO);
			completedActivityDTOs.add(completedActivityDTO);
		}
		return new PageImpl<CompletedActivityDTO>(completedActivityDTOs, pageable, completedActivityDTOs.size());
	}

	@Override
	public Page<ActivityDTO> findIncompletedActivityByRegisteredUserId(Long registeredUserId, Pageable pageable) {
		List<CompletedActivityDTO> completedActivityDTOs = findCompletedActivityByRegisteredUserId(registeredUserId,
				pageable).getContent();
		List<ActivityDTO> activityDTOs = findAllActivities(pageable).getContent();
		for (ActivityDTO activityDTO : activityDTOs) {
			for (CompletedActivityDTO completedActivityDTO : completedActivityDTOs) {
				if (activityDTO.getId() == completedActivityDTO.getActivityDTO().getId()) {
					activityDTOs.remove(activityDTO);
				}
			}
		}
		return new PageImpl<ActivityDTO>(activityDTOs, pageable, activityDTOs.size());
	}

}
