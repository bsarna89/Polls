package polls_back_end.example.polls_back_end.Model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection = "votes")
public class Vote {

    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;

    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId pollId;

    private String optionText;
    private LocalDateTime voteTime;

    public Vote() {}

    public Vote(ObjectId pollId, String optionText, LocalDateTime voteTime) {
        this.pollId = pollId;
        this.optionText = optionText;
        this.voteTime = voteTime;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getPollId() {
        return pollId;
    }

    public void setPollId(ObjectId pollId) {
        this.pollId = pollId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public LocalDateTime getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(LocalDateTime voteTime) {
        this.voteTime = voteTime;
    }
}
