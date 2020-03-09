package io.github.nortthon.article.feignhystrix.gateways.feign;

import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import io.github.nortthon.article.feignhystrix.gateways.contracts.AddressContract;
import io.github.nortthon.article.feignhystrix.gateways.feign.ViaCepFeignClient.ViaCepFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "${feign.viacep.url}", configuration = ViaCepFeignConfiguration.class)
public interface ViaCepFeignClient {

  @GetMapping("/ws/{cep}/json")
  AddressContract findCEP(@PathVariable String cep);

  class ViaCepFeignConfiguration {

    @Bean
    public Decoder decode() {
      return new JacksonDecoder();
    }
  }
}
