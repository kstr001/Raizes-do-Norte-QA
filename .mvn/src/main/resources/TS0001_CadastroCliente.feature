#language: pt

  @TS0001-Cadastro
  Funcionalidade: Cadastrar novo usuario

    Cenario: Verifico se o usuario foi cadastrado desktop
      Dado que acesso o sistema na versao desktop
      E que cadastro um novo usuario
      Quando faco o login no sistema na filial de "São Paulo"

    Cenario: Verifico se o usuario foi cadastrado celular
      Dado que acesso o sistema pelo celular
      E que cadastro um novo usuario
      Quando faco o login no sistema na filial de "Curitiba"