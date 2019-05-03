package com.lxisoft.service.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.lxisoft.domain.InstructionVideo;
import com.lxisoft.domain.Media;

/**
 * A DTO for the Activity entity.
 */
public class ActivityDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    private String successMessage;

    private String url;

    private Long instructionVideoId;
    
    private Set<Media> files;// added

	private InstructionVideo instructionVideo;// added

	private Set<String> encodedFiles;

	private String encodedInstructionVideo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getInstructionVideoId() {
        return instructionVideoId;
    }

    public void setInstructionVideoId(Long instructionVideoId) {
        this.instructionVideoId = instructionVideoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ActivityDTO activityDTO = (ActivityDTO) o;
        if (activityDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), activityDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ActivityDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", successMessage='" + getSuccessMessage() + "'" +
            ", url='" + getUrl() + "'" +
            ", instructionVideo=" + getInstructionVideoId() +
            "}";
    }

	public Set<Media> getFiles() {
		return files;
	}

	public void setFiles(Set<Media> files) {
		this.files = files;
	}

	public InstructionVideo getInstructionVideo() {
		return instructionVideo;
	}

	public void setInstructionVideo(InstructionVideo instructionVideo) {
		this.instructionVideo = instructionVideo;
	}

	public Set<String> getEncodedFiles() {
		return encodedFiles;
	}

	public void setEncodedFiles(Set<String> encodedFiles) {
		this.encodedFiles = encodedFiles;
	}

	public String getEncodedInstructionVideo() {
		return encodedInstructionVideo;
	}

	public void setEncodedInstructionVideo(String encodedInstructionVideo) {
		this.encodedInstructionVideo = encodedInstructionVideo;
	}
}
