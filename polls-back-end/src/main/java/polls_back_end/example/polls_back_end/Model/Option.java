package polls_back_end.example.polls_back_end.Model;

public class Option {
    private String text;
    private int votes;

    
    public Option(String text, int votes) {
        this.text = text;
        this.votes = votes;
    }
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes) {
        this.votes = votes;
    }

    
    
}
