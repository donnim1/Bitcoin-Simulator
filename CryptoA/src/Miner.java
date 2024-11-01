public class Miner {
    private String identifier;
    private Blockchain blockchain;

    public Miner(String identifier, Blockchain blockchain) {
        this.identifier = identifier;
        this.blockchain = blockchain;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public void mine(Transaction transaction) {
        // Simulated mining process
        int nonce = 0;
        String previousBlockHash = blockchain.getLatestBlockHash();
        String newBlockHash = calculateBlockHash(nonce, previousBlockHash, transaction);

        // Solve the proof-of-work puzzle
        while (!isValidBlockHash(newBlockHash)) {
            nonce++;
            newBlockHash = calculateBlockHash(nonce, previousBlockHash, transaction);
        }

        // Once a valid block hash is found, construct a new block and add it to the blockchain
        Block newBlock = new Block(previousBlockHash, newBlockHash, transaction);
        blockchain.addBlock(newBlock);

        // Update the latest block hash in the blockchain
        blockchain.setLatestBlockHash(newBlockHash);
    }


    private String calculateBlockHash(int nonce, String previousBlockHash, Transaction transaction) {
        // Simulated block hash calculation
        String data = nonce + previousBlockHash + transaction.toString();
        return simpleHash(data);
    }

    private boolean isValidBlockHash(String blockHash) {
        // Simulated validation of the block hash
        return blockHash.startsWith("0000"); // Simple proof-of-work condition
    }

    private String simpleHash(String data) {
        // Basic hash function - Sum of ASCII values of characters in the string
        int sum = 0;
        for (char c : data.toCharArray()) {
            sum += (int) c;
        }
        return Integer.toString(sum);
    }
}
