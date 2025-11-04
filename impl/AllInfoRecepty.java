package impl;

import java.sql.SQLOutput;
import java.util.List;

import dto.ReceptyItem;
import interfaces.ReceptyHandle;

public class AllInfoRecepty implements ReceptyHandle{
    @Override
    public void generateRecepty(List<ReceptyItem> items) {
        float total = 0;

        for(ReceptyItem item: items){
            System.out.println("Produto: " + item.nome());
            System.out.println("Valor: " + item.unitValue());
            System.out.println("Quantidade: " + item.quantity());
            System.out.println("SubTotal: " + item.subTotalValue());
            System.out.println("\n");
            total += item.subTotalValue();
        }
        System.out.println("Valor Total: R$ " + String.format("%.2f", total));
    }
}
