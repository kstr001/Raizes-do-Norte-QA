#language: pt

  @TS0003_RealizarPedidoCelular
  Funcionalidade: Realizar pedido 2 tapiocas celular

    Cenario: Realizar pedido 2 tapiocas celular
      Dado que acesso o sistema pelo celular
      E que cadastro um novo usuario
      Quando faco o login no sistema na filial de "Curitiba"
      E verifico se o usuario esta logado
      E entro no cardapio
      E escolho 2 tapiocas
      E escolho o endereco "81870-260" "242"
      Entao solicio a atulizacao do status de pagamente externo sucesso