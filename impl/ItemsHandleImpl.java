package impl;

import dto.ReceptItem;
import interfaces.ItemsHandle;

import java.util.ArrayList;
import java.util.List;

public class ItemsHandleImpl implements ItemsHandle {

    private List<ReceptItem> itemList = new ArrayList<>();

    @Override
    public List<ReceptItem> getAllItems() {
        return new ArrayList<>(this.itemList);
    }

    @Override
    public ReceptItem getItem(int id) {
        for (ReceptItem item : itemList) {
            if (item.id() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void addItem(ReceptItem item) {

        this.itemList.add(item);
    }
}