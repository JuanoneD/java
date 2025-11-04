package dto;

public record ReceptItem (
    int id,
    String name,
    float unitValue,
    int quantity, 
    float subTotalValue
) {}
