package dto;

public record ReceptyItem (
    int id,
    String nome,
    float unitValue,
    int quantity, 
    float subTotalValue
) {}
