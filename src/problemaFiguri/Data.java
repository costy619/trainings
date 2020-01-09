package problemaFiguri;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
public class Data {
    public static void main( String[] not_in_use ) {
//        LocalDate my_birthday = LocalDate.of(1994, 05, 15);
//        LocalDate date_now = LocalDate.now();
//        Period my_age= my_birthday.until(date_now);
//        System.out.println(my_age.getYears()+" ani  "+my_age.getMonths()+" luni "+my_age.getDays()+" zile");
        System.out.println(" Introdu numarul de persoane ");
        Scanner keyboard = new Scanner(System.in);
        int numarDePersoane = 0;
        numarDePersoane = keyboard.nextInt();
        keyboard.nextLine();
        for (int i = 0; i < numarDePersoane; i++) {
            LocalDate date_now1 = LocalDate.now();
            System.out.println("introdu datele");
            String date_of_birth_as_string = keyboard.nextLine();
            String lineArr[];
            lineArr = date_of_birth_as_string.split("-");
            LocalDate date_of_birth = LocalDate.parse(date_of_birth_as_string);
            LocalDate my_birthday1 = LocalDate.of(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1]), Integer.parseInt(lineArr[2]));
            Period my_age1 = my_birthday1.until(date_now1);
            int years_to_celebrate = my_age1.getYears();
            System.out.println(my_age1.getYears());

            while (years_to_celebrate > 0 && years_to_celebrate < 100) {
                LocalDate date_to_celebrate = date_of_birth.plusYears(years_to_celebrate);
                System.out.printf("\n   %1$d years old on %2$tF (%2$tA)",
                        years_to_celebrate,
                        date_to_celebrate);
                System.out.println();
                years_to_celebrate = years_to_celebrate + 1;
            }
            System.out.println();
            int years_to_celebrate1;
            int day_counter = 0;
            long secondsCounter=0;
            LocalDate date_to_increment = LocalDate.of(my_birthday1.getYear(), my_birthday1.getMonth(), my_birthday1.getDayOfMonth());
            while (day_counter < 20001) {
                LocalDate my_birthday2 = LocalDate.of(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1]), Integer.parseInt(lineArr[2]));
                LocalDate date_to_celebrate1=date_of_birth.plusDays(day_counter);
                Period my_age2 = my_birthday2.until(date_to_celebrate1);
                date_to_increment = date_to_increment.plusDays(1);
                 years_to_celebrate1 =date_to_increment.getYear()-Integer.parseInt(lineArr[0]);
                day_counter++;
                if ((day_counter % 20000) == 0||day_counter%10000==0) {
                    System.out.printf("\n   %1$d days old on %2$tF (%2$tA)",
                            day_counter,
                            date_to_celebrate1);
                    System.out.println(my_age2.getYears()+" years "+my_age2.getMonths()+" months "+my_age2.getDays()+" days");
                }
            }
            int day_counter1 = 0;
            while(secondsCounter< 100000001) {
                LocalDate my_birthday3 = LocalDate.of(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1]), Integer.parseInt(lineArr[2]));
                LocalDate date_to_celebrate2=date_of_birth.plusDays(day_counter1);
                Period my_age3 = my_birthday3.until(date_to_celebrate2);
                secondsCounter++;
                if(secondsCounter%86400==0){
                    day_counter1++;
                    date_to_increment = date_to_increment.plusDays(1);
                }
                if (secondsCounter %100000000==0) {
                    System.out.printf("\n   %1$d seconds old on %2$tF (%2$tA)",
                            secondsCounter,
                            date_to_celebrate2);
                    System.out.println(my_age3.getYears() + " years " + my_age3.getMonths() + " months " + my_age3.getDays() + " days");
                }
            }
        }
    }
}
