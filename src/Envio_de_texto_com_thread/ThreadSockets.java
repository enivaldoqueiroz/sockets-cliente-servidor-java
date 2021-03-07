package Envio_de_texto_com_thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

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
			Strinf novaMensagem = mensagem.toUpperCase(); //Converter em Maiusculo
			
			//2 - Definir stream de saida de dados do servidor
			DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
			saida.writeUTF(novaMensagem); //Enviando mensagem em Maiuscula para CLiente
			
			//3 - Fechar streams de entrada e saida de dados
			entrada.close();
			saida.close();
			
			//4 - Fechar socket de comunicação 
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
