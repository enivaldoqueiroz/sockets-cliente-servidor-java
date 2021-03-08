package Par_ou_Impar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Cliente {

	public static void main(String[] args) throws IOException {
		//1 - Abrir conex�o 
		Socket socket = new Socket("127.0.0.1",54345);
		
		//2 - Definir streamde sa�da de dados do cliente
		DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
		saida.writeUTF("Impar"); // Enviar mensagem em minusculo para o servidor
		
		//3 - Definir stream de entrada de dados no cliente
		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		String novaMensagem = entrada.readUTF();// Receber mensagem em maiusculo do servidor
		System.out.println(novaMensagem);//Mostrar mensagem em maiusculo no cliente
		
		//4 - Fechar streams de entrada e sa�da de dados
		entrada.close();
		saida.close();
		
		//5 - Fechar o socket
		socket.close();
	}

}
