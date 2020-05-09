package tema4ex2;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();
        LocalDate d1 = LocalDate.of(2019, 1, 1);
        StockUpdate stockUp1 = new StockUpdate("AMZNn", d1, 100);
        stockMarket.addd(stockUp1);
        LocalDate d2 = LocalDate.of(2019, 3, 3);
        StockUpdate stockUp2 = new StockUpdate("AMZN", d2, 200);
        stockMarket.addd(stockUp2);
        LocalDate d3 = LocalDate.of(2020, 5, 4);
        StockUpdate stockUp3 = new StockUpdate("MSFT", d3, 300);
        stockMarket.addd(stockUp3);
        LocalDate d4 = LocalDate.of(2021, 5, 4);
        StockUpdate stockUp4 = new StockUpdate("AMZN", d4, 400);
        stockMarket.addd(stockUp4);
        StockUpdate stockUp5 = new StockUpdate("MSFT", d4, 300);
        stockMarket.addd(stockUp5);

        stockMarket.queryUpdates(d1, d4);
        stockMarket.queryUpdates(d1, d4, "AMZN");

        stockMarket.getPrice(d1,"AMZN");

        //   System.out.println(stockMarket.tree.ceiling(d1));
        stockMarket.getPrices(d4);

    }
}