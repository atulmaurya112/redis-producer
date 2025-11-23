package com.learn.redis.serviceimpl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.learn.redis.dto.UserDto;

@Service
public class RedisProducerServiceImpl implements com.learn.redis.service.RedisProducerService {

	private static final Logger log = LoggerFactory.getLogger(RedisProducerServiceImpl.class);

	private RedisTemplate<String, Object> redisTemplate;
	
	public RedisProducerServiceImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void publishString(String channel, String message) {
		try {
			redisTemplate.convertAndSend(channel, message);
			log.info("Published String to channel '{}': {}", channel, message);
		} catch (Exception e) {
			log.error("Failed to publish String to '{}': {}", channel, e.getMessage());
		}
	}

	@Override
	public void publishDto(String channel, UserDto dto) {
		try {
			redisTemplate.convertAndSend(channel, dto);
			log.info("Published DTO to channel '{}': {}", channel, dto);
		} catch (Exception e) {
			log.error("Failed to publish DTO to '{}': {}", channel, e.getMessage());
		}
	}

	@Override
	public void publishMap(String channel, Map<String, Object> map) {
		try {
			redisTemplate.convertAndSend(channel, map);
			log.info("Published Map to channel '{}': {}", channel, map);
		} catch (Exception e) {
			log.error("Failed to publish Map to '{}': {}", channel, e.getMessage());
		}
	}

	@Override
	public void publishList(String channel, List<String> list) {
		try {
			redisTemplate.convertAndSend(channel, list);
			log.info("Published List to channel '{}': {}", channel, list);
		} catch (Exception e) {
			log.error("Failed to publish List to '{}': {}", channel, e.getMessage());
		}
	}

}