package interfaces;

import dto.ReceptyItem;

import java.util.List;

public interface ItensHandle {
    List<ReceptyItem> getAllitens();
    ReceptyItem getitem(int id);
    void addItem(ReceptyItem item);
}
