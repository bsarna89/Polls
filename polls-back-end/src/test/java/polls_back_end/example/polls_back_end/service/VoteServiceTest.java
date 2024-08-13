package polls_back_end.example.polls_back_end.service;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import polls_back_end.example.polls_back_end.Model.Vote;
import polls_back_end.example.polls_back_end.Repository.VoteRepository;
import polls_back_end.example.polls_back_end.Service.VoteService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class VoteServiceTest {

    @Mock
    private VoteRepository voteRepository;

    @InjectMocks
    private VoteService voteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetVotesByPollId() {
        ObjectId pollId = new ObjectId();
        List<Vote> votes = Arrays.asList(
            new Vote(pollId, "Option A", LocalDateTime.now()),
            new Vote(pollId, "Option B", LocalDateTime.now())
        );

        when(voteRepository.findByPollId(pollId)).thenReturn(votes);

        List<Vote> result = voteService.getVotesByPollId(pollId);

        assertEquals(2, result.size());
        verify(voteRepository, times(1)).findByPollId(pollId);
    }

    @Test
    public void testRecordVote() {
        ObjectId pollId = new ObjectId();
        String optionText = "Option A";
        Vote vote = new Vote(pollId, optionText, LocalDateTime.now());

        when(voteRepository.save(any(Vote.class))).thenReturn(vote);

        Vote result = voteService.recordVote(pollId, optionText);

        assertEquals(pollId, result.getPollId());
        assertEquals(optionText, result.getOptionText());
        verify(voteRepository, times(1)).save(any(Vote.class));
    }

}