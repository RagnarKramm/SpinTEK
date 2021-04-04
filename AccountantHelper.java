package spintek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AccountantHelper {

    private final Integer year;
    private final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd.MM.yyyy");

    public AccountantHelper(Integer year) {
        this.year = year;
    }

    public List<MyDate> generateDates() {
        List<MyDate> result = new ArrayList<>();

        for (int i = 1; i < 13; i++) {
            LocalDate payday;
            String month;
            if (i < 10) {
                month = "0" + i +".";
            } else {
                month = i + ".";
            }
            payday =  LocalDate.parse("10." + month + year, formatter);

            payday = checkDate(payday);

            LocalDate remainder = payday.minusDays(3);

            remainder = checkDate(remainder);

            MyDate myDate = new MyDate(payday, remainder);

            result.add(myDate);


        }
        return  result;
    }

    private LocalDate checkDate(LocalDate date) {

        if (isOnGoodFriday(date)) {
            date = date.minusDays(1);

        }

        if (isOnWeekend(date)) {
            date = date.minusDays(1);
            if (isOnWeekend(date)) {
                date = date.minusDays(1);
            }
        }
        return date;
    }




    private boolean isOnGoodFriday(LocalDate date) {

//        Logic for calculating easter date: https://www.codeproject.com/Articles/10860/Calculating-Christian-Holidays

        int year = date.getYear();
        int day;
        int month;

        int g = year % 19;
        int c = year / 100;
        int h = (c - (c / 4) - ((8 * c) / 25) + 19 * g + 15) % 30;
        int i = h - (h / 28) * (1 - (h / 28) * (29 / (h + 1)) * ((21 - g) / 11));

        day = i - ((year + (year / 4) + i + 2 - c + (c / 4)) % 7) + 28;
        month = 3;

        if (day > 31) {
            month++;
            day -= 31;
        }
        LocalDate goodFridayDate;
        if (day == 2) {
            month--;
            day = date.lengthOfMonth();
            goodFridayDate = LocalDate.of(year, month, day);
        } else if (day == 1) {
            month--;
            day = date.lengthOfMonth();
            goodFridayDate = LocalDate.of(year, month, day - 1);
        } else {
            goodFridayDate = LocalDate.of(year, month, day - 2);
        }

        return date.compareTo(goodFridayDate) == 0;

    }

    private boolean isOnWeekend(LocalDate date) {

        int dayOfWeek = date.getDayOfWeek().getValue();

        return dayOfWeek == 6 || dayOfWeek == 7;
    }

}
