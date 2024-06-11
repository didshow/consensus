import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class DPoS {
    public static void main(String[] args) {
        // 添加节点并随机分配代币数量
        List<Node> nodes = new ArrayList<>();
        Random random = new Random();
        BlockChain blockchain = new BlockChain();
        blockchain.createGenesisBlock();

        int totalTokens = 10000; // 总代币数量
        for (int i = 0; i < 100; i++) {
            int tokenAmount = 1 + random.nextInt(totalTokens / 10); // 保证每个节点至少拥有1个代币
            totalTokens -= tokenAmount;
            String nodeAddress = BlockChain.HashUtil.sha256(UUID.randomUUID().toString());
            Node node = new Node(nodeAddress, tokenAmount);
            blockchain.addNode(node);
            nodes.add(node);
            // 在添加节点的同时，创建对应的投票并添加到投票列表
            Vote vote = new Vote(nodeAddress, tokenAmount, tokenAmount);
            blockchain.addVote(vote);
            System.out.println("节点已添加，节点为："+ (i + 1) + ". " + node.getAddress() + "，代币数量为：" + node.getTokenAmount());
        }
        // 根据分配的代币给予节点票数
        for (Node node : nodes) {
            int numVotes = node.getTokenAmount(); // 获取节点的代币数量
            node.addVote(numVotes); // 给节点增加票数
        }
        // 进行随机投票模拟
        Random random1 = new Random(System.currentTimeMillis());
        List<Vote> votes = blockchain.getVoteList();
        for (Node node : nodes) {
            int numVotes = node.getVoteCount(); // 获取节点的票数
            for (int i = 0; i < numVotes; i++) {
                int candidateIndex = random1.nextInt(votes.size()); // 随机选择候选人索引
                Vote vote = votes.get(candidateIndex); // 获取对应的候选人投票
                node.vote(vote); // 节点进行投票
            }
        }
        // 按票数排序节点
        List<Node> sortedNodes = BlockChain.sortNodesByVoteCount(nodes);

        // 输出票数最高的30个节点
        System.out.println("票数最高的30个节点：");
        for (int i = 0; i < 30 && i < sortedNodes.size(); i++) {
            Node node = sortedNodes.get(i);
            System.out.println((i + 1) + ". " + node.getAddress() + " - 票数：" + node.getVoteCount());
        }
        // 创建一个新的区块并添加到区块链
        Block newBlock1 = new Block(1, System.currentTimeMillis(), new ArrayList<>(), blockchain.getVoteList(), blockchain.getLatestBlock().getHash(), 0);
        System.out.println("等待添加区块1：");
        blockchain.addBlock(newBlock1);
        System.out.println("区块 1已添加，区块哈希为：" + newBlock1.getHash());
        Block newBlock2 = new Block(2, System.currentTimeMillis(), new ArrayList<>(), blockchain.getVoteList(), blockchain.getLatestBlock().getHash(), 0);
        System.out.println("等待添加区块2：");
        blockchain.addBlock(newBlock2);
        System.out.println("区块 2已添加，区块哈希为：" + newBlock2.getHash());
        // 验证区块链的合法性
        System.out.println("区块链的合法性为：" + blockchain.validate());
    }
}
