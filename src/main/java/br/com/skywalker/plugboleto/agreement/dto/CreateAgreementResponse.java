package br.com.skywalker.plugboleto.agreement.dto;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import br.com.skywalker.plugboleto.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAgreementResponse extends Response<CreateAgreementResponse.CreateAgreementResponseData> {
    public CreateAgreementResponse(ResponseStatus status, String message, CreateAgreementResponseData data) {
        super(status, message, data);
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreateAgreementResponseData {
        @JsonProperty("id")
        private long id;

        @JsonProperty("numero_convenio")
        private String agreementNumber;

        @JsonProperty("descricao_convenio")
        private String agreementDescription;

        @JsonProperty("carteira")
        private String agreementWallet;

        @JsonProperty("especie")
        private String agreementCash;

        @JsonProperty("id_conta")
        private String agreementAccountId;

        @JsonProperty("criado")
        private String creationDate;

        @JsonProperty("atualizado")
        private String lastUpdate;

        @JsonProperty("padraoCNAB")
        private String agreementCNABPattern;

        @JsonProperty("utiliza_van")
        private String agreementUseVan;

        @JsonProperty("numero_remessa")
        private String agreementShipmentNumber;

        @JsonProperty("_erro")
        private String error;

        public LocalDateTime getCreationDate(){ return DateUtil.fromStringToLocalDateTime(this.creationDate); }
        public LocalDateTime getLastUpdate(){ return DateUtil.fromStringToLocalDateTime(this.lastUpdate); }
    }
}

/*
    "id": 154,
    "numero_convenio": "7889604745",
    "descricao_convenio": "Convenio da tecnospeed",
    "carteira": "109",
    "especie": "R$",
    "id_conta": 168,
    "criado": "2017-03-30T18:01:19.000Z",
    "atualizado": "2017-03-30T18:01:19.000Z",
    "padraoCNAB": "400",
    "utiliza_van": false, => Define se o convênio irá ou não utilizar a transmissão automática de remessa e retorno.
    "numero_remessa": 1
    "_erro": "Conta do Cedente não encontrada"
*/