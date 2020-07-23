package br.com.skywalker.plugboleto.agreement.dto;

import br.com.skywalker.plugboleto.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListedAgreement {
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

    @JsonProperty("densidade_remessa")
    private String agreementShipmentDensity;

    @JsonProperty("codigo_cobranca")
    private String agreementChargingCode;

    @JsonProperty("reiniciar_diariamente")
    private String agreementDailyReset;

    @JsonProperty("registro_automatico")
    private String agreementAutomaticRegister;

    @JsonProperty("estacao")
    private String agreementStation;

    @JsonProperty("ativo")
    private boolean active;

    @JsonProperty("nossonumero_controle_banco")
    private String agreementOurNumberBankControl;

    @JsonProperty("api_id")
    private String agreementApiId;

    @JsonProperty("api_key")
    private String agreementApiKey;

    @JsonProperty("api_secret")
    private String agreementApiSecret;

    @JsonProperty("tipo_webservice")
    private String agreementWebServiceType;

    public LocalDateTime getCreationDate() { return DateUtil.fromStringToLocalDateTime(this.creationDate); }
    public LocalDateTime getLastUpdate() { return DateUtil.fromStringToLocalDateTime(this.lastUpdate); }
}

/*
    "id": 3581,
    "numero_convenio": "2101684",
    "descricao_convenio": "Carteira de exemplo",
    "carteira": "17",
    "especie": "R$",
    "id_conta": 5261,
    "criado": "2019-08-13T14:49:49.000Z",
    "atualizado": "2019-08-13T14:49:49.000Z",
    "padraoCNAB": "240",
    "utiliza_van": false,
    "numero_remessa": null,
    "densidade_remessa": null,
    "codigo_cobranca": null,
    "reiniciar_diariamente": true,
    "registro_automatico": false,
    "estacao": null,
    "ativo": true,
    "nossonumero_controle_banco": null,
    "api_id": null,
    "api_key": null,
    "api_secret": null,
    "tipo_webservice": null
*/