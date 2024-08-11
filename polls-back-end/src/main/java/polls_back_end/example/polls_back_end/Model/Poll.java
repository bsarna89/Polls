package polls_back_end.example.polls_back_end.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@Document(collection = "polls")
public class Poll {
    
    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    private boolean isActive;
    private int totalVotes;
    private String question;
    private List<Option> options;

    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public int getTotalVotes() {
        return totalVotes;
    }
    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public List<Option> getOptions() {
        return options;
    }
    public void setOptions(List<Option> options) {
        this.options = options;
    }    

}