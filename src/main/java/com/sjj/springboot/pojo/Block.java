package com.sjj.springboot.pojo;

public class Block {
	/** 是这个块在整个链中的位置 */
	private int index;
	/** 块生成时的时间戳 */
	private String timestamp;
	/** 虚拟资产。我们要记录的数据 */
	private int vac;
	/** 是这个块通过 SHA256 算法生成的散列值 */
	private String hash;
	/** 指向前一个块的 SHA256 散列值 */
	private String prevHash;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getVac() {
		return vac;
	}

	public void setVac(int vac) {
		this.vac = vac;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPrevHash() {
		return prevHash;
	}

	public void setPrevHash(String prevHash) {
		this.prevHash = prevHash;
	}

}
