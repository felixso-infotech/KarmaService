package com.lxisoft.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.domain.CompletedActivity;
import com.lxisoft.domain.Media;
import com.lxisoft.domain.RegisteredUser;
import com.lxisoft.repository.ActivityRepository;
import com.lxisoft.repository.CompletedActivityRepository;
import com.lxisoft.repository.InstructionVideoRepository;
import com.lxisoft.repository.MediaRepository;
import com.lxisoft.repository.RegisteredUserRepository;
import com.lxisoft.service.AggregateService;
import com.lxisoft.service.dto.ActivityDTO;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.dto.InstructionVideoDTO;
import com.lxisoft.service.dto.MediaDTO;
import com.lxisoft.service.dto.RegisteredUserDTO;
import com.lxisoft.service.mapper.ActivityMapper;
import com.lxisoft.service.mapper.CompletedActivityMapper;
import com.lxisoft.service.mapper.InstructionVideoMapper;
import com.lxisoft.service.mapper.MediaMapper;
import com.lxisoft.service.mapper.RegisteredUserMapper;

@Service
@Transactional
public class AggregateServiceImpl implements AggregateService {

	private final Logger log = LoggerFactory.getLogger(AggregateServiceImpl.class);

	private final RegisteredUserRepository registeredUserRepository;

	private final RegisteredUserMapper registeredUserMapper;

	private final ActivityMapper activityMapper;

	private final ActivityRepository activityRepository;

	private final CompletedActivityRepository completedActivityRepository;

	private final MediaRepository mediaRepository;

	private final MediaMapper mediaMapper;

	private final CompletedActivityMapper completedActivityMapper;

	private final InstructionVideoRepository instructionVideoRepository;

	private final InstructionVideoMapper instructionVideoMapper;

	public AggregateServiceImpl(RegisteredUserRepository registeredUserRepository,
			RegisteredUserMapper registeredUserMapper, ActivityMapper activityMapper,
			ActivityRepository activityRepository, CompletedActivityRepository completedActivityRepository,
			MediaRepository mediaRepository, MediaMapper mediaMapper, CompletedActivityMapper completedActivityMapper,
			InstructionVideoRepository instructionVideoRepository, InstructionVideoMapper instructionVideoMapper) {
		super();
		this.registeredUserRepository = registeredUserRepository;
		this.registeredUserMapper = registeredUserMapper;
		this.activityMapper = activityMapper;
		this.activityRepository = activityRepository;
		this.completedActivityRepository = completedActivityRepository;
		this.mediaRepository = mediaRepository;
		this.mediaMapper = mediaMapper;
		this.completedActivityMapper = completedActivityMapper;
		this.instructionVideoRepository = instructionVideoRepository;
		this.instructionVideoMapper = instructionVideoMapper;
	}

	/**
	 * Save a registeredUser.
	 *
	 * @param RegisteredUserDTO the entity to save
	 * @return the persisted entity
	 */

	@Override
	public RegisteredUserDTO saveRegisteredUser(RegisteredUserDTO registeredUserDTO) {
		log.debug("Request to save RegisteredUser : {}", registeredUserDTO);
		RegisteredUser registeredUser = registeredUserMapper.toEntity(registeredUserDTO);
		registeredUser = registeredUserRepository.save(registeredUser);
		return registeredUserMapper.toDto(registeredUser);
	}

	/**
	 * Get all the registeredUsers.
	 *
	 * @param pageable the pagination information
	 * @return the list of entities
	 */

	@Override
	public Page<RegisteredUserDTO> findAllRegisteredUsers(Pageable pageable) {
		log.debug("Request to get all RegisteredUser");
		return registeredUserRepository.findAll(pageable).map(registeredUserMapper::toDto);
	}

	/**
	 * Get one activity by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	@Override
	public Optional<ActivityDTO> findActivityById(Long id) {
		return activityRepository.findById(id).map(activityMapper::toDto);
	}

	/**
	 * Save a registeredActivity.
	 *
	 * @param CompletedActivityDTO the entity to save
	 * @return the persisted entity
	 */
	@Override
	public CompletedActivityDTO saveCompletedActivity(CompletedActivityDTO completedActivityDTO) {

		CompletedActivity completedActivity = completedActivityMapper.toEntity(completedActivityDTO);
		completedActivity = completedActivityRepository.save(completedActivity);
		return completedActivityMapper.toDto(completedActivity);
	}

	/**
	 * Save a media.
	 *
	 * @param MediaDTO the entity to save
	 * @return the persisted entity
	 */
	@Override
	public MediaDTO saveMedia(MediaDTO mediaDTO) {
		Media media = mediaMapper.toEntity(mediaDTO);
		media = mediaRepository.save(media);
		return mediaMapper.toDto(media);
	}

	/**
	 * Get one media by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	@Override
	public Optional<MediaDTO> findMediaById(Long mediaId) {
		return mediaRepository.findById(mediaId).map(mediaMapper::toDto);
	}

	/**
	 * Get one registeredUser by phoneNumber.
	 *
	 * @param phoneNUmber the phoneNumber of the entity
	 * @return the entity
	 */
	@Override
	public Optional<RegisteredUserDTO> findRegisteredUserByPhoneNumber(Long phoneNumber) {
		log.debug("Request to get all RegisteredUser");
		return registeredUserRepository.findByPhoneNumber(phoneNumber).map(registeredUserMapper::toDto);
	}

	/**
	 * Get all the activities.
	 *
	 * @param pageable the pagination information
	 * @return the list of entities
	 */
	@Override
	public Page<ActivityDTO> findAllActivities(Pageable pageable) {
		return activityRepository.findAll(pageable).map(activityMapper::toDto);
	}

