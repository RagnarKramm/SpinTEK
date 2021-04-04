package spintek;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    public Writer(List<MyDate> dateList, String year) {

        try {
            FileWriter fileWriter = new FileWriter(year + ".csv");
            fileWriter.write(String.format("MonthOfYear;PaydayDate;ReminderDate%n"));
            System.out.printf("MonthOfYear;PaydayDate;ReminderDate%n");
            for (MyDate myDate : dateList) {
                fileWriter.write(String.format(myDate.toString() + "%n"));
                System.out.println(myDate.toString());
            }
            fileWriter.flush();
            fileWriter.close();


        }catch (IOException e) {
            System.out.println("An error occurred when writing the file.");
        }

    }
}
