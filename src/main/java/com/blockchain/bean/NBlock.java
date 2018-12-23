package com.blockchain.bean;

import java.io.Serializable;
import java.util.Date;

import com.blockchain.utill.BlockChainUtill;

public class NBlock implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String hash;
	public String previousHash;
	private String data; 
	private long timeStamp;
	private int nonce;
	
	
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
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
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result
				+ ((previousHash == null) ? 0 : previousHash.hashCode());
		result = prime * result + (int) (timeStamp ^ (timeStamp >>> 32));
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
		NBlock other = (NBlock) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (previousHash == null) {
			if (other.previousHash != null)
				return false;
		} else if (!previousHash.equals(other.previousHash))
			return false;
		if (timeStamp != other.timeStamp)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NBlock [hash=" + hash + ", previousHash=" + previousHash
				+ ", data=" + data + ", timeStamp=" + timeStamp + "]";
	}
	public NBlock(String data,String previousHash) {
		super();
		this.hash = calculateHash();
		this.previousHash = previousHash;
		this.data = data;
		this.timeStamp = new Date().getTime();;
	} 
	
	public String calculateHash() {
		String calculatedhash = BlockChainUtill.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				data 
				);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}

}
