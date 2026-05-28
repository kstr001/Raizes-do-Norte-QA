#language: pt

  @TS0001-Cadastro
  Funcionalidade: Cadastrar novo usuario

    Cenario: Verifico se o usuario foi cadastrado celular
      Dado que acesso o sistema pelo celular
      E que inicio o cadastro De um novo usuario
      E que aceito os termos de uso
      Quando tento fazer o login no sistema sem escolher a filial
      E seleciono a filial de "Curitiba"
      Entao verifico se o usuario esta logado