package com.toy.robot.repository;

import com.toy.robot.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRobotStateRepository extends CrudRepository<State, Long> {
}
