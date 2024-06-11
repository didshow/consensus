import java.util.List;

public class Block {
    private int index;
    private long timestamp;
    private List<Transaction> transactionList;
    private List<Vote> voteList;
    private String previousHash;
    private String hash;
    private int nonce;

    public Block(int index, long timestamp, List<Transaction> transactionList, List<Vote> voteList, String previousHash, int nonce) {
        this.index = index;
        this.timestamp = timestamp;
        this.transactionList = transactionList;
        this.voteList = voteList;
        this.previousHash = previousHash;
        this.hash = BlockChain.HashUtil.sha256(String.valueOf(index) +timestamp+transactionList+voteList+previousHash+nonce);
        this.nonce = nonce;
    }



    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
}
