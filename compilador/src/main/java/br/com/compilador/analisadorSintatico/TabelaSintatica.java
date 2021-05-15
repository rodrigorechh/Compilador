package br.com.compilador.analisadorSintatico;

import java.util.HashMap;

import lombok.Getter;

@Getter
public class TabelaSintatica {
    
    private HashMap<String, HashMap<String, RegistroTabela>> tabela = new HashMap<>();

    public TabelaSintatica() {

        HashMap<String, RegistroTabela> hashColuna0 = new HashMap<String, RegistroTabela>();
        hashColuna0.put("if", new RegistroTabela(Açoes.EMPILHA, "1"));
        this.tabela.put("0", hashColuna0);

        HashMap<String, RegistroTabela> hashColuna1 = new HashMap<String, RegistroTabela>();
        hashColuna1.put("(", new RegistroTabela(Açoes.EMPILHA, "2"));
        this.tabela.put("1", hashColuna1);

        HashMap<String, RegistroTabela> hashColuna2 = new HashMap<String, RegistroTabela>();
        hashColuna2.put("0", new RegistroTabela(Açoes.EMPILHA, "5"));
        hashColuna2.put("OP_LOG", new RegistroTabela(null, "3"));
        hashColuna2.put("NUM", new RegistroTabela(null, "4"));
        this.tabela.put("2", hashColuna2);

        HashMap<String, RegistroTabela> hashColuna3 = new HashMap<String, RegistroTabela>();
        hashColuna3.put(")", new RegistroTabela(Açoes.EMPILHA, "6"));
        this.tabela.put("3", hashColuna3);

        HashMap<String, RegistroTabela> hashColuna4 = new HashMap<String, RegistroTabela>();
        hashColuna4.put("==", new RegistroTabela(Açoes.EMPILHA, "8"));
        hashColuna4.put("OP_COMP", new RegistroTabela(null, "7"));
        this.tabela.put("4", hashColuna4);

        HashMap<String, RegistroTabela> hashColuna5 = new HashMap<String, RegistroTabela>();
        hashColuna5.put("==", new RegistroTabela(Açoes.REDUZ, "5"));
        this.tabela.put("5", hashColuna5);

        HashMap<String, RegistroTabela> hashColuna6 = new HashMap<String, RegistroTabela>();
        hashColuna6.put("{", new RegistroTabela(Açoes.EMPILHA, "9"));
        this.tabela.put("6", hashColuna6);

        HashMap<String, RegistroTabela> hashColuna7 = new HashMap<String, RegistroTabela>();
        hashColuna7.put("0", new RegistroTabela(Açoes.EMPILHA, "11"));
        hashColuna7.put("NUM", new RegistroTabela(null, "10"));
        this.tabela.put("7", hashColuna7);

        HashMap<String, RegistroTabela> hashColuna8 = new HashMap<String, RegistroTabela>();
        hashColuna8.put("0", new RegistroTabela(Açoes.REDUZ, "4"));
        this.tabela.put("8", hashColuna8);

        HashMap<String, RegistroTabela> hashColuna9 = new HashMap<String, RegistroTabela>();
        hashColuna9.put("if", new RegistroTabela(Açoes.EMPILHA, "14"));
        hashColuna9.put("}", new RegistroTabela(Açoes.REDUZ, "6"));
        hashColuna9.put("S", new RegistroTabela(null, "13"));
        hashColuna9.put("EXPR", new RegistroTabela(null, "12"));
        this.tabela.put("9", hashColuna9);

        HashMap<String, RegistroTabela> hashColuna10 = new HashMap<String, RegistroTabela>();
        hashColuna10.put(")", new RegistroTabela(Açoes.REDUZ, "3"));
        this.tabela.put("10", hashColuna10);

        HashMap<String, RegistroTabela> hashColuna11 = new HashMap<String, RegistroTabela>();
        hashColuna11.put(")", new RegistroTabela(Açoes.REDUZ, "5"));
        this.tabela.put("11", hashColuna11);

        HashMap<String, RegistroTabela> hashColuna12 = new HashMap<String, RegistroTabela>();
        hashColuna12.put("}", new RegistroTabela(Açoes.EMPILHA, "15"));
        this.tabela.put("12", hashColuna12);

        HashMap<String, RegistroTabela> hashColuna13 = new HashMap<String, RegistroTabela>();
        hashColuna13.put("}", new RegistroTabela(Açoes.REDUZ, "7"));
        this.tabela.put("13", hashColuna13);

        HashMap<String, RegistroTabela> hashColuna14 = new HashMap<String, RegistroTabela>();
        hashColuna14.put("(", new RegistroTabela(Açoes.EMPILHA, "16"));
        this.tabela.put("14", hashColuna14);

        HashMap<String, RegistroTabela> hashColuna15 = new HashMap<String, RegistroTabela>();
        hashColuna15.put("else", new RegistroTabela(Açoes.EMPILHA, "18"));
        hashColuna15.put("$", new RegistroTabela(Açoes.REDUZ, "1"));
        hashColuna15.put("END_COND", new RegistroTabela(null, "17"));
        this.tabela.put("15", hashColuna15);

        HashMap<String, RegistroTabela> hashColuna16 = new HashMap<String, RegistroTabela>();
        hashColuna16.put("0", new RegistroTabela(Açoes.EMPILHA, "5"));
        hashColuna16.put("OP_LOG", new RegistroTabela(null, "19"));
        hashColuna16.put("NUM", new RegistroTabela(null, "4"));
        this.tabela.put("16", hashColuna16);

        HashMap<String, RegistroTabela> hashColuna17 = new HashMap<String, RegistroTabela>();
        hashColuna17.put("$", new RegistroTabela(Açoes.ACEITA, null));
        this.tabela.put("17", hashColuna17);

        HashMap<String, RegistroTabela> hashColuna18 = new HashMap<String, RegistroTabela>();
        hashColuna18.put("{", new RegistroTabela(Açoes.EMPILHA, "20"));
        this.tabela.put("18", hashColuna18);

        HashMap<String, RegistroTabela> hashColuna19 = new HashMap<String, RegistroTabela>();
        hashColuna19.put(")", new RegistroTabela(Açoes.EMPILHA, "21"));
        this.tabela.put("19", hashColuna19);

        HashMap<String, RegistroTabela> hashColuna20 = new HashMap<String, RegistroTabela>();
        hashColuna20.put("if", new RegistroTabela(Açoes.EMPILHA, "14"));
        hashColuna20.put("}", new RegistroTabela(Açoes.REDUZ, "6"));
        hashColuna20.put("S", new RegistroTabela(null, "13"));
        hashColuna20.put("EXPR", new RegistroTabela(null, "22"));
        this.tabela.put("20", hashColuna20);

        HashMap<String, RegistroTabela> hashColuna21 = new HashMap<String, RegistroTabela>();
        hashColuna21.put("{", new RegistroTabela(Açoes.EMPILHA, "23"));
        this.tabela.put("21", hashColuna21);

        HashMap<String, RegistroTabela> hashColuna22 = new HashMap<String, RegistroTabela>();
        hashColuna22.put("}", new RegistroTabela(Açoes.EMPILHA, "24"));
        this.tabela.put("22", hashColuna22);

        HashMap<String, RegistroTabela> hashColuna23 = new HashMap<String, RegistroTabela>();
        hashColuna23.put("if", new RegistroTabela(Açoes.EMPILHA, "14"));
        hashColuna23.put("}", new RegistroTabela(Açoes.REDUZ, "6"));
        hashColuna23.put("S", new RegistroTabela(null, "13"));
        hashColuna23.put("EXPR", new RegistroTabela(null, "25"));
        this.tabela.put("23", hashColuna23);

        HashMap<String, RegistroTabela> hashColuna24 = new HashMap<String, RegistroTabela>();
        hashColuna24.put("$", new RegistroTabela(Açoes.REDUZ, "2"));
        this.tabela.put("24", hashColuna24);

        HashMap<String, RegistroTabela> hashColuna25 = new HashMap<String, RegistroTabela>();
        hashColuna25.put("}", new RegistroTabela(Açoes.EMPILHA, "26"));
        this.tabela.put("25", hashColuna25);

        HashMap<String, RegistroTabela> hashColuna26 = new HashMap<String, RegistroTabela>();
        hashColuna26.put("}", new RegistroTabela(Açoes.REDUZ, "1"));
        hashColuna26.put("else", new RegistroTabela(Açoes.EMPILHA, "28"));
        hashColuna26.put("END_COND", new RegistroTabela(null, "27"));
        this.tabela.put("26", hashColuna26);

        HashMap<String, RegistroTabela> hashColuna27 = new HashMap<String, RegistroTabela>();
        hashColuna27.put("}", new RegistroTabela(Açoes.ACEITA, null));
        this.tabela.put("27", hashColuna27);

        HashMap<String, RegistroTabela> hashColuna28 = new HashMap<String, RegistroTabela>();
        hashColuna28.put("{", new RegistroTabela(Açoes.EMPILHA, "29"));
        this.tabela.put("28", hashColuna28);

        HashMap<String, RegistroTabela> hashColuna29 = new HashMap<String, RegistroTabela>();
        hashColuna29.put("if", new RegistroTabela(Açoes.EMPILHA, "14"));
        hashColuna29.put("}", new RegistroTabela(Açoes.REDUZ, "6"));
        hashColuna29.put("S", new RegistroTabela(null, "13"));
        hashColuna29.put("EXPR", new RegistroTabela(null, "30"));
        this.tabela.put("29", hashColuna29);
    
        HashMap<String, RegistroTabela> hashColuna30 = new HashMap<String, RegistroTabela>();
        hashColuna30.put("}", new RegistroTabela(Açoes.EMPILHA, "31"));
        this.tabela.put("30", hashColuna30);

        HashMap<String, RegistroTabela> hashColuna31 = new HashMap<String, RegistroTabela>();
        hashColuna31.put("}", new RegistroTabela(Açoes.REDUZ, "2"));
        this.tabela.put("31", hashColuna31);

    }

}
