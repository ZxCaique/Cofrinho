package Caique;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Cofrinho cofre = new Cofrinho();
    Scanner sc = new Scanner(System.in);

    // Construtor da classe Menu
    public Menu() {
        sc = new Scanner(System.in);
    }

    // Método que exibe o menu principal para o usuário
    public void exibirMenu() {
        boolean menuValido = false;

        // Loop para garantir que o menu seja exibido corretamente até uma opção válida ser selecionada
        while (!menuValido) {
            try {
                System.out.println("-------------- MENU COFRINHO --------------");
                System.out.println("Digite 1 para adicionar moedas");
                System.out.println("Digite 2 para retirar moeda");
                System.out.println("Digite 3 para listar moedas");
                System.out.println("Digite 4 para ver o valor total de moedas em real");
                System.out.println("Digite 0 para finalizar o programa");
                System.out.println("-------------------------------------------");
                System.out.println();

                // Solicita a opção desejada do usuário
                System.out.println("Digite a opção desejada: ");
                int opcao = sc.nextInt();

                // Realiza a ação conforme a opção escolhida
                switch (opcao) {
                    case 0:
                        System.out.println("Programa finalizado!");
                        break;
                    case 1:
                        menuAdd();
                        exibirMenu();
                        break;
                    case 2:
                        menuRetirar();
                        exibirMenu();
                        break;
                    case 3:
                        cofre.listagemMoedas();
                        exibirMenu();
                        break;
                    case 4:
                        double valorConvertido = cofre.totalConvertido();
                        System.out.println("O valor total de moedas em real que você possui em seu cofrinho é de: " + valorConvertido);
                        System.out.println();
                        exibirMenu();
                        break;
                    default:
                        System.out.println("Opção inválida, digite uma opção valida");
                        System.out.println();
                        exibirMenu();
                        break;
                }
                menuValido = true;  // Sai do loop se uma opção válida for escolhida
            } catch (InputMismatchException e) {
                // Trata erro quando o usuário digita uma opção inválida 
                System.out.println("Opção inválida, digite uma opção valida");
                System.out.println();
                sc.nextLine(); 
            }
        }
    }

    // Método para adicionar moedas ao cofre
    public void menuAdd() {
        boolean tipoMoedaValido = false;
        boolean valorMoedaValido = false;
        TipoMoeda tipoMoeda = null;

        // While valida o tipo de moeda inserido pelo usuário para ser adicionado corretamente
        while (!tipoMoedaValido) {
            try {
                System.out.println("Digite o tipo de moeda que deseja adicionar (Real/Dolar/Euro): ");
                String moedaTipo = sc.next().toUpperCase();  
                tipoMoeda = TipoMoeda.valueOf(moedaTipo);  // Converte a string para enum TipoMoeda

                tipoMoedaValido = true;  // Se o tipo for válido, sai do loop
            } catch (IllegalArgumentException e) {
                // Se o tipo de moeda não for válido, exibe erro
                System.out.println("Opção inválida, digite uma das opções válidas");
                System.out.println();
                sc.nextLine(); 
            }
        }

        // While valida o valor da moeda para ser adicionado corretamente
        while (!valorMoedaValido) {
            try {
                System.out.println("Digite o valor que deseja adicionar: ");
                double valorMoeda = sc.nextDouble();

                // Verifica se o valor da moeda é negativo ou zero, caso seja o valor será invalidado
                if (valorMoeda <= 0) {
                    System.out.println("Digite um valor positivo");
                    System.out.println();
                } else {
                    // Cria o objeto Moeda com o tipo e valor informados e adiciona ao cofre
                    Moeda adicionarMoeda = null;

                    switch (tipoMoeda) {
                        case REAL:
                            adicionarMoeda = new Real(tipoMoeda, valorMoeda);
                            break;
                        case DOLAR:
                            adicionarMoeda = new Dolar(tipoMoeda, valorMoeda);
                            break;
                        case EURO:
                            adicionarMoeda = new Euro(tipoMoeda, valorMoeda);
                            break;
                    }

                    cofre.adicionar(adicionarMoeda);
                    valorMoedaValido = true;  // Sai do loop após adicionar a moeda
                }
            } catch (InputMismatchException e) {
                // Trata erro de entrada de dados quando o usuário insere um valor inválido
                System.out.println("Digite um valor válido");
                System.out.println();
                sc.nextLine(); 
            }
        }
    }

    // Método para retirar moedas do cofre
    public void menuRetirar() {
        boolean tipoMoedaValido = false;
        boolean valorMoedaValido = false;
        TipoMoeda tipoMoeda = null;

        //  While valida o tipo de moeda inserido pelo usuário para ser removida corretamente
        while (!tipoMoedaValido) {
            try {
                System.out.println("Digite o tipo de moeda que deseja remover (Real/Dolar/Euro): ");
                String moedaTipo = sc.next().toUpperCase();  
                tipoMoeda = TipoMoeda.valueOf(moedaTipo);  // Converte a string para enum TipoMoeda

                tipoMoedaValido = true;  // Se o tipo for válido, sai do loop
            } catch (IllegalArgumentException e) {
                // Se o tipo de moeda não for válido, exibe erro
                System.out.println("Opção inválida, digite uma das opções válidas");
                System.out.println();
                sc.nextLine(); 
            }
        }

        // While valida o valor da moeda para ser removida corretamente
        while (!valorMoedaValido) {
            try {
                System.out.println("Digite o valor que deseja remover: ");
                double valorMoeda = sc.nextDouble();

                //  Verifica se o valor da moeda é negativo ou zero, caso seja o valor será invalidado
                if (valorMoeda <= 0) {
                    System.out.println("Digite um valor positivo");
                    System.out.println();
                } else {
                    // Cria o objeto Moeda com o tipo e valor informados e remove do cofre
                    Moeda removerMoeda = null;

                    switch (tipoMoeda) {
                        case REAL:
                            removerMoeda = new Real(tipoMoeda, valorMoeda);
                            break;
                        case DOLAR:
                            removerMoeda = new Dolar(tipoMoeda, valorMoeda);
                            break;
                        case EURO:
                            removerMoeda = new Euro(tipoMoeda, valorMoeda);
                            break;
                    }

                    cofre.remover(removerMoeda);
                    valorMoedaValido = true;  // Sai do loop após remover a moeda
                }
            } catch (InputMismatchException e) {
                // Trata erro de entrada de dados quando o usuário insere um valor inválido
                System.out.println("Digite um valor válido");
                System.out.println();
                sc.nextLine(); 
            }
        }
    }
}
