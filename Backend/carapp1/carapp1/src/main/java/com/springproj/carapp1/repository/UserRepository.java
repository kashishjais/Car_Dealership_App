package com.springproj.carapp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springproj.carapp1.entity.UserInfo;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    @Query("SELECT u FROM UserInfo u WHERE u.user_name=:user_name")
    Optional<UserInfo> findByUserName(@Param("user_name")String user_name);

}
