package impl;

import java.util.List;

import dto.ReceptItem;
import interfaces.ReceptHandle;

public class ValueTotalOnly implements ReceptHandle {
    @Override
    public void generateRecept(List<ReceptItem> items) {
        float total = 0;

        for (ReceptItem item : items) {
            total += item.subTotalValue();
        }

        System.out.println("Valor total da Nota: R$ " + String.format("%.2f", total));

    }
}
