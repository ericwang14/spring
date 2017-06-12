package entry;

import model.Trader;
import model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wanggang on 10/27/16.
 */
public class TraderTester {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Trader> traders = Arrays.asList(
                raoul, mario, alan, brian
        );

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        System.out.println("question 1: ");
        transactions.stream()
            .filter(t -> t.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);


        System.out.println("question 2: ");

        traders.stream()
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

        System.out.println("question 3: ");
        traders.stream()
                .filter(t -> "Cambridge".equals(t.getCity()))
                .sorted()
                .forEach(System.out::println);

        System.out.println("question 4: ");
        traders.stream()
                .map(Trader::getName)
                .sorted(String::compareTo)
                .forEach(System.out::println);

        System.out.println("question 5: ");
        System.out.println("are any traders based in Milan? " + traders.stream()
                .map(Trader::getCity)
                .anyMatch("Milan"::equals));

        System.out.println("question 6:");
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .forEach(System.out::println);

        System.out.println("question 7: ");
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);


        System.out.println("question 8: ");
        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
    }

}
