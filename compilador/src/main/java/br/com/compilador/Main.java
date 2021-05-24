package br.com.compilador;

import java.util.ArrayList;
import java.util.List;

import br.com.compilador.analisadorLexico.AnalisadorLexico;
import br.com.compilador.analisadorLexico.PalavraAceitaDTO;
import br.com.compilador.analisadorLexico.TabelaLexica;

import br.com.compilador.analisadorSintatico.AnalisadorSintatico;
import br.com.compilador.analisadorSintatico.Fila;
import br.com.compilador.analisadorSintatico.Pilha;

public class Main 
{
    public static void main( String[] args )
    {


        // Leitura
        String frase = new LeitorEntrada().lerArquivo();
        String[] palavras = frase.split(" ");//palavras são separadas pelo caractere "espaço"

        System.out.println("\n\nENTRADA: " + frase);



        // === ANALISE LEXICA ===
        TabelaLexica tabelaLexica = new TabelaLexica();
        AnalisadorLexico analisadorLexico = new AnalisadorLexico();
        List<PalavraAceitaDTO> listaPalavrasAceitas = new ArrayList<PalavraAceitaDTO>(); 
        
        System.out.println("---");
        System.out.println("SAIDA LEXICA: ");

        for (String palavra : palavras) {
            if(palavra.equals("$")) {
                PalavraAceitaDTO palavraCifrao = new PalavraAceitaDTO();
                palavraCifrao.setPalavra("$");
                listaPalavrasAceitas.add(palavraCifrao);
                break;
            }
            PalavraAceitaDTO palavraAceitaDTO = analisadorLexico.analiseLexicaPalavra(tabelaLexica.getTabela(), palavra);
            if(palavraAceitaDTO == null) {
                System.out.println("Palavra " + palavra + " não foi aceita como válida na análise léxica\n\n");
                return;
            }
            else {
                listaPalavrasAceitas.add(palavraAceitaDTO);
            }
        }
        
        System.out.println(listaPalavrasAceitas.toString().replace("PalavraAceitaDTO", ""));



        // === ANALISE SINTATICA ===
        System.out.println("---");
        System.out.println("SAIDA SINTATICA: ");

        Pilha pilha = new Pilha();
        pilha.empilha("0"); // estado 0
        Fila fila = new Fila();
        for(PalavraAceitaDTO palavraAceita : listaPalavrasAceitas) {
            fila.adiciona(palavraAceita.getPalavra());
        }
        
        AnalisadorSintatico analisadorSintatico = new AnalisadorSintatico();
        analisadorSintatico.executa(pilha, fila);

        System.out.println("\n\n");
    }
}
