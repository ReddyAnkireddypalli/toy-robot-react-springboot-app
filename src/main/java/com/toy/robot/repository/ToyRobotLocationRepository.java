package com.toy.robot.repository;

import com.toy.robot.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRobotLocationRepository extends CrudRepository<Location, Long> {
}
