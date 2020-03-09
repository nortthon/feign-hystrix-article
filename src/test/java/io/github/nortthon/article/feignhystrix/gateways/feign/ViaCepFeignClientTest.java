package io.github.nortthon.article.feignhystrix.gateways.feign;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("ViaCep Feign Client Integration Tests")
public class ViaCepFeignClientTest {

  @Autowired
  public ViaCepFeignClient viaCepFeignClient;

  @Test
  @DisplayName("Find valid Postal Address Code (CEP)")
  public void findValidPostalAddressCode() {
    var cep = viaCepFeignClient.findCEP("01001000");

    assertFalse(cep.isErro());
    assertAll(
        () -> assertEquals("01001-000", cep.getCep()),
        () -> assertEquals("São Paulo", cep.getLocalidade()),
        () -> assertEquals("SP", cep.getUf())
    );
  }

  @Test
  @DisplayName("Find invalid Postal Address Code (CEP)")
  public void findInvalidPostalAddressCode() {
    var cep = viaCepFeignClient.findCEP("99999999");

    assertTrue(cep.isErro());
  }
}
