package com.sjj.springboot.service;

import java.util.List;

public interface IBlockchaninService<T> {

	public List<T> createBlockchain(T t);
	
	public List<T> getBlockchain();
}
