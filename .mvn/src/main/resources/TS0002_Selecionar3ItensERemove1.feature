#language: pt

  @TS0002_GerenciamentoDeItensNoCarrinhoAdicionarERemover
  Funcionalidade: Gerenciamento de Itens no Carrinho Adicionar e Remover

    Cenario: Realizar pedido 2 tapiocas celular
      Dado que acesso o sistema pelo celular
      E que cadastro um novo usuario
      Quando faco o login no sistema na filial de "Curitiba"
      E verifico se o usuario esta logado
      E entro no cardapio
      E escolho 3 itens do catalogo
      Entao removo o primeiro item escolhido