package impl;

import dto.ReceptyItem;
import interfaces.ItensHandle;

import java.util.ArrayList;
import java.util.List;

public class ItensHandleImpl implements ItensHandle {


    private List<ReceptyItem> itemList = new ArrayList<>();

    @Override
    public List<ReceptyItem> getAllitens() {
        return new ArrayList<>(this.itemList);
    }

    @Override
    public ReceptyItem getitem(int id) {
        for (ReceptyItem item : itemList) {
            if (item.id() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void addItem(ReceptyItem item) {

        this.itemList.add(item);
    }
}