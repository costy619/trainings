package The.Shortest.Path.Problem;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public interface Visitable {
     void setVisitable();
    LocalTime one = LocalTime.of(9,30);
    LocalTime two = LocalTime.of(16,00);
    LocalDate date = LocalDate.of(2019, 1, 29);

     default Duration getVisitingDuration(){
        Duration d= Duration.between(two,one);
        return d;
     }
}
