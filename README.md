# Tecnospeed Client

Disclaimer: This is a _non official_ project. It is in no way associated 
to [Tecnospeed](https://tecnospeed.com.br/).

## TODO
[ ] Refactor the package name from `br.com.skywalker` to `br.com.newgo`;
[ ] Implement tests;

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

Paged paged = tecnoSpeed.assignors().findAll();
Paged next = paged.next();
```

## Releasing new versions

Configure your GPG passphrase and Sonatype credentials @ `~/.m2/settings.xml` as such:

```xml
<settings>
  <servers>
    <server>
      <id>sonatypeossrh</id>
      <username>(sonatype username)</username>
      <password>(sonatype password)</password>
    </server>
    <server>
      <id>gpg.passphrase</id>
      <passphrase>(sonatype username)</passphrase>
    </server>
  </servers>
</settings>
```

Then run `GPG_TTY=$(tty) mvn clean deploy` and you're done :D
