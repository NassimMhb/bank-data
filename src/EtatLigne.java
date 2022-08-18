import java.io.PrintStream;
public class EtatLigne {
    private Transaction transaction;
    private Montant currentBalance;

    public EtatLigne(Transaction transaction, Montant currentBalance) {
        this.transaction = transaction;
        this.currentBalance = currentBalance;
    }

    public void printTo(PrintStream printer) {
        this.transaction.printTo(printer, currentBalance);
    }
}
