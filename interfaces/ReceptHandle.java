package interfaces;

import dto.ReceptItem;
import java.util.List;

public interface ReceptHandle {
    void generateRecept(List<ReceptItem> items);
} 
