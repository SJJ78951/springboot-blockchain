package com.sjj.springboot.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjj.springboot.exception.ServerException;
import com.sjj.springboot.pojo.Block;
import com.sjj.springboot.service.IBlockchaninService;
import com.sjj.springboot.util.BlockchainUtil;
import com.sjj.springboot.util.ObjectMapperUtil;

@Service("blockchainServiceImpl")
public class BlockchainServiceImpl implements IBlockchaninService<Block> {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlockchainServiceImpl.class);
	private static List<Block> blockChain = new LinkedList<Block>();
	
	@Override
	public List<Block> createBlockchain(Block block) {
		// 判断是否创世块
		if(blockChain.size() == 0){
			block.setIndex(0);
			block.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			block.setPrevHash("");
			block.setHash(BlockchainUtil.calculateHash(block));
		}else{
			Block oldBlock = blockChain.get(blockChain.size()-1);
			block = BlockchainUtil.generateBlock(oldBlock, block.getVac());
			// 判断有效性
			if(!BlockchainUtil.isBlockValid(block, oldBlock)){
				throw new ServerException("计算区块链有效性失败");
			}
		}
		blockChain.add(block);
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String msg;
		try {
			msg = ObjectMapperUtil.getJsonMapper().writeValueAsString(block);
			LOGGER.debug("add blockChain:{}",msg);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return blockChain;
	}

	@Override
	public List<Block> getBlockchain() {
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String msg = gson.toJson(blockChain);
//		LOGGER.debug("get blockChain:{}",msg);
		return blockChain;
	}
	

}
