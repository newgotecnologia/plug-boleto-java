package br.com.skywalker.plugboleto;

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

}
