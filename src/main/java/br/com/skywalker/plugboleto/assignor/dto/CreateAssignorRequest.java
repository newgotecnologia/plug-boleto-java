package br.com.skywalker.plugboleto.assignor.dto;

import br.com.skywalker.plugboleto.common.Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import retrofit2.Call;

@Getter
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAssignorRequest {
    @JsonProperty("CedenteRazaoSocial")
    private String transferorCorporateName;

    @JsonProperty("CedenteNomeFantasia")
    private String transferorBrandingName;

    @JsonProperty("CedenteCPFCNPJ")
    private String transferorFederalid;

    @JsonProperty("CedenteEnderecoLogradouro")
    private String transferorAddressStreet;

    @JsonProperty("CedenteEnderecoNumero")
    private String transferorAddressNumber;

    @JsonProperty("CedenteEnderecoComplemento")
    private String transferorAddressComplement;

    @JsonProperty("CedenteEnderecoBairro")
    private String transferorAddressNeighborhood;

    @JsonProperty("CedenteEnderecoCEP")
    private String transferorAddressZipCode;

    @JsonProperty("CedenteEnderecoCidadeIBGE")
    private String transferorAddressCityIBGECode;

    @JsonProperty("CedenteTelefone")
    private String transferorPhone;

    @JsonProperty("CedenteEmail")
    private String transferorEmail;

}

/*
  "CedenteRazaoSocial": "Empresa Ltda",
  "CedenteNomeFantasia": "Empresa",
  "CedenteCPFCNPJ": "14868336000185",
  "CedenteEnderecoLogradouro": "Av. Analista Jucá de Souza",
  "CedenteEnderecoNumero": "123",
  "CedenteEnderecoComplemento": "sala 987",
  "CedenteEnderecoBairro": "Centro",
  "CedenteEnderecoCEP": "87012345",
  "CedenteEnderecoCidadeIBGE": "4115200",
  "CedenteTelefone": "(44) 3033-1234",
  "CedenteEmail": "cobranca@boleto.com.br"
*/
