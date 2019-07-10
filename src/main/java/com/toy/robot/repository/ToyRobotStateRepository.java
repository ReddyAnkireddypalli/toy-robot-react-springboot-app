package com.toy.robot.repository;

import com.toy.robot.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRobotStateRepository extends JpaRepository<State, Long> {
}
