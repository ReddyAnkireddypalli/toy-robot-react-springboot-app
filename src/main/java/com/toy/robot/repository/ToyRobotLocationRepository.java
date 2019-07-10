package com.toy.robot.repository;

import com.toy.robot.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRobotLocationRepository extends JpaRepository<Location, Long> {
}
