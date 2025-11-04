package impl;

import java.util.List;

import dto.ReceptyItem;
import interfaces.ReceptyHandle;

public class ValueTotalOnly implements ReceptyHandle {
    @Override
    public void generateRecepty(List<ReceptyItem> items) {
        float total = 0;

        for (ReceptyItem item : items) {
            total += item.subTotalValue();
        }

        System.out.println("Valor total da Nota: R$ " + String.format("%.2f", total));

    }
}
