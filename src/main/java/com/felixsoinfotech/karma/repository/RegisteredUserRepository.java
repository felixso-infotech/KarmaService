package com.felixsoinfotech.karma.repository;

import com.felixsoinfotech.karma.domain.RegisteredUser;
import com.felixsoinfotech.karma.service.dto.DimensionDTO;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the RegisteredUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {

	/**
	 * @param userId
	 * @return
	 */
	Optional<RegisteredUser> findByUserId(String userId);

	
}
