package com.venilry.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {
	/*
	 * RestTemplate提供了多种便捷访问远程Http服务的方法，是一种简单便捷的访问restful服务模板类，
	 * 是Spring提供的用于访问Rest服务的客户端模板工具集。
	 */
	@Bean
	@LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	// 如果没有显式地声明，则用默认的轮询算法，否则用显式的声明
	@Bean
	public IRule myRule() {
		return new RandomRule();// 达到的目的，用我们重新选择的随机算法替代默认的轮询。
	}

}
