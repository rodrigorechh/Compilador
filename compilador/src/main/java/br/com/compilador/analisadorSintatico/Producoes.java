package br.com.compilador.analisadorSintatico;

import java.util.HashMap;

import lombok.Getter;

@Getter
public class Producoes {
    
    HashMap<Integer, Producao> producoes = new HashMap<>();

    public Producoes() {

        Producao producao;

        producao = new Producao(0, 8, "S");
        producoes.put(0, producao);

        producao = new Producao(1, 0, "END_COND");
        producoes.put(1, producao);

        producao = new Producao(2, 4, "END_COND");
        producoes.put(2, producao);

        producao = new Producao(3, 3, "OP_LOG");
        producoes.put(3, producao);

        producao = new Producao(4, 1, "OP_COMP");
        producoes.put(4, producao);

        producao = new Producao(5, 1, "NUM");
        producoes.put(5, producao);

        producao = new Producao(6, 0, "EXPR");
        producoes.put(6, producao);

        producao = new Producao(7, 1, "EXPR");
        producoes.put(7, producao);
        
    }

}
