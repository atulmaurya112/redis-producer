package com.learn.redis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.redis.dto.UserDto;
import com.learn.redis.service.RedisProducerService;

@RestController
public class RedisProducerController {

	private RedisProducerService service;

	public RedisProducerController(RedisProducerService service) {
		this.service = service;
	}

	@PostMapping("/string")
	public String sendString(@RequestParam String msg) {
		service.publishString("string-channel", msg);
		return "String sent";
	}

	@PostMapping("/dto")
	public String sendDto(@RequestBody UserDto dto) {
		service.publishDto("dto-channel", dto);
		return "DTO sent";
	}

	@PostMapping("/map")
	public String sendMap(@RequestBody Map<String, Object> map) {
		service.publishMap("map-channel", map);
		return "Map sent";
	}

	@PostMapping("/list")
	public String sendList(@RequestBody List<String> list) {
		service.publishList("list-channel", list);
		return "List sent";
	}

}
