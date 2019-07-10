package com.toy.robot.service;

import com.toy.robot.model.Facing;
import com.toy.robot.model.Location;
import com.toy.robot.model.State;
import com.toy.robot.repository.ToyRobotFacingRepository;
import com.toy.robot.repository.ToyRobotLocationRepository;
import com.toy.robot.repository.ToyRobotStateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ToyRobotService {

    @Autowired
    ToyRobotStateRepository toyRobotStateRepository;

    @Autowired
    ToyRobotLocationRepository toyRobotLocationRepository;

    @Autowired
    ToyRobotFacingRepository toyRobotFacingRepository;

    private static Map<String, Facing> orientation = new HashMap<>();

    static {
        orientation.put("NORTH", new Facing(0, 1));
        orientation.put("SOUTH", new Facing(0, -1));
        orientation.put("WEST", new Facing(-1, 0));
        orientation.put("EAST", new Facing(1, 0));
    }


    /**
     * It process the request based on input and return state object.
     *
     * @param input - It receives input from controller
     * @return state
     */
    public State getResults(String input) {

        String result = "";

        Optional<State> optionalState = toyRobotStateRepository.findById(10L);
        Optional<Location> optionalLocation = toyRobotLocationRepository.findById(100L);
        Optional<Facing> optionalFacing = toyRobotFacingRepository.findById(200L);

        boolean placed = optionalState.map(State::isPlaced).orElse(false);

        // If the first word isn't a command, we ignore it
        String[] inputLine = input.split(",");
        String command = inputLine[0];

        State state = optionalState.orElse(null);
        Facing facing = optionalFacing.orElse(new Facing(0, 0));
        Location location = optionalLocation.orElse(new Location(0, 0));
     

        if (command.equals("PLACE")) {

            if (inputLine.length == 4) {

                try {
                    int x = Integer.parseInt(inputLine[1]);
                    int y = Integer.parseInt(inputLine[2]);
                    String f = inputLine[3];
                    facing = orientation.get(f);

                    // Check if the robot is still on the table, and valid direction
                    if (x > -1 && x < 5 && y > -1 && y < 5 && (facing != null)) {

                        location = new Location(x, y);
                        placed = true;
                        result = "PLACE " + x + "," + y + "," + f;

                    }
                } catch (Exception e) {
                    logger.error("Exception : " + e.getMessage());
                }

            }
            state = new State(facing.getX(), facing.getY(), location.getX(), location.getY(), result, placed);
            toyRobotStateRepository.save(state);
            toyRobotLocationRepository.save(location);
            toyRobotFacingRepository.save(facing);
            return state;
        }

        // Ignore everything else until robot is placed
        if (placed) {
            if (command.equals("MOVE")) {

                int moveX = facing.getX();
                int moveY = facing.getY();

                // Make sure the robot won't fall off the table
                int nextX = location.getX() + moveX;
                int nextY = location.getY() + moveY;

                if (nextX > -1 && nextX < 5 && nextY > -1 && nextY < 5) {

                    location = new Location(nextX, nextY);
                    result = "MOVE";
                }
            } else if (command.equals("LEFT")) {
                int x = facing.getX();
                int y = facing.getY();
                facing = new Facing(-y, x);
                result = "LEFT";

            } else if (command.equals("RIGHT")) {
                int x = facing.getX();
                int y = facing.getY();
                facing = new Facing(y, -x);
                result = "RIGHT";

            }
        }      

        state = new State(facing.getX(), facing.getY(), location.getX(), location.getY(), result, placed);
        toyRobotStateRepository.save(state);
        toyRobotLocationRepository.save(location);
        toyRobotFacingRepository.save(facing);
        return state;
    }
}


