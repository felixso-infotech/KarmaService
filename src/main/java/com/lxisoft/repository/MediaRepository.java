package com.lxisoft.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.domain.Media;

/**
 * Spring Data repository for the Media entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

	public Page<Media> findByActivityId(Long activityId, Pageable pageable);

	public Page<Media> findByCompletedActivityId(Long completedActivityId, Pageable pageable);
}
