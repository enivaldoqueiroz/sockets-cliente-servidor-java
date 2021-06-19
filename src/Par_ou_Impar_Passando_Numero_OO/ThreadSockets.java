package Par_ou_Impar_Passando_Numero_OO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import Envio_de_Objeto.Pessoa;

public class ThreadSockets extends Thread{
	private Socket socket;
	private int n1;
	private int soma = 0;
	int vetor[] = new int [5];
	public ThreadSockets(Socket s, int n1) {
		this.setSocket(s);
		this.n1 = n1;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()); //Imprimir o nome da Thread
		try {
			//1 - Definir stream de entrada de dados no servidor
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			String mensagem = entrada.readUTF();//Recebendo mensagem em Minuscolo do Cliente
			String novaMensagem = mensagem.toUpperCase(); //Converter em Maiusculo
			int numero = entrada.readInt();
			
			int num = 0;
						
			/*//Salvando os valores informados pelos clientes
			int vetor[] = new int [5];
			int soma = 0;
			int numero = entrada.readInt();
		
			
			for(int n = 0; n < vetor.length; n++) {
				soma = numero + vetor[n];
				
			}*/
			
			 ObjectInputStream entradaObjto = new ObjectInputStream(socket.getInputStream());
		     Valor p = (Valor) entradaObjto.readObject();
		     System.out.println("Nome: " + p.getParOuImpar() + "\nValor: " + p.getValor());
					
			
			num = somarNumero(p.getValor());
			
						
			if(num % 2 == 0) {
				DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
				saida.writeUTF("Cliente que escolheu " + novaMensagem + " - Quem ficou com PAR ganhou!!! " + "O Nº sorteado foi " + num);
			}else if(num % 2 != 0) {
				DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
				saida.writeUTF("Cliente que escolheu " + novaMensagem + " - Quem ficou com IMPAR ganhou!!! " + "O Nº sorteado foi " + num);
			}
					
					
				
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
	
	//Função soma dos valores
	public int somarNumero(int soma) {
		
		for(int n = 0; n < vetor.length; n++) {
			this.soma = soma + vetor[n];
			
		}
		return this.soma;
				 
	}
		

}
