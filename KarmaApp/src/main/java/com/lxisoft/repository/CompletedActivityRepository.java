package com.lxisoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.domain.CompletedActivity;
import com.lxisoft.domain.RegisteredUser;

/**
 * Spring Data repository for the CompletedActivity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompletedActivityRepository extends JpaRepository<CompletedActivity, Long> {

	List<CompletedActivity> findByRegisteredUser(RegisteredUser registeredUser);

}
