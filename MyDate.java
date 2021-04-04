package spintek;

import java.time.LocalDate;

public class MyDate {

    private final LocalDate payday;
    private final LocalDate reminder;

    public MyDate(LocalDate payday, LocalDate reminder) {
        this.payday = payday;
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return payday.getMonth() + ";" + payday.getDayOfMonth() + ";" + reminder.getDayOfMonth();
    }
}
