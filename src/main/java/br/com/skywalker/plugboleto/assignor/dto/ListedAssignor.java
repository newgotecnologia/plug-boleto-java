package br.com.skywalker.plugboleto.assignor.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListedAssignor {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("razaosocial")
    private String companyName;

    @JsonProperty("nomefantasia")
    private String tradingName;

    @JsonProperty("cpf_cnpj")
    private String document;

    private Address address = new Address();

    @JsonProperty("logradouro")
    void setStreet(String street) {
        this.address.street = street;
    }

    @JsonProperty("numero")
    void setNumber(String number) {
        this.address.number = number;
    }

    @JsonProperty("complemento")
    void setComplement(String complement) {
        this.address.complement = complement;
    }

    @JsonProperty("bairro")
    void setDistrict(String district) {
        this.address.district = district;
    }

    @JsonProperty("cep")
    void setZipCode(String zipCode) {
        this.address.zipCode = zipCode;
    }

    @JsonProperty("id_cidade")
    void setCityId(Long cityId) {
        this.address.cityId = cityId;
    }


    @Getter
    public static class Address {
        private String street, number, district, complement, zipCode;
        private Long cityId;
        Address() {}
    }
}

/*
    "telefone": "9999999999",
    "email": "emaildetestes@gmail.com",
    "criado": "2019-12-27T12:17:01.000Z",
    "atualizado": "2019-12-27T12:17:01.000Z",
    "token_cedente": "71117fdc8a55f61b41580edbe46a8426",
    "token_esales": "0",
    "situacao": "ATIVO",
    "id_software_house": 23,
    "config_email": null,
    "config_notificacao": null,
    "motivo_inativacao": null,
    "data_ativacao": "2019-12-27T12:17:01.000Z",
    "data_inativacao": null,
    "certificado": null,
    "dtvencimentocertificado": null,
    "config_webhook": null,
    "linha_digitavel_recibo": null,
    "token_intermediadora": null,
    "uf": "MG",
*/
