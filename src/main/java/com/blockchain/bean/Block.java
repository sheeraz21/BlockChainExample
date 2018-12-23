package com.blockchain.bean;

import java.util.List;

public class Block {
	
	public Block(int preivousHash, List<Transaction> transaction) {
		super();
		this.preivousHash = preivousHash;
		this.transaction = transaction;
	}
	private int preivousHash;
	List<Transaction> transaction;
	public int getPreivousHash() {
		return preivousHash;
	}
	public void setPreivousHash(int preivousHash) {
		this.preivousHash = preivousHash;
	}
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + preivousHash;
		result = prime * result
				+ ((transaction == null) ? 0 : transaction.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		if (preivousHash != other.preivousHash)
			return false;
		if (transaction == null) {
			if (other.transaction != null)
				return false;
		} else if (!transaction.equals(other.transaction))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Block [preivousHash=" + preivousHash + ", transaction="
				+ transaction + "]";
	}
	
	

}
