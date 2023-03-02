import java.time.LocalDate;

public class Despesa {
    private double valor;
    private String categoria;
    private LocalDate data;

    public Despesa(double valor, String categoria, LocalDate data) {
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;


    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

}
