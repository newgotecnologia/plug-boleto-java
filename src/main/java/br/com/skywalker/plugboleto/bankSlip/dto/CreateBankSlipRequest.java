package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.Request;
import br.com.skywalker.plugboleto.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;
import retrofit2.Call;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBankSlipRequest {
    @JsonProperty("CedenteContaNumero")
    private String assignorAccountNumber;

    @JsonProperty("CedenteContaNumeroDV")
    private String assignorAccountNumberVerificationDigit;

    @JsonProperty("CedenteConvenioNumero")
    private String assignorAgreement;

    @JsonProperty("CedenteContaCodigoBanco")
    private String assignorAccountBankCode;

    @JsonProperty("SacadoCPFCNPJ")
    private String drawerFederalId;

    @JsonProperty("SacadoEmail")
    private String drawerEmail;

    @JsonProperty("SacadoEnderecoNumero")
    private String drawerAddressNumber;

    @JsonProperty("SacadoEnderecoBairro")
    private String drawerAddressNeighborhood;

    @JsonProperty("SacadoEnderecoCEP")
    private String drawerAddressZipCode;

    @JsonProperty("SacadoEnderecoCidade")
    private String drawerAddressCity;

    @JsonProperty("SacadoEnderecoComplemento")
    private String drawerAddressComplement;

    @JsonProperty("SacadoEnderecoLogradouro")
    private String drawerAddressPlace;

    @JsonProperty("SacadoEnderecoPais")
    private String drawerAddressCountry;

    @JsonProperty("SacadoEnderecoUF")
    private String drawerAddressStateAcronym;

    @JsonProperty("SacadoNome")
    private String drawerName;

    @JsonProperty("SacadoTelefone")
    private String drawerPhone;

    @JsonProperty("SacadoCelular")
    private String drawerCellPhone;

    @JsonProperty("TituloDataEmissao")
    private String titleIssueDate;

    @JsonProperty("TituloDataVencimento")
    private String titleExpirationDate;

    @JsonProperty("TituloMensagem01")
    private String titleMessage1;

    @JsonProperty("TituloMensagem02")
    private String titleMessage2;

    @JsonProperty("TituloMensagem03")
    private String titleMessage3;

    @JsonProperty("TituloNossoNumero")
    private String titleOurNumber;

    @JsonProperty("TituloDocEspecie")
    private String titleDocType;

    @JsonProperty("TituloNumeroDocumento")
    private String titleDocumentNumber;

    @JsonProperty("TituloValor")
    private String titleValue;

    @JsonProperty("TituloLocalPagamento")
    private String titlePaymentLocation;

    @JsonProperty("TituloCodBaixaDevolucao")
    private String titleReturnWriteOffCode;

    @JsonProperty("TituloPrazoBaixa")
    private String titleTermWriteOff;
}

/*
{
    "CedenteContaNumero": "54321",
    "CedenteContaNumeroDV": "0",
    "CedenteConvenioNumero": "321",
    "CedenteContaCodigoBanco": "341",
    "SacadoCPFCNPJ": "28436161661",
    "SacadoEmail": "email@sacado.com",
    "SacadoEnderecoNumero": "987",
    "SacadoEnderecoBairro": "Centro",
    "SacadoEnderecoCEP": "87098765",
    "SacadoEnderecoCidade": "Maringá",
    "SacadoEnderecoComplemento": "Fundos",
    "SacadoEnderecoLogradouro": "Rua teste, 987",
    "SacadoEnderecoPais": "Brasil",
    "SacadoEnderecoUF": "PR",
    "SacadoNome": "Teste de Souza",
    "SacadoTelefone": "4499999999",
    "SacadoCelular": "44999999999",
    "TituloDataEmissao": "01/01/2020",
    "TituloDataVencimento": "01/02/2020",
    "TituloMensagem01": "Juros de 0,01 ao dia",
    "TituloMensagem02": "Nao receber apos 30 dias de atraso",
    "TituloMensagem03": "Titulo sujeito a protesto apos 30 dias",
    "TituloNossoNumero": "6",
    "TituloNumeroDocumento": "01012020",
    "TituloValor": "0,02",
    "TituloLocalPagamento": "Pagável em qualquer banco até o vencimento."
}
*/