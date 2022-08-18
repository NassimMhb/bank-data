import java.io.PrintStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Etat {
    private static final int TOP_OF_THE_LIST = 0;

    public static final String STATEMENT_HEADER = "date       | credit   | debit    | balance";

    private List<EtatLigne> statementLines = new LinkedList<EtatLigne>();

    public void addLineContaining(Transaction transaction, Montant currentBalance) {
        statementLines.add(TOP_OF_THE_LIST, new EtatLigne(transaction, currentBalance));
    }

    public void printTo(PrintStream printer) {
        printer.println(STATEMENT_HEADER);
        printStatementLines(printer);
    }

    private void printStatementLines(PrintStream printer) {
        for (EtatLigne statementLine : statementLines) {
            statementLine.printTo(printer);
        }
    }
}
