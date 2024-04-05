A API seguinte simula APENAS o cadastro de patos, clientes e vendas.

Para fazer esse projeto, é necessário ter o Docker instalado.<br>
Essa API utiliza Liquibase, Docker, Spring Boot e Jasper.<br>

Para a execução da API, basta apenas ativar o Docker, com o comando:<br><br>
  docker-compose -f database-docker/docker-compose.yaml up -d<br><br>

É bom esperar o Maven carregar as dependências para não haver qualquer problema com classes que vêm das dependências.

Após isso, basta iniciar o arquivo ApplicationDuck.java e a API irá subir.

Para o cadastro de Patos, a requisição precisa ser: <br><br>
{<br>
  "name": "Zé do Pato",<br>
  "mae": 2, <br>(Nesse caso, como um pato pode não ter mãe, a requisição aceita uma foreign key vazia. Se for o caso, basta colocar null no campo mae).<br>
}<br><br>
Isso aqui deve ser feito na rota localhost:8080/duck com método POST

##########################################

Para cadastrar clientes:<br><br>
{<br>
  "name":"Preço Justo",<br>
  "type":"Com Desconto" <br>(PARA O RELATÓRIO FUNCIONAR, É NECESSÁRIO QUE ESSE CAMPO SEJA PREENCHIDO APENAS COM "Com Desconto" OU "Sem Desconto"!!!!!!!!!!)<br>
}<br><br>
Deve ser feito na rota localhost:8080/client com método POST<br>

##########################################

Para cadastrar vendas, são necessários os seguintes campos:<br><br>
{<br>
  "idDuck":2,<br>
  "idClient":3<br>
}<br><br>
Essa requisição deve ser feita na rota localhost:8080/sale com método POST.<br>
Baseado nesses dados, a própria API calcula o preço do valor.<br>

##########################################<br>

Para geração do relatório em formato pdf, é necessário acessar o endpoint localhost:8080/gerar-relatorio pelo método GET.<br>
O relatório mostra todos os campos pedidos no teste. Infelizmente não consegui replicar o design do relatório :(, mas os dados foram gerados!

Como o teste foi feito diretamente para cadastro, não implementei o CRUD completo. A API também não possui muitas validações, então pode ocorrer de poder comprar 30x o mesmo pato.<br>
Todas as requisições que precisam de corpo, são no formato JSON.<br>
Qualquer dúvida só chamar, abraços!!<br>
