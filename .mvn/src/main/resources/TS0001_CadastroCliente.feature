#language: pt

  @TS0001-Cadastro
  Funcionalidade: Cadastrar novo usuario

    Cenario: Verifico se o usuario foi cadastrado celular
      Dado que acesso o sistema pelo celular
      E que cadastro um novo usuario
      Quando faco o login no sistema na filial de "Curitiba"
      Entao verifico se o usuario esta logado