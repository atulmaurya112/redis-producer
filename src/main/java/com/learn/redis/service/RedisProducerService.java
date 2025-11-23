package com.learn.redis.service;

import java.util.List;
import java.util.Map;

import com.learn.redis.dto.UserDto;

public interface RedisProducerService {

	void publishString(String channel, String message);

	void publishDto(String channel, UserDto dto);

	void publishMap(String channel, Map<String, Object> map);

	void publishList(String channel, List<String> list);

}
