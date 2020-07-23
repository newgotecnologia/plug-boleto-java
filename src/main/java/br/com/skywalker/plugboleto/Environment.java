package br.com.skywalker.plugboleto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum Environment {
    HOMOLOGATION("http://homologacao.plugboleto.com.br/api/"), PRODUCTION("https://plugboleto.com.br/api/");

    private String baseUrl;

    public static Environment forValue(String value) throws InstantiationException {
        for (Environment environment : Environment.values()) {
            if (environment.name().equalsIgnoreCase(value)) {
                return environment;
            }
        }

        throw new InstantiationException("Inexistent environment type '" + value + "'");
    }
}
