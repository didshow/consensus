import java.util.ArrayList;

public class Node {
    private String address;
    private int availableVotes; // 节点可用于投票的票数
    private int voteCount; // 获得票数
    private int tokenAmount; // 代币数量

    public Node(String address, int availableVotes, int voteCount, int tokenAmount) {
        this.address = address;
        this.availableVotes = availableVotes;
        this.voteCount = voteCount;
        this.tokenAmount = tokenAmount;
    }

    public Node(String nodeAddress, int tokenAmount) {
        this.address = nodeAddress;
        this.tokenAmount =  tokenAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAvailableVotes() {
        return availableVotes;
    }

    public void setAvailableVotes(int availableVotes) {
        this.availableVotes = availableVotes;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getTokenAmount() {
        return tokenAmount;
    }

    public void setTokenAmount(int tokenAmount) {
        this.tokenAmount = tokenAmount;
    }

    public static void addNode(ArrayList<Node> nodes, String newNodeAddress, int newNodeTokenAmount) {
        Node newNode = new Node(newNodeAddress, newNodeTokenAmount);
        nodes.add(newNode);
    }
    public void addVote(int tokenAmount) {
        // 根据代币数量计算应该增加的票数
        int votesToAdd = tokenAmount / 10; // 假设每 10 个代币增加 1 票

        // 增加票数
        voteCount += votesToAdd;
    }
    public void vote(Vote vote) {
        if (availableVotes > 0) {
            // 减少可用投票数
            availableVotes--;
            // 增加获得票数
            voteCount++;
        } else {
        }
    }
}