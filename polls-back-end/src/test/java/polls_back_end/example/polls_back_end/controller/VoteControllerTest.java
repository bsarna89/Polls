package polls_back_end.example.polls_back_end.controller;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import polls_back_end.example.polls_back_end.Controller.VoteController;
import polls_back_end.example.polls_back_end.Model.Vote;
import polls_back_end.example.polls_back_end.Service.VoteService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VoteController.class)
public class VoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VoteService voteService;

    @Test
    public void testGetVotesByPollId() throws Exception {
        ObjectId pollId = new ObjectId();
        Vote vote1 = new Vote(pollId, "Option A", LocalDateTime.now());
        Vote vote2 = new Vote(pollId, "Option B", LocalDateTime.now());

        when(voteService.getVotesByPollId(pollId)).thenReturn(Arrays.asList(vote1, vote2));

        mockMvc.perform(get("/api/votes/poll/" + pollId.toHexString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].optionText").value("Option A"))
                .andExpect(jsonPath("$[1].optionText").value("Option B"));
    }

    @Test
    public void testSubmitVote() throws Exception {
        ObjectId pollId = new ObjectId();
        String optionText = "Option A";
        Vote vote = new Vote(pollId, optionText, LocalDateTime.now());
        vote.setId(new ObjectId()); 

        when(voteService.recordVote(pollId, optionText)).thenReturn(vote);

        mockMvc.perform(post("/api/votes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"pollId\": \"" + pollId.toHexString() + "\", \"optionText\": \"" + optionText + "\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());
    }
    
}
