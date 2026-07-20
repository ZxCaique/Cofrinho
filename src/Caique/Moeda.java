package Caique;  

public abstract class Moeda {

    // Atributos da classe Moeda 
    TipoMoeda nome;
    double valor;

    // Construtor da classe Moeda, que inicializa o nome e o valor da moeda
    public Moeda(TipoMoeda nome, double valor) {
        this.nome = nome;  
        this.valor = valor;  
    }

    // Método getter para o atributo nome da moeda
    public TipoMoeda getNome() {
        return nome;  
    }

    // Método getter para o atributo valor da moeda
    public double getValor() {
        return valor;  
    }

    
    // Método abstrato que exibe informações sobre a moeda
    public abstract void info();

    // Método abstrato que realiza a conversão da moeda para real
    public abstract double converter();
}
