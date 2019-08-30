package com.felixsoinfotech.karma.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the Media entity.
 */
public class MediaDTO implements Serializable {

    private Long id;

    private String fileName;

    @Lob
    private byte[] file;
    private String fileContentType;

    private Long committedActivityId;

    private Long completedChallengeId;

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

    public Long getCommittedActivityId() {
        return committedActivityId;
    }

    public void setCommittedActivityId(Long committedActivityId) {
        this.committedActivityId = committedActivityId;
    }

    public Long getCompletedChallengeId() {
        return completedChallengeId;
    }

    public void setCompletedChallengeId(Long completedChallengeId) {
        this.completedChallengeId = completedChallengeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MediaDTO mediaDTO = (MediaDTO) o;
        if (mediaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mediaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MediaDTO{" +
            "id=" + getId() +
            ", fileName='" + getFileName() + "'" +
            ", file='" + getFile() + "'" +
            ", committedActivity=" + getCommittedActivityId() +
            ", completedChallenge=" + getCompletedChallengeId() +
            "}";
    }
}