	/**
	 * Get one completedActivity by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	@Override
	public Optional<CompletedActivityDTO> findCompletedActivityById(Long completedActivityId) {
		return completedActivityRepository.findById(completedActivityId).map(completedActivityMapper::toDto);

	}

	/**
	 * Get one completedActivity by registeredUserId.
	 *
	 * @param registeredUserId the id of the entity
	 * @return the list of entity
	 */
	@Override
	public Page<CompletedActivityDTO> findCompletedActivityByRegisteredUserId(Long registeredUserId,
			Pageable pageable) {
		return completedActivityRepository.findByRegisteredUserId(registeredUserId, pageable)
				.map(completedActivityMapper::toDto);

	}

	/**
	 * Get list of completedActivity by phoneNumber.
	 *
	 * @param registeredUserId the id of the entity
	 * @return the list of entity
	 */
	@Override
	public Page<CompletedActivityDTO> findCompletedActivityByRegisteredUserPhoneNumber(Long phoneNumber,
			Pageable pageable) {
		return completedActivityRepository.findByRegisteredUserPhoneNumber(phoneNumber, pageable)
				.map(completedActivityMapper::toDto);

	}

	/**
	 * Get list of incompletedActivity by registeredUserId.
	 *
	 * @param registeredUserId the id of the entity
	 * @return the list of entity
	 */
	@Override
	public Page<ActivityDTO> findIncompletedActivityByRegisteredUserId(Long registeredUserId, Pageable pageable) {
		List<CompletedActivityDTO> completedActivityDTOs = completedActivityRepository
				.findByRegisteredUserId(registeredUserId, pageable).map(completedActivityMapper::toDto).getContent();
		List<ActivityDTO> activityDTOs = findAllActivities(pageable).getContent();
		List<ActivityDTO> dtos = new ArrayList<ActivityDTO>();
		dtos.addAll(activityDTOs);
		List<ActivityDTO> toRemove = new ArrayList<ActivityDTO>();

		for (ActivityDTO activityDTO : activityDTOs) {
			for (CompletedActivityDTO completedActivityDTO : completedActivityDTOs) {
				if (activityDTO.getId() == completedActivityDTO.getActivityId()) {

					toRemove.add(activityDTO);
				}
			}
		}
		dtos.removeAll(toRemove);
		return new PageImpl<ActivityDTO>(dtos, pageable, dtos.size());
	}

	/**
	 * Get list of incompletedActivity by phoneNumber.
	 *
	 * @param phoneNumber the id of the entity
	 * @return the list of entity
	 */
	@Override
	public Page<ActivityDTO> findIncompletedActivityByRegisteredUserPhoneNumber(Long phoneNumber, Pageable pageable) {
		List<CompletedActivityDTO> completedActivityDTOs = completedActivityRepository
				.findByRegisteredUserPhoneNumber(phoneNumber, pageable).map(completedActivityMapper::toDto)
				.getContent();
		List<ActivityDTO> activityDTOs = findAllActivities(pageable).getContent();
		List<ActivityDTO> dtos = new ArrayList<ActivityDTO>();
		dtos.addAll(activityDTOs);
		List<ActivityDTO> toRemove = new ArrayList<ActivityDTO>();

		for (ActivityDTO activityDTO : activityDTOs) {
			for (CompletedActivityDTO completedActivityDTO : completedActivityDTOs) {
				if (activityDTO.getId() == completedActivityDTO.getActivityId()) {
					toRemove.add(activityDTO);
				}
			}
		}
		dtos.removeAll(toRemove);
		return new PageImpl<ActivityDTO>(dtos, pageable, dtos.size());
	}

	/**
	 * Get one instructionVideo by activityId.
	 *
	 * @param activityId the id of the activity of instruction video
	 * @return the entity
	 */
	@Override
	public Optional<InstructionVideoDTO> findInstructionVideoByActivityId(Long activityId) {

		log.debug("Request to get InstructionVideo by activityId: {}", activityId);

		Optional<ActivityDTO> activityDTO = activityRepository.findById(activityId).map(activityMapper::toDto);
		return instructionVideoRepository.findById(activityDTO.get().getInstructionVideoId())
				.map(instructionVideoMapper::toDto);

	}

	/**
	 * Get one registeredUser by id.
	 *
	 * @param registeredUser the id of the entity
	 * @return the entity
	 */
	@Override
	public Optional<RegisteredUserDTO> findRegisteredUserById(Long id) {
		log.debug("Request to get RegisteredUser by id");
		return registeredUserRepository.findById(id).map(registeredUserMapper::toDto);
	}

	/**
	 * Get one instructionVideo by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	@Override
	public Optional<InstructionVideoDTO> findInstructionVideoById(Long id) {
		log.debug("Request to get InstructionVideo by id");
		return instructionVideoRepository.findById(id).map(instructionVideoMapper::toDto);
	}

	/**
	 * Get list of media by activityId.
	 *
	 * @param activityId the id of the entity
	 * @return the list of entity
	 */
	@Override
	public Page<MediaDTO> findMediaByActivityId(Long activityId, Pageable pageable) {

		return mediaRepository.findByActivityId(activityId, pageable).map(mediaMapper::toDto);
	}

	/**
	 * Get list of media by completedActivityId.
	 *
	 * @param completedActivityId the id of the entity
	 * @return the list of entity
	 */
	@Override
	public Page<MediaDTO> findMediaByCompletedActivityId(Long completedActivityId, Pageable pageable) {

		return mediaRepository.findByCompletedActivityId(completedActivityId, pageable).map(mediaMapper::toDto);
	}

}
