import java.time.LocalDate;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Compte compte = new Compte(new Etat());

        LocalDate date = LocalDate.of(2022, 01, 05);
        LocalDate date2 = LocalDate.of(2022, 05, 10);
        LocalDate date3 = LocalDate.of(2022, 11, 12);


        compte.depot(Montant.amountOf(1000), date);
        compte.depot(Montant.amountOf(2000), date2);
        compte.retrait(Montant.amountOf(500), date3);

        compte.printEtat(System.out);


    }
}