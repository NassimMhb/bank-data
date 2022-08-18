import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Transaction {
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String EMPTY_VALUE = "          ";

    private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    private Montant value;
    private LocalDate date;

    public Transaction(Montant value, LocalDate date) {
        this.value = value;
        this.date = date;
    }

    public Montant fctResultApresTransaction(Montant resultCourant) {
        return resultCourant.plus(value);
    }

    public void printTo(PrintStream printer, Montant resultCourant) {
        StringBuilder builder = new StringBuilder();
        addDateTo(builder);
        addValueTo(builder);
        addCurrentBalanceTo(builder, resultCourant);
        printer.println(builder.toString());
    }

    private void addCurrentBalanceTo(StringBuilder builder, Montant currentBalance) {
        builder.append("| ")
                .append(currentBalance.moneyRepresentation());
    }

    private void addValueTo(StringBuilder builder) {
        if (value.isGreaterThan(Montant.amountOf(0))) {
            addCreditTo(builder);
        } else {
            addDebitTo(builder);
        }
    }

    private void addDebitTo(StringBuilder builder) {
        builder.append(EMPTY_VALUE)
                .append("|")
                .append(valueToString());
    }

    private void addCreditTo(StringBuilder builder) {
        builder.append(valueToString())
                .append("|")
                .append(EMPTY_VALUE);
    }

    private String valueToString() {
        String stringValue = " " + value.absoluteValue().moneyRepresentation();
        return stringValue;
    }

    private void addDateTo(StringBuilder builder) {
        builder.append(date.toString());
        builder.append(" |");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        Transaction other = (Transaction) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
