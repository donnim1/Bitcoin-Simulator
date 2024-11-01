import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blocks;

    public Blockchain() {
        this.blocks = new ArrayList<>();
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public Block getBlock(int index) {
        return blocks.get(index);
    }

    public int getSize() {
        return blocks.size();
    }

    public String getLatestBlockHash() {
        if (blocks.isEmpty()) {
            return "0000000000000000"; // Genesis block hash
        } else {
            Block latestBlock = blocks.get(blocks.size() - 1);
            return latestBlock.getHash();
        }
    }

    public void setLatestBlockHash(String hash) {
        if (!blocks.isEmpty()) {
            blocks.get(blocks.size() - 1).setHash(hash);
        }
    }
}
