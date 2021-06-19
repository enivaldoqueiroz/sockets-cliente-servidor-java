package Par_ou_Impar_Passando_Numero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException{
		//1 - Definir o serverSocket (abrir porta de conexão)
		ServerSocket serverSocket = new ServerSocket(54382);
		System.out.println("A porta " + serverSocket.getLocalPort() + "  foi aberta!");
		System.out.println("Servidor esperando reveber mensagem de cliente...");
		
		
		while(true) {
			//2 - Aguardar solicitação de conexão de cliente
			Socket socket = serverSocket.accept();
			//Mostrar endereço IP do Cliente conectado
			System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");
			
			
			
			//DataInputStream entradaNum = new DataInputStream(socket.getInputStream());
			int n1 = 0;
			//= entradaNum.readInt();
			
			//3 - Definir uma thread para cada cliente conectado
			ThreadSockets thread = new ThreadSockets(socket, n1);
			thread.start();
			
		}
		
	}

}
