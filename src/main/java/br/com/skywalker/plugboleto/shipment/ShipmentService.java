package br.com.skywalker.plugboleto.shipment;

import br.com.skywalker.plugboleto.bankSlipEmail.dto.BankSlipEmailResponse;
import br.com.skywalker.plugboleto.shipment.dto.GenerateShipmentResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.util.List;

public interface ShipmentService {
    @POST(Endpoints.BASE + "/lote")
    Call<GenerateShipmentResponse> generateShipmentFile(@Body List<String> integrationIds, @Header("cnpj-cedente") String assignorFederalId);
}
