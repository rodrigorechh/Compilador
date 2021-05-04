package br.com.compilador.analisadorLexico;

import java.util.HashMap;

public class Conversor {
    
    /**
     * Recebendo uma tabela e uma palavra, percorre a tabela para descobrir se a palavra está na gramática
     * @param tabela
     * @param palavra
     */
    public PalavraAceitaDTO analiseLexicaPalavra(HashMap<String, HashMap<String, String>> tabela, String palavra) {
        String estadoAtual = "S"; //S sempre será o estadoInicial
        boolean palavraAceita;

        String[] letras = palavra.split("");

        for (String letra : letras) {
            if(tabela.containsKey(estadoAtual)) {
                HashMap<String, String> hashProducoes = tabela.get(estadoAtual);//retorna produções de um estado.
                if(hashProducoes.containsKey(letra)) {
                    estadoAtual = hashProducoes.get(letra);
                }
                else {
                    palavraAceita = false; //palavra não existe na gramática
                    return null;
                }
            }
            else {
                palavraAceita = false; //palavra não existe na gramática
                return null;
            }
        }

        String estadoFinal = estadoAtual;
        //verifica se o estado final após percorrer a palavra consta como um estado final na tabela.
        if(tabela.get(estadoFinal).containsKey("epsilon")) {
            palavraAceita = tabela.get(estadoFinal).get("epsilon").equals("*") ? true : false;
        }
        else {
            palavraAceita = false;
        }

        if(palavraAceita) {
            //gera retorno
            PalavraAceitaDTO palavraAceitaDTO = new PalavraAceitaDTO();
            palavraAceitaDTO.setEstado(estadoFinal);
            palavraAceitaDTO.setPalavra(palavra);
            return palavraAceitaDTO;
        }
        else {
            return null;
        }
        
    }
}
