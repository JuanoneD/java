package interfaces;

import dto.ReceptyItem;
import java.util.List;

public interface ReceptyHandle {
    void generateRecepty(List<ReceptyItem> items);
} 
