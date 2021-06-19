package Par_ou_Impar_Passando_Numero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Cliente2 {

	public static void main(String[] args) throws IOException {
		//1 - Abrir conexão 
		Socket socket = new Socket("127.0.0.1",54382);
		
		//2 - Definir streamde saída de dados do cliente
		DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
		saida.writeUTF("Par"); // Enviar mensagem em minusculo para o servidor
		saida.writeInt(1); // Enviar numero em minusculo para o servidor
		
		//3 - Definir stream de entrada de dados no cliente
		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		String novaMensagem = entrada.readUTF();// Receber mensagem em maiusculo do servidor
		System.out.println(novaMensagem);//Mostrar mensagem em maiusculo no cliente
		
		//4 - Fechar streams de entrada e saída de dados
		entrada.close();
		saida.close();
		
		//5 - Fechar o socket
		socket.close();
	}

}
