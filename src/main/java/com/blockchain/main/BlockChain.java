package com.blockchain.main;

import java.util.Arrays;

import com.blockchain.bean.Block;
import com.blockchain.bean.Transaction;

/**
 * Block Chain Main Class 
 *
 */
public class BlockChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* BlockChain
		 * Block - Hash of previous Block + Transaction 
		 * Chained together
		 * 
		 * */
		
		Transaction transaction = new Transaction("Rahul","Prem",100L);
		Transaction transaction1 = new Transaction("Sam","Peter",1000L);
		Transaction transaction2 = new Transaction("Vijay","Sanjay",300L);
		
		Block firstBlock = new Block(0,Arrays.asList(transaction));
		System.out.println("First Value " + firstBlock.hashCode());
		Block firstBlock1 = new Block(0,Arrays.asList(transaction1));
		System.out.println("Secound Value "  +  firstBlock1.hashCode());
		Block firstBlock2 = new Block(0,Arrays.asList(transaction2));
		System.out.println("Third Value "  +  firstBlock2.hashCode());
		
		
		
		
	}

}