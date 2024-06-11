import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

public class BlockChain {
    // 区块链列表
    private static List<BlockChain> blockchainList = new ArrayList<>();
    // 区块链的难度
    private int difficulty;
    // 投票列表
    private List<Vote> voteList = new ArrayList<>();
    // 节点列表
    private List<Node> nodeList = new ArrayList<>();
    // 区块列表
    private List<Block> blockList = new ArrayList<>();
    //交易列表
    private List<Transaction> transactionList = new ArrayList<>();

    public BlockChain() {

    }

    public BlockChain(int difficulty, List<Vote> voteList, List<Node> nodeList, List<Block> blockList, List<Transaction> transaction) {
        this.difficulty = difficulty;
        this.voteList = voteList;
        this.nodeList = nodeList;
        this.blockList = blockList;
        this.transactionList = transaction;
    }

    public BlockChain(int difficulty) {
        this.difficulty = difficulty;
    }

    public static List<BlockChain> getBlockchainList() {
        return blockchainList;
    }

    public static void addBlockchain(BlockChain blockchain) {
        blockchainList.add(blockchain);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void addVote(Vote vote) {
        voteList.add(vote);
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void addNode(Node node) {
        nodeList.add(node);
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public void addBlock(Block block) {
        blockList.add(block);
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }
    public void createGenesisBlock() {
        List<Transaction> transactions = new ArrayList<>();
        List<Vote> votes = new ArrayList<>();
        String previousHash = "";
        int nonce = 0;
        Block genesisBlock = new Block(0, System.currentTimeMillis(), transactions, votes, previousHash, nonce);
        blockList.add(genesisBlock);
        System.out.println("genesisBlock: " + genesisBlock.getHash());
    }
    public Block getLatestBlock() {
        int lastIndex = blockList.size() - 1;
        if (lastIndex >= 0) {
            return blockList.get(lastIndex);
        } else {
            return null; // 如果区块链为空，返回 null
        }
    }
    public boolean validate() {
        return true;
    }
    // 票数排序
    public static List<Node> sortNodesByVoteCount(List<Node> nodes) {
        List<Node> sortedNodes = new ArrayList<>(nodes);
        Collections.sort(sortedNodes, Comparator.comparingInt(Node::getVoteCount).reversed());
        return sortedNodes;
    }

    // 工具类：哈希计算
    public static class HashUtil {
        public static String sha256(String data) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
                return Base64.getEncoder().encodeToString(hash);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}