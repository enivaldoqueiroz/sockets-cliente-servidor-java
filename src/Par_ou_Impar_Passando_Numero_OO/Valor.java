package Par_ou_Impar_Passando_Numero_OO;

import java.io.Serializable;

public class Valor implements Serializable{
	
	private String ParOuImpar;
    private int valor;
    
    public Valor(String nome, int valor) {
        this.ParOuImpar = nome;
        this.valor = valor;
    }
    
    public void setParOuImpar(String nome) { this.ParOuImpar = nome; }
    public void setValor(int valor) { this.valor = valor; }
    public String getParOuImpar() { return this.ParOuImpar; }
    public int getValor() { return this.valor; }

}
