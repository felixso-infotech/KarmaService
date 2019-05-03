package com.lxisoft.repository;

import com.lxisoft.domain.Activity;
import com.lxisoft.domain.InstructionVideo;
import com.lxisoft.service.dto.ActivityDTO;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Activity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

	
}
