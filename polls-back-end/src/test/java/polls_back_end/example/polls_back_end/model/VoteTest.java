package polls_back_end.example.polls_back_end.model;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.mongodb.repository.MongoRepository;

import polls_back_end.example.polls_back_end.Model.Vote;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class VoteTest {

    @Test
    public void testVoteCreation() {
        ObjectId pollId = new ObjectId();
        String optionText = "Italian";
        LocalDateTime voteTime = LocalDateTime.now();

       
        Vote vote = new Vote(pollId, optionText, voteTime);

        @SuppressWarnings("unchecked")
        MongoRepository<Vote, ObjectId> repository = Mockito.mock(MongoRepository.class);
        when(repository.save(any(Vote.class))).thenAnswer(invocation -> {
            Vote v = invocation.getArgument(0);
            v.setId(new ObjectId());
            return v;
        });

        @SuppressWarnings("unused")
        Vote savedVote = repository.save(vote);
        
        assertNotNull(vote);
        assertNotNull(vote.getId()); 
        assertEquals(pollId, vote.getPollId());
        assertEquals(optionText, vote.getOptionText());
        assertEquals(voteTime, vote.getVoteTime());
    }
}