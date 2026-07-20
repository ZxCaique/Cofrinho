package Caique;

import java.util.ArrayList;
import java.util.Iterator;

public class Cofrinho {

    private ArrayList<Moeda> listaMoedas;

    // Construtor que inicializa a lista de moedas
    public Cofrinho() {
        listaMoedas = new ArrayList<>();
    }

    // Método para adicionar moeda no cofrinho
    public void adicionar(Moeda m) {
        listaMoedas.add(m);
        System.out.println("Moeda adicionada com êxito!");
        System.out.println();
    }
    
 // Método para remover moeda do cofrinho
    public void remover(Moeda m) {
        // Verifica se o cofrinho está vazio, e imprime uma mensagem se estiver.
        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho está vazio");
            System.out.println();  
            return;  
        }

        // Cria um iterador para percorrer a lista de moedas
        Iterator<Moeda> iterator = listaMoedas.iterator();
        
        boolean verificarMoedaRemovida = false;

        // Percorre a lista de moedas enquanto houver moedas para verificar
        while (iterator.hasNext()) {
            Moeda moeda = iterator.next();  // Obtém a próxima moeda da lista

            // Verifica se a moeda encontrada na lista tem o mesmo nome e valor da moeda a ser removida e remove ela
            if (moeda.getNome().equals(m.getNome()) && moeda.getValor() == m.getValor()) {
                iterator.remove();
                System.out.println("Moeda removida com êxito!");  
                System.out.println();  
                verificarMoedaRemovida = true;
                break;  
            }
        }

        // Se o iterador percorreu toda a lista e não encontrou a moeda para remover, imprime uma mensagem
        if (!verificarMoedaRemovida) {
            System.out.println("Moeda não encontrada");  
            System.out.println();  
        }
    }

    // Método para listar as moedas do cofrinho
    public void listagemMoedas() {
        // Verifica se o cofrinho está vazio
        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho está vazio");
            System.out.println();
            return;  
        }

        // Exibe informações de todas as moedas na lista
        for (Moeda m : listaMoedas) {
            m.info();
        }
    }

    // Método para calcular o valor total convertido das moedas
    public double totalConvertido() {
        double valorConversao = 0;

        // Verifica se o cofrinho está vazio
        if (listaMoedas.isEmpty()) {
            System.out.println("Seu cofrinho não possui moedas");
            System.out.println();
            return 0;  
        }

        // Itera sobre as moedas e soma o valor convertido de cada uma
        for (Moeda m : listaMoedas) {
            valorConversao += m.converter();
        }

        return valorConversao; 
    }
}
