package br.com.skywalker.plugboleto;

import br.com.skywalker.plugboleto.account.AccountResource;
import br.com.skywalker.plugboleto.agreement.AgreementResource;
import br.com.skywalker.plugboleto.assignor.AssignorResource;
import br.com.skywalker.plugboleto.bankSlip.BankSlipResource;
import br.com.skywalker.plugboleto.bankSlipEmail.BankSlipEmailResource;
import br.com.skywalker.plugboleto.returns.ReturnResource;
import br.com.skywalker.plugboleto.shipment.ShipmentResource;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

class PlugBoletoImpl extends PlugBoleto {

    private final Credentials credentials;
    private final Environment environment;

    private final Retrofit retrofitInstance;

    PlugBoletoImpl(Credentials credentials, Environment environment) {
        this.credentials = credentials;
        this.environment = environment;

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor((chain) -> {
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .addHeader("cnpj-sh", credentials.getShCnpj())
                            .addHeader("token-sh", credentials.getShToken())
                            .build();

                    return chain.proceed(newRequest);
                })
                .build();

        retrofitInstance = new Retrofit.Builder()
                .baseUrl(environment.getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
    }

    // *****************************************************************************

    public AssignorResource assignors() {
        return new AssignorResource(retrofitInstance);
    }

    @Override
    public AccountResource accounts() { return new AccountResource(retrofitInstance); }

    @Override
    public AgreementResource agreements() { return new AgreementResource(retrofitInstance); }

    @Override
    public BankSlipResource bankSlips() { return new BankSlipResource(retrofitInstance); }

    @Override
    public BankSlipEmailResource bankSlipEmails() { return new BankSlipEmailResource(retrofitInstance); }

    @Override
    public ReturnResource returns() { return new ReturnResource(retrofitInstance); }

    @Override
    public ShipmentResource shipments() { return new ShipmentResource(retrofitInstance); }
}
