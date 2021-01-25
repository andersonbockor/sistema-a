# sistema-a

Para testar, a aplicação está rodando na AWS.

Dados da base de dados RDS:

* host: base-a.c35evhuzdkwl.sa-east-1.rds.amazonaws.com
* name: basea
* porta: 5432
* user: postgres
* senha: postgres

Sistema rodando no EC2:

* Endpoint de autenticação com usuário de teste (já incluído na base):

http://ec2-18-231-146-162.sa-east-1.compute.amazonaws.com:8080/oauth/token?grant_type=password&username=andersonbockor@gmail.com&password=12345678 
 
No "Authorization", utilize "Basic Auth" com os dados do cliente:
Username=cliente
Password=12345678

* EndPoint de consulta de pessoas e dívidas:

http://ec2-18-231-146-162.sa-east-1.compute.amazonaws.com:8080/api/pessoa/all

No Header, passe “Authorization" = “Bearer <token>" 
O token expira em 1 dia.
 

Atenção: Caso o sistema não esteja rodando, pode entrar em contato comigo ou rodar via terminal: 

ssh -i <certificado> ubuntu@ec2-18-231-146-162.sa-east-1.compute.amazonaws.com  
java -jar sistema-a-0.0.1-SNAPSHOT.jar 

