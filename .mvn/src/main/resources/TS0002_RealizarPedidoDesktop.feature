#language: pt

  @TS0002_RealizarPedidoDesktop
  Funcionalidade: Realizar pedido 2 tapiocas Desktop

    Cenario: Realizar pedido 2 tapiocas Desktop
      Dado que acesso o sistema na versao desktop
      E que cadastro um novo usuario
      Quando faco o login no sistema na filial de "Curitiba"
      E verifico se o usuario esta logado
      E entro no cardapio
      E escolho 2 tapiocas
      E escolho o endereco "81870-260" "242"
      Entao solicio a atulizacao do status de pagamente externo sucesso
