package com.lxisoft.repository;

import com.lxisoft.domain.CompletedActivity;
import com.lxisoft.domain.RegisteredUser;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CompletedActivity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompletedActivityRepository extends JpaRepository<CompletedActivity, Long> {

	List<CompletedActivity> findByRegisteredUser(RegisteredUser registeredUser);

}
