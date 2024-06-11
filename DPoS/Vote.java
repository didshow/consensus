import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Vote {
    private String candidate; // 候选人
    private int voteCount; // 获得票数
    private int availableVotes; // 节点可用于投票的票数
    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public Vote(String candidate, int voteCount, int availableVotes) {
        this.candidate = candidate;
        this.voteCount = voteCount;
        this.availableVotes = availableVotes;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getAvailableVotes() {
        return availableVotes;
    }

    public void setAvailableVotes(int availableVotes) {
        this.availableVotes = availableVotes;
    }


}