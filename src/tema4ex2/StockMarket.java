package tema4ex2;

import java.time.LocalDate;
import java.util.*;

public class StockMarket {

    List<StockUpdate> updates = new ArrayList<>();
    TreeSet<StockUpdate> tree = new TreeSet<>();
    Map<String, Double> map = new HashMap<>();

    void addd(StockUpdate update) {
        updates.add(update);
//        for (int i = 0; i < updates.size(); i++) {
//            System.out.println(updates.get(i).getStockCode()+updates.size());
//        }
    }

    List<StockUpdate> queryUpdates(LocalDate from, LocalDate to) {
        List<StockUpdate> queryUpdates = new ArrayList<>();
        for (int i = 0; i < updates.size(); i++) {
            if (updates.get(i).getTimeOfTheUpdate().isAfter(from) && updates.get(i).getTimeOfTheUpdate().isBefore(to)) {
                queryUpdates.add(updates.get(i));
            }
        }
        for (int i = 0; i < queryUpdates.size(); i++) {
            System.out.println("Stocurile dintre cele 2 date sunt: " + queryUpdates.get(i).getStockCode());
            System.out.println(queryUpdates.get(i).getTimeOfTheUpdate());
        }
        return queryUpdates;
    }

    List<StockUpdate> queryUpdates(LocalDate from, LocalDate to, String stockCode) {
        List<StockUpdate> queryUpdates = new ArrayList<>();
        for (int i = 0; i < updates.size(); i++) {
            if (updates.get(i).getTimeOfTheUpdate().isAfter(from) && updates.get(i).getTimeOfTheUpdate().isBefore(to) && updates.get(i).getStockCode().equals(stockCode)) {
                queryUpdates.add(updates.get(i));
            }
        }
        for (int i = 0; i < queryUpdates.size(); i++) {
            System.out.println("Stocurile dintre cele 2 date dupa codul specificat sunt: " + queryUpdates.get(i).getStockCode());
        }
        return queryUpdates;
    }

    Double getPrice(LocalDate date, String stockCode) {
        tree.addAll(updates);
        double price = 0;
        //varianta 1
        for (StockUpdate s : tree) {
            price = s.getPriceNote();
            if (s.getTimeOfTheUpdate().equals(date) && s.getStockCode().equals(stockCode)) {
                System.out.println("Pretul stocului de pe data specificata este :" + price);
            }
            else {
//                System.out.println("Stocul nu a fost updatat pe data specificata, aceasta este data cea mai apropiata");
//                //............
            }
        }
        //varianta 2
//        Iterator<StockUpdate> itrr = updates.iterator();
//        while (itrr.hasNext()) {
//            StockUpdate el = itrr.next();
//            if(el.getTimeOfTheUpdate().equals(date) && el.getStockCode().equals(stockCode)){
//                System.out.println(el.getPriceNote());
////            }else{
////                StockUpdate data = tree.ceiling(el);
////                System.out.println(data.getTimeOfTheUpdate());
//            }
//        }
        return price;
    }

    Map<String, Double> getPrices(LocalDate date) {

        Iterator<StockUpdate> itrr = updates.iterator();
        while (itrr.hasNext()) {
            StockUpdate el = itrr.next();
            if(el.getTimeOfTheUpdate().equals(date)){
                map.put(el.getStockCode(), el.getPriceNote());
            }
        }

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return map;
    }


}