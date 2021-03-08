package Par_ou_Impar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Random;

public class ThreadSockets extends Thread{
	private Socket socket;
	public ThreadSockets(Socket s) {
		this.setSocket(s);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()); //Imprimir o nome da Thread
		try {
			//1 - Definir stream de entrada de dados no servidor
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			String mensagem = entrada.readUTF();//Recebendo mensagem em Minuscolo do Cliente
			String novaMensagem = mensagem.toUpperCase(); //Converter em Maiusculo
			
			//2 - Definir stream de saida de dados do servidor
			Random random = new Random();
			
			int num = random.nextInt(10);
			
			/*if(num % 2 == 0 && mensagem == "Par") {
				DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
				saida.writeUTF(novaMensagem + " Par ganhou!!! " + num); //Enviando mensagem em Maiuscula para CLiente
				//System.out.println("Par ganhou!!!");

				//3 - Fechar streams de entrada e saida de dados
				entrada.close();
				saida.close();
			}else if (num % 2 != 0 && mensagem == "Impar"){
				DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
				saida.writeUTF(novaMensagem + " Impar ganhou!!! " + num); //Enviando mensagem em Maiuscula para CLiente
				//System.out.println("Impar ganhou!!!");
				//3 - Fechar streams de entrada e saida de dados
				entrada.close();
				saida.close();
				
			}*/
			
			
				
				if(num % 2 == 0) {
					DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
					saida.writeUTF(novaMensagem + " Quem ficou com PAR ganhou!!! " + "O N� sorteado foi " + num);
				

				//3 - Fechar streams de entrada e saida de dados
				entrada.close();
				saida.close();
			}else if (num % 2 != 0){
				DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
				saida.writeUTF(novaMensagem + " Quem ficou com IMPAR ganhou!!! " + "O N� sorteado foi " + num);
				
				//3 - Fechar streams de entrada e saida de dados
				entrada.close();
				saida.close();
				
			}
			
			
			
			
			
			
			//4 - Fechar socket de comunica��o 
			socket.close();
			
		} catch (Exception ioe) {
			System.out.println("Erro: " + ioe.toString());
		}
	}
	
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
		

}
