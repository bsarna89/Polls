package polls_back_end.example.polls_back_end.Repository;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import polls_back_end.example.polls_back_end.Model.Vote;

public interface VoteRepository extends MongoRepository<Vote, ObjectId> {
    List<Vote> findByPollId(ObjectId pollId);
}