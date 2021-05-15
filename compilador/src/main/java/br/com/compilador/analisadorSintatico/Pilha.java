package br.com.compilador.analisadorSintatico;
import java.util.Stack;

public class Pilha {

    private Stack<String> pilha = new Stack<String>();

    public void empilha(String valor) {
        this.pilha.push(valor);
    }

    public String desempilha() {
        return pilha.pop();
    }

    public String getTopo() {
        return pilha.peek();
    }

}
