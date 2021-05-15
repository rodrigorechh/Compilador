package br.com.compilador.analisadorLexico;

import java.util.HashMap;

import lombok.Getter;

/**
 * 
    S ::= 0<NUM> | i<A> | e<B> | {<CHAVES> | }<CHAVES> | =<E> | (<COLCH> | )<COLCH>
    <NUM>* ::= epsilon
    <A> = f<COND>
    <B> = l<C>
    <C> = s<D>
    <D> = e<COND>
    <E> = =<OPER>
    <COND>* = epsilon
    <CHAVES>* = epsilon
    <BOOL>* = epsilon
    <OPER>* = epsilon
    <COLCH>* = epsilon 

 * 
 */

@Getter
public class TabelaLexica {
    
    private HashMap<String, HashMap<String, String>> tabela = new HashMap<>();

    public TabelaLexica() {
        HashMap<String, String> hashEstadoS = new HashMap<String, String>();
        hashEstadoS.put("0", "NUM");
        hashEstadoS.put("i", "A");
        hashEstadoS.put("e", "B");
        hashEstadoS.put("{", "CHAVES");
        hashEstadoS.put("}", "CHAVES");
        hashEstadoS.put("=", "E");
        hashEstadoS.put("(", "COLCH");
        hashEstadoS.put(")", "COLCH");

        tabela.put("S", hashEstadoS);

        HashMap<String, String> hashEstadoNum = new HashMap<String, String>();
        hashEstadoNum.put("epsilon", "*");//estado final
        tabela.put("NUM", hashEstadoNum);

        HashMap<String, String> hashEstadoA = new HashMap<String, String>();
        hashEstadoA.put("f", "COND");
        tabela.put("A", hashEstadoA);

        HashMap<String, String> hashEstadoB = new HashMap<String, String>();
        hashEstadoB.put("l", "C");
        tabela.put("B", hashEstadoB);

        HashMap<String, String> hashEstadoC = new HashMap<String, String>();
        hashEstadoC.put("s", "D");
        tabela.put("C", hashEstadoC);

        HashMap<String, String> hashEstadoD = new HashMap<String, String>();
        hashEstadoD.put("e", "COND");
        tabela.put("D", hashEstadoD);

        HashMap<String, String> hashEstadoE = new HashMap<String, String>();
        hashEstadoE.put("=", "OPER");
        tabela.put("E", hashEstadoE);

        HashMap<String, String> hashEstadoCOND = new HashMap<String, String>();
        hashEstadoCOND.put("epsilon", "*");
        tabela.put("COND", hashEstadoCOND);

        HashMap<String, String> hashEstadoCHAVES = new HashMap<String, String>();
        hashEstadoCHAVES.put("epsilon", "*");
        tabela.put("CHAVES", hashEstadoCHAVES);

        HashMap<String, String> hashEstadoBOOL = new HashMap<String, String>();
        hashEstadoBOOL.put("epsilon", "*");
        tabela.put("BOOL", hashEstadoBOOL);

        HashMap<String, String> hashEstadoOPER = new HashMap<String, String>();
        hashEstadoOPER.put("epsilon", "*");
        tabela.put("OPER", hashEstadoOPER);

        HashMap<String, String> hashEstadoCOLCH = new HashMap<String, String>();
        hashEstadoCOLCH.put("epsilon", "*");
        tabela.put("COLCH", hashEstadoCOLCH);

    }
}
