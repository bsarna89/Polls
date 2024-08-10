package polls_back_end.example.polls_back_end.Service;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polls_back_end.example.polls_back_end.Model.Poll;
import polls_back_end.example.polls_back_end.Repository.PollRepository;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Poll getPollById(ObjectId id) {
        return pollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Poll not found"));
    }

    public List<Poll> getActivePolls() {
        return pollRepository.findByIsActiveTrue();
    }


    public Poll createPoll(Poll poll) {
        poll.setId(ObjectId.get()); 
        poll.setTotalVotes(0);     
        poll.getOptions().forEach(option -> option.setVotes(0));
        poll.setActive(poll.isActive());      
        return pollRepository.save(poll);
    }

    public Poll updatePoll(ObjectId id, Poll updatedPoll) {
        Poll existingPoll = getPollById(id);
        existingPoll.setQuestion(updatedPoll.getQuestion());
        existingPoll.setOptions(updatedPoll.getOptions());
        existingPoll.setTotalVotes(updatedPoll.getTotalVotes());
        existingPoll.setActive(updatedPoll.isActive());
        return pollRepository.save(existingPoll);
    }

    public void deletePoll(ObjectId id) {
        pollRepository.deleteById(id);
    }

}
