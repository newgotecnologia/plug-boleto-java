package br.com.skywalker.plugboleto.shipment;

import br.com.skywalker.plugboleto.Registry;
import br.com.skywalker.plugboleto.common.Request;
import br.com.skywalker.plugboleto.shipment.dto.GenerateShipmentResponse;
import retrofit2.Retrofit;

import java.util.List;

public class ShipmentResource {
    public static final String SHIPMENT_SERVICE_KEY = "SHIPMENT_SERVICE";

    public ShipmentResource(Retrofit retrofit) {
        Registry.set(SHIPMENT_SERVICE_KEY, retrofit.create(ShipmentService.class));
    }

    public Request<GenerateShipmentResponse> sendEmail(List<String> integrationIds, String assignorFederalId) {
        return new Request<>(Registry.get(SHIPMENT_SERVICE_KEY, ShipmentService.class).sendEmail(integrationIds, assignorFederalId));
    }
}
