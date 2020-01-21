package br.com.skywalker.plugboleto;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class PlugBoletoImpl extends PlugBoleto {

    private final Credentials credentials;
    private final Environment environment;

    // *****************************************************************************

}
