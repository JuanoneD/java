//singleton pattern

public class ScannerTerminal{
    private static java.util.Scanner instance;

    private ScannerTerminal() {}

    public static java.util.Scanner getInstance() {
        if (instance == null) {
            instance = new java.util.Scanner(System.in);
        }
        return instance;
    }

    public static void closeInstance() {
        if (instance != null) {
            instance.close();
            instance = null;
        }
    }

}
