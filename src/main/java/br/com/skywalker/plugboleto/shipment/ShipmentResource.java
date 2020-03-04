package br.com.skywalker.plugboleto.shipment;

import br.com.skywalker.plugboleto.Registry;
import br.com.skywalker.plugboleto.common.Request;
import br.com.skywalker.plugboleto.shipment.dto.GenerateShipmentResponse;
import retrofit2.Retrofit;

import java.util.List;

public class ShipmentResource {
    public static final String ACCOUNT_SERVICE_KEY = "ACCOUNT_SERVICE";

    public ShipmentResource(Retrofit retrofit) {
        Registry.set(ACCOUNT_SERVICE_KEY, retrofit.create(ShipmentService.class));
    }

    public Request<GenerateShipmentResponse> sendEmail(List<String> integrationIds, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, ShipmentService.class).sendEmail(integrationIds, assignorFederalId));
    }
}
