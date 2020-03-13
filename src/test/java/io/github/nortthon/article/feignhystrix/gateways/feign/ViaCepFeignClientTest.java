package io.github.nortthon.article.feignhystrix.gateways.feign;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
