#language: pt

  Funcionalidade: Busca de cep e endereções no site dos correios

    @1
    Cenario: Realizar a busca de um cep no site dos correios
      Dado que estou no site dos correios
      Quando realizar a busca por "03195100"
      Então sera mostrado o resultado no log

    @2
    Cenario: Realizar a busca de um bairro no site dos correios
      Dado que estou no site dos correios
      Quando realizar a busca por "Alto da mooca"
      Então sera mostrado o resultado no log