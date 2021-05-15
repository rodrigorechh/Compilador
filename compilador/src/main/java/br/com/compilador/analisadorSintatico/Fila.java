package br.com.compilador.analisadorSintatico;
import java.util.LinkedList;
import java.util.Queue;

public class Fila {

    private Queue<String> fila = new LinkedList<String>();

    public void adiciona(String valor) {
        fila.add(valor);
    }

    public String remove() {
        return fila.remove();
    }

    public String getInicio() {
        return fila.peek();
    }
}
