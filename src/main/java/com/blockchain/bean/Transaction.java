package com.blockchain.bean;

public class Transaction {
	
	private String sourceName;
	private String destinationName;
	private Long sum;
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public Long getSum() {
		return sum;
	}
	public void setSum(Long sum) {
		this.sum = sum;
	}
	public Transaction(String sourceName, String destinationName, Long sum) {
		super();
		this.sourceName = sourceName;
		this.destinationName = destinationName;
		this.sum = sum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destinationName == null) ? 0 : destinationName.hashCode());
		result = prime * result
				+ ((sourceName == null) ? 0 : sourceName.hashCode());
		result = prime * result + ((sum == null) ? 0 : sum.hashCode());
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
		Transaction other = (Transaction) obj;
		if (destinationName == null) {
			if (other.destinationName != null)
				return false;
		} else if (!destinationName.equals(other.destinationName))
			return false;
		if (sourceName == null) {
			if (other.sourceName != null)
				return false;
		} else if (!sourceName.equals(other.sourceName))
			return false;
		if (sum == null) {
			if (other.sum != null)
				return false;
		} else if (!sum.equals(other.sum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [sourceName=" + sourceName + ", destinationName="
				+ destinationName + ", sum=" + sum + "]";
	}
	
	

}
