import java.text.DecimalFormat;

public class Montant {
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    private int value;

    public Montant(int value) {
        this.value = value;
    }

    public static Montant amountOf(int value) {
        return new Montant(value);
    }

    public Montant plus(Montant otherAmount) {
        return amountOf(this.value + otherAmount.value);
    }

    public boolean isGreaterThan(Montant otherAmount) {
        return this.value > otherAmount.value;
    }

    public Montant absoluteValue() {
        return amountOf(Math.abs(value));
    }

    public String moneyRepresentation() {
        return decimalFormat.format(value);
    }

    public Montant negative() {
        return amountOf(-value);
    }

    @Override
    public boolean equals(Object obj) {
        Montant other = (Montant) obj;
        if (value != other.value)
            return false;
        return true;
    }
}
