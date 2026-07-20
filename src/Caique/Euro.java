package Caique;

public class Euro extends Moeda {
    
	// Construtor da classe Real, que chama o construtor da classe mãe Moeda, e seus atributos
	public Euro(TipoMoeda nome, double valor) {
		super(nome, valor);
	}
    
	// Implementação do método info, que exibe informações sobre a moeda, como o nome e o valor dela
	@Override
	public void info() {
		System.out.println();
		System.out.println("Moeda: " + nome);
		System.out.println("Valor: " + valor);
		System.out.println("-----------");
	}
    
	// Implementação do método converter, que converte e retorna o valor da moeda para real
	@Override
	public double converter() {
		return valor*6.35;
	}

}
