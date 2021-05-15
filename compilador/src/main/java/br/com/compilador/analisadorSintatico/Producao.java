package br.com.compilador.analisadorSintatico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producao {
    private int chave;
    private int tamanho;
    private String estado; 

    Producao(int chave, int tamanho, String estado) {
        this.chave = chave;
        this.tamanho = tamanho;
        this.estado = estado;
    }
}
