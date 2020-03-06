package br.com.skywalker.plugboleto.assignor.dto;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import br.com.skywalker.plugboleto.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class CreateAssignorResponse extends Response<CreateAssignorResponseData> {
    public CreateAssignorResponse(ResponseStatus status, String message, CreateAssignorResponseData data) {
        super(status, message, data);
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

class CreateAssignorResponseData {
    @JsonProperty("id")
    private long id;

    @JsonProperty("razaosocial")
    private String companyName;

    @JsonProperty("nomefantasia")
    private String tradingName;

    @JsonProperty("cpf_cnpj")
    private String federalId;

    @JsonProperty("logradouro")
    private String addressStreet;

    @JsonProperty("numero")
    private String addressNumber;

    @JsonProperty("complemento")
    private String addressComplement;

    @JsonProperty("bairro")
    private String addressNeighborhood;

    @JsonProperty("cep")
    private String addressZipCode;

    @JsonProperty("id_cidade")
    private String addressCityIBGECode;

    @JsonProperty("telefone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("criado")
    private String creationDate;

    @JsonProperty("atualizado")
    private String lastUpdate;

    @JsonProperty("token_cedente")
    private String transferorToken;

    @JsonProperty("token_esales")
    private String eSalesToken;

    @JsonProperty("situacao")
    private String status;

    @JsonProperty("id_software_house")
    private long softwareHouseId;

    @JsonProperty("config_email")
    private String emailConfiguration;

    @JsonProperty("config_notificacao")
    private String notificationConfiguration;

    @JsonProperty("motivo_inativacao")
    private String inactivationReason;

    @JsonProperty("data_ativacao")
    private String activationDate;

    @JsonProperty("data_inativacao")
    private String inactivationDate;

    @JsonProperty("certificado")
    private String certified;

    @JsonProperty("dtvencimentocertificado")
    @JsonFormat(pattern = DateUtil.DATE_TIME_OFFSET_ISO_FORMAT)
    private String certifiedExpirationDate;

    @JsonProperty("uf")
    private String addressSate;

    @JsonProperty("contas")
    private List<String> accounts;

    @JsonProperty("cidadeibge")
    private long addressIBGECode;

    @JsonProperty("cidade")
    private String addressCity;

    public LocalDateTime getCreationDate(){ return DateUtil.fromStringToLocalDateTime(this.creationDate); }
    public LocalDateTime getLastUpdate(String date){ return DateUtil.fromStringToLocalDateTime(this.lastUpdate); }
    public LocalDateTime getInactivationDate(String date){ return DateUtil.fromStringToLocalDateTime(this.inactivationDate); }
    public LocalDateTime getCertifiedExpirationDate(String date){ return DateUtil.fromStringToLocalDateTime(this.certifiedExpirationDate); }
}

/*
    "id": 728,
    "razaosocial": "Empresa Ltda",
    "nomefantasia": "Empresa",
    "cpf_cnpj": "20841251000106",
    "logradouro": "Av. Analista Jucá de Souza",
    "numero": "123",
    "complemento": "sala 987",
    "bairro": "Centro",
    "cep": "87012345",
    "id_cidade": 2136,
    "telefone": "4430331234",
    "email": "cobranca@boleto.com.br",
    "criado": "2018-05-16T19:13:30Z",
    "atualizado": "2018-05-16T19:13:30Z",
    "token_cedente": "9d03331b377ab63d5f070206059686ae",
    "token_esales": "0",
    "situacao": "ATIVO",
    "id_software_house": 23,
    "config_email": null,
    "config_notificacao": null,
    "motivo_inativacao": null,
    "data_ativacao": "2018-05-16T19:13:30Z",
    "data_inativacao": null,
    "certificado": null,
    "dtvencimentocertificado": null,
    "uf": "PR",
    "contas": [],
    "cidadeibge": 4115200,
    "cidade": "Maringá"
*/