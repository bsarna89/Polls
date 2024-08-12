package polls_back_end.example.polls_back_end.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import polls_back_end.example.polls_back_end.Model.Poll;
import polls_back_end.example.polls_back_end.Service.PollService;


@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = {"http://localhost:5173"}) // FE localhost
public class PollController {
    @Autowired
    private PollService pollService;

    @GetMapping
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public Poll getPollById(@PathVariable ObjectId id) {
        return pollService.getPollById(id);
    }

    @GetMapping("/active")
    public List<Poll> getActivePolls() {
        return pollService.getActivePolls();
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    @PutMapping("/{id}")
    public Poll updatePoll(@PathVariable ObjectId id, @RequestBody Poll poll) {
        return pollService.updatePoll(id, poll);
    }

    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable ObjectId id) {
        pollService.deletePoll(id);
    }
}
