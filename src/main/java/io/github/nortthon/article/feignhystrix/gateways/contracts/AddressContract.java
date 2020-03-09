package io.github.nortthon.article.feignhystrix.gateways.contracts;

import lombok.Data;

@Data
public class AddressContract {
  private String cep;
  private String logradouro;
  private String bairro;
  private String localidade;
  private String uf;
  private boolean erro;
}
