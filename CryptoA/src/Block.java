public class Block {
    private String hash;
    private String previousHash;
    private Transaction transaction;

    public Block(String previousHash, String previousBlockHash, Transaction transaction) {
        this.previousHash = previousHash;
        this.transaction = transaction;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
