package br.com.compilador.analisadorSintatico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroTabela {
    private Açoes açoes;
    private String valor;

    RegistroTabela(Açoes açoes, String valor) {
        this.açoes = açoes;
        this.valor = valor;
    }
}
