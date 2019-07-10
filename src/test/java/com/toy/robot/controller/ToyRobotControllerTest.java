package com.toy.robot.controller;

import com.toy.robot.model.Facing;
import com.toy.robot.model.Location;
import com.toy.robot.model.State;
import com.toy.robot.repository.ToyRobotFacingRepository;
import com.toy.robot.repository.ToyRobotLocationRepository;
import com.toy.robot.repository.ToyRobotStateRepository;
import com.toy.robot.service.ToyRobotService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Test class for {@link ToyRobotController}
 *
 * @author Reddy
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ToyRobotController.class)
public class ToyRobotControllerTest {

    private static final String TEST_DATA = "PLACE 0,0,NORTH";
    private static final Long ID = 10L;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToyRobotLocationRepository locationRepository;

    @MockBean
    private ToyRobotFacingRepository facingRepository;

    @MockBean
    private ToyRobotStateRepository stateRepository;

    @MockBean
    private ToyRobotService robotService;


    @Before
    public void init() {
        given(this.stateRepository.findById(ID)).willReturn(Optional.of(new State()));
        given(this.locationRepository.findById(ID)).willReturn(Optional.of(new Location(0, 0)));
        given(this.facingRepository.findById(ID)).willReturn(Optional.of(new Facing(0, 0)));

    }

    @Test
    public void testToyRobotPosition() throws Exception {

        mockMvc.perform(get("/api/{input}", TEST_DATA))
                .andExpect(status().isOk());
    }


    @Test
    public void testMessage() throws Exception {

        mockMvc.perform(get("/api/message", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("Enter here to move"));
    }

}

