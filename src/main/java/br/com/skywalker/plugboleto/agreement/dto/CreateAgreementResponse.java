package br.com.skywalker.plugboleto.agreement.dto;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import br.com.skywalker.plugboleto.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class CreateAgreementResponse extends Response<CreateAgreementResponseData> {
    public CreateAgreementResponse(ResponseStatus status, String message, CreateAgreementResponseData data) {
        super(status, message, data);
    }
}

class CreateAgreementResponseData {
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
    @JsonFormat(pattern = DateUtil.DATE_TIME_OFFSET_ISO_FORMAT)
    private LocalDateTime creationDate;

    @JsonProperty("atualizado")
    @JsonFormat(pattern = DateUtil.DATE_TIME_OFFSET_ISO_FORMAT)
    private LocalDateTime lastUpdate;

    @JsonProperty("padraoCNAB")
    private String agreementCNABPattern;

    @JsonProperty("utiliza_van")
    private String agreementUseVan;

    @JsonProperty("numero_remessa")
    private String agreementShipmentNumber;

    @JsonProperty("_erro")
    private String error;
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