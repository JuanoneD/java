package impl;

import java.util.List;

import dto.ReceptItem;
import interfaces.ReceptHandle;

public class AllInfoRecept implements ReceptHandle{
    @Override
    public void generateRecept(List<ReceptItem> items) {
        float total = 0;

        for(ReceptItem item: items){
            System.out.println("Produto: " + item.name());
            System.out.println("Valor: " + item.unitValue());
            System.out.println("Quantidade: " + item.quantity());
            System.out.println("SubTotal: " + item.subTotalValue());
            System.out.println("\n");
            total += item.subTotalValue();
        }
        System.out.println("Valor Total: R$ " + String.format("%.2f", total));
    }
}
