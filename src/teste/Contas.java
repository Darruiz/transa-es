package teste;



public class Contas {
    int[] id;
    Double[] saldo; 
    String[] titular; 
    String[] banco; 
    Boolean[] ativo; 

    public int exibirID(int i) { 
        return id[i];
    }

    public String exibiTitular(int i) {
        
        return titular[i];
    }

    public String exibirBanco(int i) {
        return banco[i];
    }

    public boolean exibirAtivo(int i) {
        return ativo[i];
    }

    public double exibirSaldo(int i) { 
        return saldo[i];
    }
}