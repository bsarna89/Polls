package polls_back_end.example.polls_back_end.Repository;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import polls_back_end.example.polls_back_end.Model.Poll;

public interface PollRepository extends MongoRepository<Poll,  ObjectId> {

     List<Poll> findByIsActiveTrue();
}
