package dto;

public record ReceptyItem (
    String nome,
    float unitValue,
    int quantity, 
    float subTotalValue
) {}
