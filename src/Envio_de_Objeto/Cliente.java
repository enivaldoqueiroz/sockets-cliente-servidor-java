package Envio_de_Objeto;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {
        //1 - Abrir conex�o
        Socket socket = new Socket("127.0.0.1", 54323);
        
        //2 - Definir stream de sa�da de dados do cliente
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        Pessoa p = new Pessoa("Enivaldo Queiroz", 29);
        saida.writeObject(p);

        //4 - Fechar streams de sa�da de dados
        saida.close();

        //5 - Fechar o socket
        socket.close();
    }
}