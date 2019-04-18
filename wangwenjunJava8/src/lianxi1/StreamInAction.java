package lianxi1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName StreamInAction
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/25 0025 22:40
 * @Version 1.0
 **/
public class StreamInAction {
    public static void main(String[] args) {
        Trader mario = new Trader("Mario", "Milan");
        Trader alan =new Trader("Alan","Cambridge");
        Trader brian  =new Trader("Brian","Cambridge");
        Trader raoul  =new Trader("Raoul", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        List<Transaction> collect = transactions.stream().filter(transaction -> transaction.getYear() > 2011)
                .sorted(Comparator.comparing(transaction -> transaction.getValue()))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .distinct().forEach(System.out::println);

        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList())
                .forEach(System.out::println);

        String value = transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct().sorted().reduce("",(name1, name2) -> name1 + name2);
        System.out.println(value);

        transactions.stream().map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Milan")).distinct().collect(Collectors.toList())
                .forEach(System.out::println);

        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue).forEach(System.out::println);
        System.out.println("=============================================");
        Optional<Integer> reduce = transactions.stream().map(Transaction::getValue).reduce(Math::max);
        reduce.ifPresent(System.out::println);

        transactions.stream().map(transaction -> transaction.getValue()).reduce((i,j)->i>j?j:i).ifPresent(System.out::println);
    }
}
