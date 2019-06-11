package com.lxisoft.service.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Lob;

/**
 * A DTO for the InstructionVideo entity.
 */
public class InstructionVideoDTO implements Serializable {

    private Long id;

    private String fileName;

    @Lob
    private byte[] file;
    private String fileContentType;
    
	private String encodedInstructionVideo;
	
	private String fileUrl;


    public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InstructionVideoDTO instructionVideoDTO = (InstructionVideoDTO) o;
        if (instructionVideoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), instructionVideoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InstructionVideoDTO{" +
            "id=" + getId() +
            ", fileName='" + getFileName() + "'" +
            ", file='" + getFile() + "'" +
            "}";
    }

	public String getEncodedInstructionVideo() {
		return encodedInstructionVideo;
	}

	public void setEncodedInstructionVideo(String encodedInstructionVideo) {
		this.encodedInstructionVideo = encodedInstructionVideo;
	}
}
