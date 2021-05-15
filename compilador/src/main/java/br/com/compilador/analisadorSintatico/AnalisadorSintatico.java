package br.com.compilador.analisadorSintatico;

import java.util.HashMap;

public class AnalisadorSintatico {
    
    private TabelaSintatica TabelaSintatica = new TabelaSintatica();
    private Pilha pilha;
    private Fila fila;

    public void executa(Pilha pilha, Fila fila) {

        this.pilha = pilha;
        this.fila = fila;
        HashMap<String, HashMap<String, RegistroTabela>> tabela = this.TabelaSintatica.getTabela();

        while(true) {

            RegistroTabela registro = tabela.get(this.pilha.getTopo()).get(this.fila.getInicio());
            if(registro == null) registro = new RegistroTabela(Açoes.ERRO, null);//registra erro caso registro seja vazio.

            switch(registro.getAçoes()) {
                case EMPILHA :
                    this.empilha(registro.getValor());
                    break;
                case REDUZ :
                    this.reduz(registro.getValor());
                    String estadoProducao = new Producoes().getProducoes().get(Integer.valueOf(registro.getValor())).getEstado();
                    this.transicao(this.pilha.getTopo(), estadoProducao, tabela);
                    break;
                case ACEITA :
                    this.sucesso();
                    return;
                case ERRO :
                    this.erro();
            }
        }

    }

    private void empilha(String valorTabela) {
        this.pilha.empilha(this.fila.getInicio());
        this.fila.remove();

        this.pilha.empilha(valorTabela);
    }

    private void reduz(String valorTabela) {
        Producoes producoes = new Producoes();
        int tamanhoProducao = producoes.getProducoes().get(Integer.valueOf(valorTabela)).getTamanho();
        for(int i = 0; i < tamanhoProducao * 2; i++) {
            this.pilha.desempilha();
        }
    }

    /**
     * Recebe topo da pilha e um estado. Com o topo da pilha sendo a linha e o estado a coluna consultam a tabela.
     * Por fim é salvo no topo da pilha respectivamente o estado e o registro retornado pela consulta
     */
    private void transicao(String topoPilha, String estado, HashMap<String, HashMap<String, RegistroTabela>> tabela) {
        RegistroTabela registroTabela = tabela.get(topoPilha).get(estado);
        this.pilha.empilha(estado);
        this.pilha.empilha(registroTabela.getValor());
    }

    private void erro() {
        throw new RuntimeException("Erro na análise sintática.");
    }

    private void sucesso() {
        System.out.println("Sucesso na análise sintática.");
    }
}
