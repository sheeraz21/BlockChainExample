package com.blockchain.main;

import java.util.ArrayList;

import com.blockchain.bean.NBlock;
import com.blockchain.utill.BlockChainUtill;

public class NBChain {
	
	public static ArrayList<NBlock> blockchain = new ArrayList<NBlock>();
	public static int difficulty = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Trying to Mine block 1... ");
		addBlock(new NBlock("Hi im the first block", "0"));
		
		System.out.println("Trying to Mine block 2... ");
		addBlock(new NBlock("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
		
		System.out.println("Trying to Mine block 3... ");
		addBlock(new NBlock("Hey im the third block",blockchain.get(blockchain.size()-1).hash));	
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = BlockChainUtill.getJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);

	}

	public static Boolean isChainValid() {
		NBlock currentBlock; 
		NBlock previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			//check if hash is solved
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
			
		}
		return true;
	}
	
	public static void addBlock(NBlock newBlock) {
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
	}
	
	
}
