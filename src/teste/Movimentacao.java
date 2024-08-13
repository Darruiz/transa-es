package teste;

import java.util.ArrayList;

public class Movimentacao {
    private ArrayList<Double> valor = new ArrayList<>();
    private ArrayList<Integer> pagante_id = new ArrayList<>();
    private ArrayList<Integer> receptor_id = new ArrayList<>();
    private ArrayList<Integer> tipo_movimentacao = new ArrayList<>(); 
    private ArrayList<String> data = new ArrayList<>();

    public void adicionarMovimentacao(Double valor, int pagante_id, int receptor_id, int tipo, String data) {
        this.valor.add(valor);
        this.pagante_id.add(pagante_id);
        this.receptor_id.add(receptor_id);
        this.tipo_movimentacao.add(tipo);
        this.data.add(data);
    }

    public double exibirValor(int index) {
        return valor.get(index);
    }

    public int exibirPagante(int index) {
        return pagante_id.get(index);
    }

    public int exibirReceptor(int index) {
        return receptor_id.get(index);
    }

    public int exibirTipoMovimentacao(int index) {
        return tipo_movimentacao.get(index);
    }

    public String exibirData(int index) {
        return data.get(index);
    }

    public int tamanho() {
        return valor.size();
    }
}
