import java.util.ArrayList;

import interfaces.ReceptHandle;
import interfaces.ItemsHandle;
import dto.ReceptItem;
import impl.*;

public class Main {

       public static void carregarCatalogo(ItemsHandle catalogo) {

        catalogo.addItem(new ReceptItem(1, "Arroz", 25.50f, 1, 25.50f));
        catalogo.addItem(new ReceptItem(2, "Feijao", 8.99f, 1, 8.99f));
        catalogo.addItem(new ReceptItem(3, "Bolacha", 7.50f, 1, 7.50f));
        catalogo.addItem(new ReceptItem(4, "Leite", 4.80f, 1, 4.80f));
        catalogo.addItem(new ReceptItem(5, "Cafe", 15.00f, 1, 15.00f));
        catalogo.addItem(new ReceptItem(6, "Pao", 6.20f, 1, 6.20f));
        catalogo.addItem(new ReceptItem(7, "Miojo", 9.00f, 1, 9.00f));
        catalogo.addItem(new ReceptItem(8, "Moranguete", 0.50f, 1, 5.50f));
        catalogo.addItem(new ReceptItem(9, "Refrigerante", 8.00f, 1, 8.00f));
        catalogo.addItem(new ReceptItem(10, "Balinha de Véio", 1.00f, 1, 4.50f));
    }


    public static void mostrarCatalogo(ItemsHandle catalogo) {
        System.out.println();
        System.out.println("ID   Produto   Valor Unidade");
        System.out.println("---------------------------------");
        for (ReceptItem item : catalogo.getAllItems()) {
            String precoFormatado = String.format("R$ %.2f", item.unitValue());
            System.out.printf("%d | %s | %s\n", item.id(), item.name(), precoFormatado);
        }
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {

        ItemsHandle catalogo = new ItemsHandleImpl();
        carregarCatalogo(catalogo);

        ArrayList<ReceptItem> carrinho = new ArrayList<>();

        System.out.println("Voce deseja gerar qual tipo de Nota? \n 1 - Nota com todas as informacoes \n 2 - Nota com valor total apenas");
        int choice = ScannerTerminal.getInstance().nextInt();

        ReceptHandle ReceptHandle = (choice == 1) ? new AllInfoRecept() : new ValueTotalOnly();


        while (true) {
            System.out.println("Escreva 0 para finalizar a nota");
            System.out.println("Escreva 1 para adicionar um item (Ver catalogo)");
            int action = ScannerTerminal.getInstance().nextInt();

            if (action == 0) {
                System.out.println("\nFinalizando a nota...");
                ReceptHandle.generateRecept(carrinho);
                break;
            } else if (action == 1) {
                mostrarCatalogo(catalogo);


                System.out.println("Digite o ID do produto que deseja adicionar:");
                int idEscolhido = ScannerTerminal.getInstance().nextInt();

                ReceptItem itemDoCatalogo = catalogo.getItem(idEscolhido);

                if (itemDoCatalogo == null) {
                    System.out.println("ID invalido. Produto nao encontrado.");
                } else {

                    System.out.println("Digite a quantidade de '" + itemDoCatalogo.name() + "':");
                    int quantidade = ScannerTerminal.getInstance().nextInt();

                    if (quantidade <= 0) {
                        System.out.println("Quantidade invalida.");
                    } else {
                        float subTotal = itemDoCatalogo.unitValue() * quantidade;

                        ReceptItem itemParaCarrinho = new ReceptItem(
                                itemDoCatalogo.id(),
                                itemDoCatalogo.name(),
                                itemDoCatalogo.unitValue(),
                                quantidade,
                                subTotal
                        );

                        carrinho.add(itemParaCarrinho);
                        System.out.println(quantidade + "x '" + itemDoCatalogo.name() + "' adicionado(s) ao carrinho.");
                    }
                }
            } else {
                System.out.println("Acao invalida. Tente novamente.");
            }
        }

        ScannerTerminal.closeInstance();
    }
}