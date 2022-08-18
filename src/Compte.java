import java.io.PrintStream;
import java.time.LocalDate;

public class Compte {
    private Etat etat;

    private Montant result = Montant.amountOf(0);

    public Compte(Etat statement) {
        this.etat = statement;
    }

    public void depot(Montant value, LocalDate date) {
        enregistrementTransaction(value, date);
    }

    public void retrait(Montant value, LocalDate date) {
        enregistrementTransaction(value.negative(), date);
    }

    public void printEtat(PrintStream printer) {
        etat.printTo(printer);
    }

    private void enregistrementTransaction(Montant value, LocalDate date) {
        Transaction transaction = new Transaction(value, date);
        Montant resultApresTransaction = transaction.fctResultApresTransaction(result);
        result = resultApresTransaction;
        etat.addLineContaining(transaction, resultApresTransaction);
    }
}
