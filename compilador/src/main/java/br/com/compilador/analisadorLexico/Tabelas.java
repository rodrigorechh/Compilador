package br.com.compilador.analisadorLexico;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

/**
    S ::= 0<NUM> | 1<NUM> | 2<NUM> | 3<NUM> | 4<NUM> | 5<NUM> | 6<NUM> | 7<NUM> | 8<NUM> | 9<NUM> | i<A> | e<B> | {<CHAVES> | }<CHAVES> | true<BOOL> | false<BOOL> | ==<OPER> | ><OPER> | <<OPER> | <=<OPER> | >=<OPER> | ...<EXPR>
    <NUM>* ::= 0<NUM> | 1<NUM> | 2<NUM> | 3<NUM> | 4<NUM> | 5<NUM> | 6<NUM> | 7<NUM> | 8<NUM> | 9<NUM> | epsilon
    <A> = f<COND>
    <B> = l<C>
    <C> = s<D>
    <D> = e<COND>
    <COND>* = epsilon
    <CHAVES>* = epsilon
    <BOOL>* = epsilon
    <OPER>* = epsilon
    <EXPR>* = epsilon 
 * 
 */
@Getter
@Setter
public class Tabelas {
    
    private HashMap<String, HashMap<String, String>> tabela = new HashMap<>();

    public Tabelas() {
        HashMap<String, String> hashEstadoS = new HashMap<String, String>();
        hashEstadoS.put("0", "NUM");
        hashEstadoS.put("1", "NUM");
        hashEstadoS.put("2", "NUM");
        hashEstadoS.put("3", "NUM");
        hashEstadoS.put("4", "NUM");
        hashEstadoS.put("5", "NUM");
        hashEstadoS.put("6", "NUM");
        hashEstadoS.put("7", "NUM");
        hashEstadoS.put("8", "NUM");
        hashEstadoS.put("9", "NUM");
        hashEstadoS.put("i", "A");
        hashEstadoS.put("e", "B");
        hashEstadoS.put("{", "CHAVES");
        hashEstadoS.put("}", "CHAVES");
        hashEstadoS.put("t", "TRUE1");
        hashEstadoS.put("f", "FALSE1");
        hashEstadoS.put("=", "E");
        hashEstadoS.put(">", "OPER");
        hashEstadoS.put("<", "OPER");
        hashEstadoS.put("<", "E");
        hashEstadoS.put(">", "E");
        hashEstadoS.put("...", "OPER");
        hashEstadoS.put("(", "COLCH");
        hashEstadoS.put(")", "COLCH");

        tabela.put("S", hashEstadoS);

        HashMap<String, String> hashEstadoNum = new HashMap<String, String>();
        hashEstadoNum.put("0", "NUM");
        hashEstadoNum.put("1", "NUM");
        hashEstadoNum.put("2", "NUM");
        hashEstadoNum.put("3", "NUM");
        hashEstadoNum.put("4", "NUM");
        hashEstadoNum.put("5", "NUM");
        hashEstadoNum.put("6", "NUM");
        hashEstadoNum.put("7", "NUM");
        hashEstadoNum.put("8", "NUM");
        hashEstadoNum.put("9", "NUM");
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

        HashMap<String, String> hashEstadoEXPR = new HashMap<String, String>();
        hashEstadoEXPR.put("epsilon", "*");
        tabela.put("EXPR", hashEstadoEXPR);

        HashMap<String, String> hashEstadoCOLCH = new HashMap<String, String>();
        hashEstadoCOLCH.put("epsilon", "*");
        tabela.put("COLCH", hashEstadoCOLCH);

        HashMap<String, String> hashEstadoE = new HashMap<String, String>();
        hashEstadoE.put("=", "OPER");
        tabela.put("E", hashEstadoE);

        HashMap<String, String> hashEstadoTRUE1 = new HashMap<String, String>();
        hashEstadoTRUE1.put("r", "TRUE2");
        tabela.put("TRUE1", hashEstadoTRUE1);

        HashMap<String, String> hashEstadoTRUE2 = new HashMap<String, String>();
        hashEstadoTRUE2.put("u", "TRUE3");
        tabela.put("TRUE2", hashEstadoTRUE2);

        HashMap<String, String> hashEstadoTRUE3 = new HashMap<String, String>();
        hashEstadoTRUE3.put("e", "BOOL");
        tabela.put("TRUE3", hashEstadoTRUE3);

        HashMap<String, String> hashEstadoFALSE1 = new HashMap<String, String>();
        hashEstadoFALSE1.put("a", "FALSE2");
        tabela.put("FALSE1", hashEstadoFALSE1);

        HashMap<String, String> hashEstadoFALSE2 = new HashMap<String, String>();
        hashEstadoFALSE2.put("l", "FALSE3");
        tabela.put("FALSE2", hashEstadoFALSE2);

        HashMap<String, String> hashEstadoFALSE3 = new HashMap<String, String>();
        hashEstadoFALSE3.put("s", "FALSE4");
        tabela.put("FALSE3", hashEstadoFALSE3);

        HashMap<String, String> hashEstadoFALSE4 = new HashMap<String, String>();
        hashEstadoFALSE4.put("e", "BOOL");
        tabela.put("FALSE4", hashEstadoFALSE4);
    }
}
