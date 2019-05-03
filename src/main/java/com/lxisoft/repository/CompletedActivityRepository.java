package com.lxisoft.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.domain.CompletedActivity;

/**
 * Spring Data repository for the CompletedActivity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompletedActivityRepository extends JpaRepository<CompletedActivity, Long> {

	Page<CompletedActivity> findByRegisteredUserId(Long registeredUserId, Pageable pgeable);

	Page<CompletedActivity> findByRegisteredUserPhoneNumber(Long phoneNumber, Pageable pageable);

}
