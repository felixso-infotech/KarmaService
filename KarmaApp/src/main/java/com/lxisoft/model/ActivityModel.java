package com.lxisoft.model;

public class ActivityModel {

	private Long id;

	private String title;

	private String description;

	private String successMessage;

	private String url;

	private Long instructionVideoId;

	private String instructionVideoFileName;

	private byte[] instructionVideoFile;

	private String instructionVideoFileContentType;

	public Long getId() {
		return id;
	}

	public ActivityModel setId(Long id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public ActivityModel setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ActivityModel setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public ActivityModel setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public ActivityModel setUrl(String url) {
		this.url = url;
		return this;
	}

	public Long getInstructionVideoId() {
		return instructionVideoId;
	}

	public ActivityModel setInstructionVideoId(Long instructionVideoId) {
		this.instructionVideoId = instructionVideoId;
		return this;
	}

	public String getInstructionVideoFileName() {
		return instructionVideoFileName;
	}

	public ActivityModel setInstructionVideoFileName(String instructionVideoFileName) {
		this.instructionVideoFileName = instructionVideoFileName;
		return this;
	}

	public byte[] getInstructionVideoFile() {
		return instructionVideoFile;
	}

	public ActivityModel setInstructionVideoFile(byte[] instructionVideoFile) {
		this.instructionVideoFile = instructionVideoFile;
		return this;
	}

	public String getInstructionVideoFileContentType() {
		return instructionVideoFileContentType;
	}

	public ActivityModel setInstructionVideoFileContentType(String instructionVideoFileContentType) {
		this.instructionVideoFileContentType = instructionVideoFileContentType;
		return this;
	}
}
