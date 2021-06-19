package Envio_de_texto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException{
		//1 - Definir o serverSocket (abrir porta de conexão)
		ServerSocket serverSocket = new ServerSocket(54354);
		System.out.println("A porta 54321 foi aberta!");
		System.out.println("Servidor esperando reveber mensagem de cliente...");
		
		//2 - Aguardar solicitação de conexão de cliente
		Socket socket = serverSocket.accept();
		//Mostrar endereço IP do Cliente conectado
		System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");
		//3 - Definir streams de entada de dados
		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		String mensagem = entrada.readUTF();//receber mensagem em minusculo do cliente
		String novaMensagem = mensagem.toUpperCase(); //converte mensagem em maiusculo
		
		//4 - Definir streams de saida de dados
		DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
		saida.writeUTF(novaMensagem); //Enviar mensagem em minusculo para cliente
		
		//5 - Fechar streams
		entrada.close();
		saida.close();
		
		//6 - Fechar sockets de conexão e comunicação
		socket.close();
		serverSocket.close();
	}

}
