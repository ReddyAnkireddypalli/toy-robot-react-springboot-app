package com.toy.robot.repository;

import com.toy.robot.model.Facing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRobotFacingRepository extends JpaRepository<Facing, Long> {
}
