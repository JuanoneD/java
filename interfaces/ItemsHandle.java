package interfaces;

import dto.ReceptItem;

import java.util.List;

public interface ItemsHandle {
    List<ReceptItem> getAllItems();
    ReceptItem getItem(int id);
    void addItem(ReceptItem item);
}
