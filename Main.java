import java.util.ArrayList;

import interfaces.ReceptyHandle;
import dto.ReceptyItem;
import impl.*;

public class Main {

    public static ReceptyItem addItem()
    {
        System.out.println("Digite o nome do item:");
        String nome = ScannerTerminal.getInstance().nextLine();

        System.out.println("Digite o valor unitario do item:");
        float unitValue = ScannerTerminal.getInstance().nextFloat();

        System.out.println("Digite a quantidade do item:");
        int quantity = ScannerTerminal.getInstance().nextInt();

        float subTotalValue = unitValue * quantity;

        ReceptyItem item = new ReceptyItem(nome, unitValue, quantity, subTotalValue);
        return item;
    }

    public static void main(String[] args) {

        ArrayList<ReceptyItem> items = new ArrayList<>();
        
        System.out.println("Voce desaja gerar qual tipo de de Nota? \n 1 - Nota com todas as informacoes \n 2 - Nota com valor total apenas");
        int choice = ScannerTerminal.getInstance().nextInt();

        ReceptyHandle receptyHandle = (choice == 1) ? new AllInfoRecepty() : new ValueTotalOnly(); // Dependency Injection via Factory Pattern

        while (true) {
            System.out.println("Escreva 0 para finalizar a nota e 1 para adicionar um item");
            int action = ScannerTerminal.getInstance().nextInt();

            if (action == 0) {
                System.out.println("Finalizando a nota...");
                receptyHandle.generateRecepty(items);
                items.clear();
                break;
            } else if (action == 1) {
                items.add(addItem());
            } else {
                System.out.println("Acao invalida. Tente novamente.");
            }
        }

        ScannerTerminal.closeInstance();
    }
}