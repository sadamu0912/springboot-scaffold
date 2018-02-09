package com.xjx.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
// 通过 EnableWebSocketMessageBroker 开启使用 STOMP 协设来传输基于代理 (message broker) 的消息，此时浏览器支持使用 @MessageMapping 就像@RequestMapping
public class WebSocketConfig  extends AbstractWebSocketMessageBrokerConfigurer{
	@Override
		public void registerStompEndpoints(StompEndpointRegistry registry) { //endPoint  注册协议节点，并映射指定的 URl
		// 注 册 一 个stomp 协 议 的endpoint 并 指 定SockJS协议
		registry.addEndpoint("/endpointBroadcast").withSockJS();
		registry.addEndpoint("/endpointP2P").withSockJS();
		}
	
}