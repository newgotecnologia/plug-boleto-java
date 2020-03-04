package br.com.skywalker.plugboleto.bankSlipEmail.dto;

import br.com.skywalker.plugboleto.common.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.Call;

import java.util.List;

public class BankSlipEmailRequest extends Request<BankSlipEmailRequest> {
    @JsonProperty("IdIntegracao")
    private List<String> integrationIds;

    @JsonProperty("EmailNomeRemetente")
    private String emailSenderName;

    @JsonProperty("EmailRemetente")
    private String emailSender;

    @JsonProperty("EmailAssunto")
    private String emailSubject;

    @JsonProperty("EmailConteudoHtml")
    private boolean emailHtmlContent;

    @JsonProperty("EmailMensagem")
    private boolean emailMessage;

    @JsonProperty("EmailDestinatario")
    private List<String> emailsReceivers;

    @JsonProperty("EmailCco")
    private List<String> emailsHiddenCopy;

    @JsonProperty("EmailAnexarBoleto")
    private boolean emailAttachBankSlip;

    @JsonProperty("Anexos")
    private List<MailBankSlipRequestAnnex> annexes;

    public BankSlipEmailRequest(Call<BankSlipEmailRequest> call) {
        super(call);
    }
}

class MailBankSlipRequestAnnex {
    @JsonProperty("Arquivo")
    private byte[] archive;

    @JsonProperty("Nome")
    private String archiveName;
}

/*
Request example
{
  "IdIntegracao": [
    "rkx50Eo2Wg",
    "ByeacqED3l",
    "HJgxLQAWWe"
  ],
  "EmailNomeRemetente": "Empresa Exemplo",
  "EmailRemetente": "exemplo@remetente.com.br",
  "EmailAssunto": "Boleto para pagamento",
  "EmailConteudoHtml": true,
  "EmailMensagem": "Segue o link do boleto:<br> ${linkBoleto}<br>Considere não imprimir este  email.<br><b>Código HTML dentro da Tag</b>",
  "EmailDestinatario": [
    "email1@tecnospeed.com.br",
    "email2@tecnospeed.com.br"
  ],
  "EmailCco": [
    "cco@tecnospeed.com.br",
    "cco2@tecnospeed.com.br"
  ],
  "EmailAnexarBoleto": true,
  "Anexos": [
    {
      "Arquivo": "base64",
      "Nome": "nome.extensão do arquivo"
    },
    {
      "Arquivo": "base64",
      "Nome": "nome.extensão do arquivo2"
    }
  ]
}
*/