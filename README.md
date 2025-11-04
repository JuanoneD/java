Trabalho Java Terça
Usei o java 17 para rodar


javac -cp . Main.java
java Main

Padrões utilizados

1. Singleton na Classe Scanner Terminal 

public static Scanner getInstance() {
    if (instance == null) {
        instance = new Scanner(System.in);
    }
    return instance;
}

2. Dependecy injection na Main
ReceptHandle ReceptHandle = (choice == 1) ? new AllInfoRecept() : new ValueTotalOnly(); 

### 3. **Factory Pattern (Implícito)**
```java
// No Main.java - criação baseada na escolha do usuário
ReceptHandle ReceptHandle = (choice == 1) ? 
    new AllInfoRecept() : new ValueTotalOnly();
```
- **Objetivo:** Criação de objetos baseada em condições
- **Benefício:** Centraliza lógica de criação

## Princípio SOLID: **Open/Closed Principle (OCP)**

### **Definição:**
> "Classes devem estar abertas para extensão, mas fechadas para modificação."

### **Implementação no Sistema:**

**✅ ABERTO PARA EXTENSÃO:**
```java
// Nova implementação pode ser criada facilmente
public class MinimalRecept implements ReceptHandle {
    @Override
    public void generateRecept(List<ReceptItem> items) {
        // Nova estratégia de recibo minimalista
    }
}
```

**✅ FECHADO PARA MODIFICAÇÃO:**
```java
// O código principal não precisa ser alterado
// Apenas adiciona a nova opção no switch/if
ReceptHandle ReceptHandle = switch(choice) {
    case 1 -> new AllInfoRecept();
    case 2 -> new ValueTotalOnly();
    case 3 -> new MinimalRecept();  // Nova implementação
    default -> throw new IllegalArgumentException();
};
```

### **Benefícios do OCP:**
- **Extensibilidade:** Novos tipos de recibo sem alterar código existente
- **Manutenibilidade:** Mudanças isoladas em cada implementação
- **Testabilidade:** Cada estratégia pode ser testada independentemente
- **Flexibilidade:** Sistema cresce sem quebrar funcionalidades existentes

## 📊 Outros Princípios SOLID Aplicados

### **Single Responsibility Principle (SRP)**
- `ReceptItem`: Apenas representa dados do item
- `ScannerTerminal`: Apenas gerencia o Scanner
- `ReceptHandle`: Apenas define contrato de geração

### **Dependency Inversion Principle (DIP)**
- `Main` depende da abstração `ReceptHandle`, não das implementações concretas
- Facilita injeção de dependências e testes

## 🛠️ Possíveis Melhorias

1. **Implementar as funcionalidades** nos métodos `generateRecept()`
2. **Adicionar Factory Method** para criação das implementações
3. **Implementar tratamento de erros** robusto
4. **Adicionar logging** para auditoria
5. **Criar testes unitários** para cada componente

## 📚 Resumo dos Patterns
- **Singleton:** Uma instância de Scanner para toda aplicação
- **Strategy:** Diferentes formas de gerar recibos
- **Factory:** Criação de objetos baseada em escolhas do usuário
- **OCP:** Sistema extensível sem modificar código existente
