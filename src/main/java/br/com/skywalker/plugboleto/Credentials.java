package br.com.skywalker.plugboleto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class Credentials {

    private final String shToken;
    private final String shCnpj;

}
