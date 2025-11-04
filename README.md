Trabalho Java Terça
Usei o java 17 para rodar no linux

mkdir out
javac -d out -cp ./Main.java
java -cp out Main

Padrões utilizados

1. Singleton na Classe Scanner Terminal 

2. Dependency injection na Main
    ReceptHandle ReceptHandle = (choice == 1) ? new AllInfoRecept() : new ValueTotalOnly(); 

3. Factory Pattern na Main (Mesmo lugar que tem um Dependency injection)
    ReceptHandle ReceptHandle = (choice == 1) ? new AllInfoRecept() : new ValueTotalOnly();

Princípio SOLID: 

Open/Closed Principle (OCP)
Definição:
Classes devem estar abertas para extensão, mas fechadas para modificação.

ABERTO PARA EXTENSÃO:
// Nova implementação pode ser criada facilmente
public class MinimalRecept implements ReceptHandle {
    @Override
    public void generateRecept(List<ReceptItem> items) {
        // Nova estratégia de recibo minimalista
    }
}

FECHADO PARA MODIFICAÇÃO:
// O código principal não precisa ser alterado
// Apenas adiciona a nova opção no switch/if
ReceptHandle ReceptHandle = switch(choice) {
    case 1 -> new AllInfoRecept();
    case 2 -> new ValueTotalOnly();
    case 3 -> new MinimalRecept();  // Nova implementação
    default -> throw new IllegalArgumentException();
};

Single Responsibility Principle (SRP)
- `ReceptItem`: Apenas representa dados do item
- `ScannerTerminal`: Apenas gerencia o Scanner
- `ReceptHandle`: Apenas define contrato de geração
