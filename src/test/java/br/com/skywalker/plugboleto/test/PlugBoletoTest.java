package br.com.skywalker.plugboleto.test;

import br.com.skywalker.plugboleto.PlugBoleto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import static org.junit.Assert.*;

public class PlugBoletoTest {

    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @Test
    public void whenCallingGetInstanceWithoutSetVariables_shouldThrowException() {
        Exception exception = assertThrows(InstantiationException.class, PlugBoleto::getInstance);

        String unsetEnvVarName = "PB_SH_CNPJ";
        assertTrue(exception.getMessage().contains(unsetEnvVarName));
    }

    @Test
    public void whenCallingGetInstanceWithoutSHToken_shouldThrowException() {
        environmentVariables.set("PB_SH_CNPJ", "unneeded");
        Exception exception = assertThrows(InstantiationException.class, PlugBoleto::getInstance);

        String unsetEnvVarName = "PB_SH_TOKEN";
        assertTrue(exception.getMessage().contains(unsetEnvVarName));
    }

    @Test
    public void whenCallingGetInstanceWithoutEnvTypeVariables_shouldThrowException() {
        environmentVariables.set("PB_SH_CNPJ", "unneeded");
        environmentVariables.set("PB_SH_TOKEN", "unneeded");
        Exception exception = assertThrows(InstantiationException.class, PlugBoleto::getInstance);

        String unsetEnvVarName = "PB_ENVIRONMENT";
        assertTrue(exception.getMessage().contains(unsetEnvVarName));
    }

    @Test
    public void whenCallingGetInstanceWithSetVariables_shouldNotThrow() throws InstantiationException {
        environmentVariables.set("PB_SH_CNPJ", "unneeded");
        environmentVariables.set("PB_SH_TOKEN", "unneeded");
        environmentVariables.set("PB_ENVIRONMENT", "homologation");

        PlugBoleto plugBoleto = PlugBoleto.getInstance();
        assertNotNull(plugBoleto);
    }

}
