package polls_back_end.example.polls_back_end.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polls_back_end.example.polls_back_end.Repository.VoteRepository;
import polls_back_end.example.polls_back_end.Model.Vote;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public List<Vote> getVotesByPollId(ObjectId pollId) {
        return voteRepository.findByPollId(pollId);
    }

    public Vote recordVote(ObjectId pollId, String optionText) {
        Vote vote = new Vote(pollId, optionText, LocalDateTime.now());
        return voteRepository.save(vote);
    }
}