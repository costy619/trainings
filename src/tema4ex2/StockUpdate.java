package tema4ex2;

import java.time.LocalDate;
import java.util.Objects;

public class StockUpdate implements Comparable<StockUpdate> {
    String stockCode;
    LocalDate timeOfTheUpdate;
    double priceNote;

    StockUpdate(String stockCode, LocalDate timeOfTheUpdate, int priceNote) {
        this.stockCode = stockCode;
        this.timeOfTheUpdate = timeOfTheUpdate;
        this.priceNote = priceNote;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public LocalDate getTimeOfTheUpdate() {
        return timeOfTheUpdate;
    }

    public void setTimeOfTheUpdate(LocalDate timeOfTheUpdate) {
        this.timeOfTheUpdate = timeOfTheUpdate;
    }

    public double getPriceNote() {
        return priceNote;
    }

    public void setPriceNote(double priceNote) {
        this.priceNote = priceNote;
    }

    @Override
    public int compareTo(StockUpdate o) {
        return o.getTimeOfTheUpdate().compareTo(timeOfTheUpdate);
    }

    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof StockUpdate)) {
            return false;
        }
        StockUpdate s = (StockUpdate) o;
        return priceNote == s.priceNote &&
                Objects.equals(stockCode, s.stockCode) &&
                Objects.equals(timeOfTheUpdate, s.timeOfTheUpdate);
    }

    @Override
    public int hashCode() {
        return (int) this.priceNote;
    }

}