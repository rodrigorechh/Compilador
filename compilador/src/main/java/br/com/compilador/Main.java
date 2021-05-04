package br.com.compilador;

import java.util.ArrayList;
import java.util.List;

import br.com.compilador.analisadorLexico.Conversor;
import br.com.compilador.analisadorLexico.PalavraAceitaDTO;
import br.com.compilador.analisadorLexico.Tabelas;

public class Main 
{
    public static void main( String[] args )
    {

        Tabelas tabela = new Tabelas();
        Conversor conversor = new Conversor();

        String frase = "if ( true ) { }";
        String[] palavras = frase.split(" ");//palavras são separadas pelo caractere "espaço"

        List<PalavraAceitaDTO> listaPalavrasAceitas = new ArrayList<PalavraAceitaDTO>(); 
        for (String palavra : palavras) {
            PalavraAceitaDTO palavraAceitaDTO = conversor.analiseLexicaPalavra(tabela.getTabela(), palavra);
            if(palavraAceitaDTO == null) {
                System.out.println("Palavra " + palavra + " não foi aceita como válida na análise léxica");
                return;
            }
            else {
                listaPalavrasAceitas.add(palavraAceitaDTO);
            }
        }
 
    }
}
