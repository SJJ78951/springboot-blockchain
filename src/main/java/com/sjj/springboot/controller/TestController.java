package com.sjj.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjj.springboot.User;
import com.sjj.springboot.pojo.Block;
import com.sjj.springboot.service.IBlockchaninService;

@RestController
public class TestController {

	@Value("${msg}")
	private String msg;

	@Autowired
	private User user;

	@Autowired
	private IBlockchaninService<Block> blockchainServiceImpl;

	@GetMapping("/api/{version}/helloworld1/")
	public String helloworld1() {
		System.out.println("==========进入controller1");
		return "hello world1," + msg + ",user:" + user.getName();
	}

	@GetMapping("/api/{version}/helloworld2/")
	public String helloworld2() {
		System.out.println("==========进入controller2");
		return "hello world2,";
	}

	@RequestMapping(value = "/api/{version}/blockchain/", consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public Object addBlockchain(@RequestBody Block block, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtils.isEmpty(block)) {
			return "没有消息输入";
		}
		if (StringUtils.isEmpty(block.getVac())) {
			return "vac值没有输入";
		}
		
		return blockchainServiceImpl.createBlockchain(block);
	}
	
	@RequestMapping(value = "/api/{version}/blockchain/", method = RequestMethod.GET)
	@ResponseBody
	public Object getBlockchain(HttpServletRequest request, HttpServletResponse response) {
		
		return blockchainServiceImpl.getBlockchain();
	}
}
