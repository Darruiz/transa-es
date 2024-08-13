package teste;


import java.math.BigDecimal;

public class Movimentacao {
    BigDecimal valor; 
    int pagante_id; 
    int receptor_id; 
    String data;

    public BigDecimal exibirValor() {
        return valor;
    }

    public int exibirPagante() {
        return pagante_id;
    }

    public int exibirReceptor() {
        return receptor_id;
    }

    public String exibirData() { 
        return data;
    }
}