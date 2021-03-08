# Sockets cliente-servidor para em Java
## Programação para Sistemas Distribuidos - Sockets (TCP): Códigos em Java

### 1 - Sockets(TCP): Código - Envio de texto
### 2 - Sockets(TCP): Código - Envio de texto com Thread
### 3 - Sockets(TCP): Código - Envio de objeto

### 4 - Sockets(TCP): Código - Jogo Par ou Impar ultilizando socket com Thread
```
			//Nº randomico a ser sorteado de 0 a 10
			int num = random.nextInt(10);
					
			//Condiconal para verificar o sorteio do cliente ganhador	
			if(num % 2 == 0) {
					DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
					saida.writeUTF(novaMensagem + " - Quem ficou com PAR ganhou!!! " + "O Nº sorteado foi " + num);
				

				//3 - Fechar streams de entrada e saida de dados
				entrada.close();
				saida.close();
			}else if (num % 2 != 0){
				DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
				saida.writeUTF(novaMensagem + " - Quem ficou com IMPAR ganhou!!! " + "O Nº sorteado foi " + num);
				
				//3 - Fechar streams de entrada e saida de dados
				entrada.close();
				saida.close();
				
			}
```
