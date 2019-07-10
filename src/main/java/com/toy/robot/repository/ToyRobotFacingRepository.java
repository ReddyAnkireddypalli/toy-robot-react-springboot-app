package com.toy.robot.repository;

import com.toy.robot.model.Facing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRobotFacingRepository extends CrudRepository<Facing, Long> {
}
