package io.github.nortthon.article.feignhystrix.configs;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("io.github.nortthon.article.feignhystrix.gateways.feign")
public class FeignConfiguration {

//  @Bean
//  public Decoder decoder() {
//    // Decoder Implementation
//  }
}
