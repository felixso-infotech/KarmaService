package com.felixsoinfotech.karma.repository;

import com.felixsoinfotech.karma.domain.RegisteredUser;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the RegisteredUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {

}
