package br.com.skywalker.plugboleto.bankSlip;

import br.com.skywalker.plugboleto.bankSlip.dto.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface BankSlipService {
    @GET(Endpoints.BASE)
    Call<BankSlipPagedResponse> findAll(@Header("cnpj-cedente") String assignorFederalId);

    @POST(Endpoints.BASE + "/lote")
    Call<CreateBankSlipResponse> create(@Body List<CreateBankSlipRequest> body, @Header("cnpj-cedente") String assignorFederalId);

    @POST(Endpoints.BASE + "/altera/lote")
    Call<GenericProtocolResponse> update(@Body List<UpdateBankSlipRequest> body, @Header("cnpj-cedente") String assignorFederalId);

    @GET(Endpoints.BASE + "/altera/lote/{protocol}")
    Call<ShippingFileResponse> updateStatus(@Path("protocol") String protocol, @Header("cnpj-cedente") String assignorFederalId);

    @POST(Endpoints.BASE + "/baixa/lote")
    Call<GenericProtocolResponse> requestOutgoingShippingFile(@Body List<String> integrationIds, @Header("cnpj-cedente") String assignorFederalId);

    @POST(Endpoints.BASE + "/descarta/lote")
    Call<DiscardBankSlipResponse> discardBankSlips(@Body List<String> integrationIds, @Header("cnpj-cedente") String assignorFederalId);

    @GET(Endpoints.BASE + "/baixa/lote/{protocol}")
    Call<ShippingFileResponse> requestOutgoingShippingFileStatus(@Path("protocol") String protocol, @Header("cnpj-cedente") String assignorFederalId);

    @GET(Endpoints.BASE)
    Call<BankSlipPagedResponse> findByIntegrationId(@Query("idintegracao") String integrationId, @Header("cnpj-cedente") String assignorFederalId);

    @POST(Endpoints.BASE + "/impressao/lote")
    Call<ResponseBody> pdfRequest(@Body PrintBankSlipRequest body, @Header("cnpj-cedente") String assignorFederalId);

    // Here we return object because the API return a JSON with the request status or the PDF ot self
    @GET(Endpoints.BASE + "/impressao/lote/{protocol}")
    Call<ResponseBody> pdfRequestStatus(@Path("protocol") String protocol, @Header("cnpj-cedente") String assignorFederalId);
}
