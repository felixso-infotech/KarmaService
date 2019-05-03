package com.lxisoft.model;

import java.util.ArrayList;
import java.util.List;

import com.lxisoft.service.dto.MediaDTO;

public class CompletedActivityModel {

	private Long id;

	private Long registeredUserId;

	private Long activityId;

	private String activityTitle;

	private String activityDescription;

	private List<MediaDTO> proofs = new ArrayList<MediaDTO>();// to be name changed

	public Long getId() {
		return id;
	}

	public CompletedActivityModel setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getRegisteredUserId() {
		return registeredUserId;
	}

	public CompletedActivityModel setRegisteredUserId(Long registeredUserId) {
		this.registeredUserId = registeredUserId;
		return this;
	}

	public Long getActivityId() {
		return activityId;
	}

	public CompletedActivityModel setActivityId(Long activityId) {
		this.activityId = activityId;
		return this;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public CompletedActivityModel setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
		return this;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public CompletedActivityModel setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
		return this;
	}

	public List<MediaDTO> getProofs() {
		return proofs;
	}

	public CompletedActivityModel setProofs(List<MediaDTO> proofs) {
		this.proofs = proofs;
		return this;
	}

}
