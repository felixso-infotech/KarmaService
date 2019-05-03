package com.lxisoft.repository;

import com.lxisoft.domain.InstructionVideo;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the InstructionVideo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InstructionVideoRepository extends JpaRepository<InstructionVideo, Long> {

	
}
