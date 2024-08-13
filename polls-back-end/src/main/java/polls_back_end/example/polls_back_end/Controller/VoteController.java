package polls_back_end.example.polls_back_end.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import polls_back_end.example.polls_back_end.Model.Vote;
import polls_back_end.example.polls_back_end.Service.VoteService;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:4173"}) // FE & Cypress localhosts
public class VoteController {
    
    @Autowired
    private VoteService voteService;

    @GetMapping("/poll/{pollId}")
    public List<Vote> getVotesByPollId(@PathVariable ObjectId pollId) {
        return voteService.getVotesByPollId(pollId);
    }

    @PostMapping
    public Vote submitVote(@RequestBody Vote vote) {
        return voteService.recordVote(vote.getPollId(), vote.getOptionText());
    }
}
