package br.com.skywalker.plugboleto;

import br.com.skywalker.plugboleto.account.AccountResource;
import br.com.skywalker.plugboleto.agreement.AgreementResource;
import br.com.skywalker.plugboleto.assignor.AssignorResource;
import br.com.skywalker.plugboleto.bankSlip.BankSlipResource;
import br.com.skywalker.plugboleto.bankSlipEmail.BankSlipEmailResource;
import br.com.skywalker.plugboleto.returns.ReturnResource;
import br.com.skywalker.plugboleto.shipment.ShipmentResource;

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

    public abstract AssignorResource assignors();
    public abstract AccountResource accounts();
    public abstract AgreementResource agreements();
    public abstract BankSlipResource bankSlips();
    public abstract BankSlipEmailResource bankSlipEmails();
    public abstract ReturnResource returns();
    public abstract ShipmentResource shipments();

}
