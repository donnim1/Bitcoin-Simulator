public class Main {
    public static void main(String[] args) {
        // Create network, agents, and blockchain
        try {

            Network network = new Network();
            Agent agent1 = new Agent("Agent 1");
            Agent agent2 = new Agent("Agent 2");
            Agent agent3 = new Agent("Agent 3");
            Blockchain blockchain = new Blockchain();

            // Add agents to the network
            network.addAgent(agent1);
            network.addAgent(agent2);
            network.addAgent(agent3);

            // Create miners with the blockchain instance
            Miner miner1 = new Miner("Miner 1", blockchain);
            Miner miner2 = new Miner("Miner 2", blockchain);

            // Add miners to the network
            network.addMiner(miner1);
            network.addMiner(miner2);

            // Simulate transactions
            network.simulateTransaction(agent1, agent2, 5.0);
            network.simulateTransaction(agent2, agent3, 3.0);
            network.simulateTransaction(agent3, agent1, 2.0);

            // Simulate mining
            network.simulateMining(miner1, agent1.getTransactionHistory().get(0));
            network.simulateMining(miner2, agent2.getTransactionHistory().get(0));

            // Print balances and blockchain
            network.printBalances();
            network.printBlockchain();}
        catch (IndexOutOfBoundsException e){}
    }
}