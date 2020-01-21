package br.com.skywalker.plugboleto;

public abstract class PlugBoleto {
    private static final String SH_CNPJ_ENV_VAR_NAME = "PB_SH_CNPJ";
    private static final String SH_TOKEN_ENV_VAR_NAME = "PB_SH_TOKEN";
    private static final String ENV_TYPE_VAR_NAME = "PB_ENVIRONMENT";

    public static PlugBoleto getInstance() throws InstantiationException {
        String shCnpj = System.getenv(SH_CNPJ_ENV_VAR_NAME);

        if (null == shCnpj) {
            String errorMessage = String.format("The software house CNPJ wasn't passed as parameter" +
                    " neither as an environment var (named '%s')", SH_CNPJ_ENV_VAR_NAME);
            throw new InstantiationException(errorMessage);
        }

        String shToken = System.getenv(SH_TOKEN_ENV_VAR_NAME);

        if (null == shToken) {
            String errorMessage = String.format("The software house token wasn't passed as parameter" +
                    " neither as an environment var (named '%s')", SH_TOKEN_ENV_VAR_NAME);
            throw new InstantiationException(errorMessage);
        }

        String envType = System.getenv(ENV_TYPE_VAR_NAME);

        if (null == envType) {
            String errorMessage = String.format("The environment wasn't passed as parameter" +
                    " neither as an environment var (named '%s')", ENV_TYPE_VAR_NAME);
            throw new InstantiationException(errorMessage);
        }

        Environment environment = Environment.forValue(envType);
        return PlugBoleto.getInstance(shCnpj, shToken, environment);
    }

    public static PlugBoleto getInstance(String shCnpj, String shToken, Environment environment) {
        return new PlugBoletoImpl(new Credentials(shToken, shCnpj), environment);
    }

    // *****************************************************************************


}
