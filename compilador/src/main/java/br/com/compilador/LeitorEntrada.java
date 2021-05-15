package br.com.compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Responsável por ler entrada
 */
public class LeitorEntrada {
    
    public String lerArquivo() {
        final File file = new File("entrada.txt");
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String linha = bufferedReader.readLine();
                bufferedReader.close();
                return linha;
            } catch (Exception e) {
                System.out.println("Falha ao ler arquivo.");
                return null;
            }    
   
        }
        else {
            System.out.println("Arquivo entrada.txt não encontrado");
            return null;
        }
    }
    
}