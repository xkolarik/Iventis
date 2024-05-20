# Iventis Teste de Back-end
## Steps:

Executar a aplicação Application.class.

Realizar as chamdas dos endpoints que fazem integração com API dp teste:

GET: /compras - Retornar uma lista das compras ordenadas de forma crescente por valor, deve conter o nome dos clientes, cpf dos clientes, dado dos produtos, quantidade das compras e valores totais de cada compra.
http://localhost:8080/api/compras/

GET: /maior-compra/ano - (Exemplo: /maior_compra/2016) - Retornar a maior compra do ano informando os dados da compra disponibilizados, deve ter o nome do cliente, cpf do cliente, dado do produto, quantidade da compra e seu valor total.
http://localhost:8080/api/compras/maior-compra/2018

GET: /clientes-fieis - Retornar o Top 3 clientes mais fieis, clientes que possuem mais compras recorrentes com maiores valores.
http://localhost:8080/api/compras/clientes-fieis

GET: /recomendacao/cliente/tipo - Retornar uma recomendação de vinho baseado nos tipos de vinho que o cliente mais compra.
http://localhost:8080/api/compras/recomendacao/cliente/96718391344/tipo


---

## Techs:

Spring boot - 3.2.5
- https://spring.io/blog/2024/04/18/spring-boot-3-2-5-available-now

Java 17.0.8 Corretto
Maven
Feign
SpringBootTest

---




