package br.com.skywalker.plugboleto.bankSlip;

import br.com.skywalker.plugboleto.Registry;
import br.com.skywalker.plugboleto.bankSlip.dto.*;
import br.com.skywalker.plugboleto.common.Request;
import br.com.skywalker.plugboleto.exception.ConvertionException;
import br.com.skywalker.plugboleto.exception.RequestFailed;
import br.com.skywalker.plugboleto.exception.ValidationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class BankSlipResource {
    public static final String ACCOUNT_SERVICE_KEY = "BANK_SLIP_SERVICE";

    public BankSlipResource(Retrofit retrofit) {
        Registry.set(ACCOUNT_SERVICE_KEY, retrofit.create(BankSlipService.class));
    }

    public Request<BankSlipPagedResponse> findAll(String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).findAll(assignorFederalId));
    }

    public Request<BankSlipPagedResponse> findAll(long pageNum, long pageSize, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).findAll(assignorFederalId));
    }

    public Request<BankSlipPagedResponse> findById(String integrationId, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).findByIntegrationId(integrationId, assignorFederalId));
    }

    public Request<CreateBankSlipResponse> create(List<CreateBankSlipRequest> bankSlips, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).create(bankSlips, assignorFederalId));
    }

    public Request<GenericProtocolResponse> update(List<UpdateBankSlipRequest> bankSlips, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).update(bankSlips, assignorFederalId));
    }

    public Request<ShippingFileResponse> updateStatus(String protocol, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).updateStatus(protocol, assignorFederalId));
    }

    public Request<GenericProtocolResponse> requestOutgoingShippingFile(List<String> integrationIds, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).requestOutgoingShippingFile(integrationIds, assignorFederalId));
    }

    public Request<ShippingFileResponse> requestOutgoingShippingFileStatus(String protocol, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).requestOutgoingShippingFileStatus(protocol, assignorFederalId));
    }

    public Object pdfRequest(PrintBankSlipRequest request, String assignorFederalId) {
        ObjectMapper mapper = new ObjectMapper();
        Request<ResponseBody> pdfRequest = new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).pdfRequest(request, assignorFederalId));
        try {
            ResponseBody response = pdfRequest.execute();
            try {
                PrintBankSlipResponse printBankSlipResponse = mapper.readValue(response.string(), PrintBankSlipResponse.class);
                if(printBankSlipResponse.getData() instanceof List)
                    return null;
                else
                    return printBankSlipResponse;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public byte[] pdfRequestStatus(String protocol, String assignorFederalId) {
        try {
            ResponseBody responseBody = new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).pdfRequestStatus(protocol, assignorFederalId)).execute();
            if (responseBody.contentType().toString().equals("application/pdf")) {
                return responseBody.bytes();
            } else {
                return null;
            }
        } catch (RequestFailed | ConvertionException | IOException | ValidationException requestFailed) {
            requestFailed.printStackTrace();
        }

        return null;
    }

    public Request delete(List<String> integrationIds, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipService.class).discardBankSlips(integrationIds, assignorFederalId));
    }
}
