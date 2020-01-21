# Tecnospeed Client

Disclaimer: This is a _non official_ project. It is in no way associated 
to [Tecnospeed](https://tecnospeed.com.br/).

## TODO
[ ] Implement tests

## Usage example
```java
TecnoSpeed tecnoSpeed = TecnoSpeed.getInstance("asdasd", "asdad", Environment.SANDBOX);
TecnoSpeed tecnoSpeed = TecnoSpeed.getInstance();
Cedente cedente = Cedente.builder()
    ...
    .build();
Boleto boleto = Boleto.builder()
    ...
    .build();

tecnoSpeed.boletos().emitir(boleto);
```