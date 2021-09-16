package com.swarawan.skyshitdd.database.repository;

import com.swarawan.skyshitdd.database.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Integer> {

    Boolean existsByEmail(String email);
}
