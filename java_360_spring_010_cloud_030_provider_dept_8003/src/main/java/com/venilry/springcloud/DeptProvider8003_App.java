package com.venilry.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/*
 * Eureka的自我保护机制：好死不如赖活着。
 * 即某时刻某个微服务不可用了，eureka不会立刻清理，依旧会对该微服务的信息进行保存。
 * 
 * 默认情况下，如果eureka server在一定时间内没有接受到某个微服务实例的心跳，eureka server将会注销该实例（默认90秒）。但是当网络分区故障发生时，
 * 微服务与eureka server之间无法正常通信，以上行为可能变得非常危险了——因为微服务本身其实是健康的，此时不应该注销这个微服务。eureka通过“自我保护模式”来解决
 * 这个问题——当eureka server节点在短时间内丢失过多客户端时（此时可能发生了网络分区故障），那么这个节点就会进入自我保护模式。一旦进入该模式，eureka server就会
 * 保护服务注册表中的信息，不再删除服务注册表中的数据（也就是不会注销任何微服务）。当网络故障恢复后，该eureka server节点会自动退出自我保护模式。
 * 
 * 在自我保护模式中，eureka server会保护服务注册表中的信息，不再注销任何服务实例。当它收到的心跳数重新恢复到阈值以上时，该eureka server节点就会自动退出自我保护模式。
 * 它的设计哲学就是宁可保留错误的服务注册信息，也不盲目注销任何可能健康的服务实例。一句话讲解：好死不如赖活着。
 * 
 * 综上，自我保护模式是一种应对网络异常的安全保护措施。它的架构哲学是宁可同时保留所有微服务（健康的和不健康的微服务都会保留），也不盲目注销任何健康的微服务。使用自我
 * 保护模式，可以让eureka集群更加的健壮，稳定。
 * 
 * 在spring cloud中，可以使用eureka.server.enable-self-preservation=false禁用自我保护模式。
 */
@SpringBootApplication
@EnableEurekaClient//本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
public class DeptProvider8003_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8003_App.class, args);
	}
}
