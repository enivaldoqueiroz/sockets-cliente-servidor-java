package Par_ou_Impar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException{
		//1 - Definir o serverSocket (abrir porta de conexão)
		ServerSocket serverSocket = new ServerSocket(54345);
		System.out.println("A porta 54321 foi aberta!");
		System.out.println("Servidor esperando reveber mensagem de cliente...");
		
		
		while(true) {
			//2 - Aguardar solicitação de conexão de cliente
			Socket socket = serverSocket.accept();
			//Mostrar endereço IP do Cliente conectado
			System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");
			
			//3 - Definir uma thread para casa cliente conectado
			ThreadSockets thread = new ThreadSockets(socket);
			thread.start();
			
		}
		
	}

}
