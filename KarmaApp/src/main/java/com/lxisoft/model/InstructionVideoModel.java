package com.lxisoft.model;

public class InstructionVideoModel {

	private Long id;

	private String fileName;

	private byte[] file;

	private String fileContentType;

	public Long getId() {
		return id;
	}

	public InstructionVideoModel setId(Long id) {
		this.id = id;
		return this;
	}

	public String getFileName() {
		return fileName;
	}

	public InstructionVideoModel setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	public byte[] getFile() {
		return file;
	}

	public InstructionVideoModel setFile(byte[] file) {
		this.file = file;
		return this;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public InstructionVideoModel setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
		return this;
	}

}
