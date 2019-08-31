package com.toy.robot.controller;

import com.toy.robot.model.State;
import com.toy.robot.service.ToyRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ToyRobotController {

    @Autowired
    private ToyRobotService toyRobotService;

    /**
     * It return the just the text which is available to text box in UI.
     * @return String
     */
    @GetMapping("/message")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getMessage(){
        return "Enter here to move";
    }

    /**
     * It process the request and return position result of state.
     * @param input - It takes the input from React UI which is like Place 0,0,North, Move,
     * @return State
     */
    @GetMapping("/{input}")
    @CrossOrigin(origins = "http://localhost:3000")
    public State getToyRobotPosition(@PathVariable String input){

        return toyRobotService.getResults(input);

    }
}
