package ua.sirkostya009.datesort;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DateSorter sorter = new DateSorter();

        // 2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2004, 7, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3)
        );

        Collection<LocalDate> sortedDates = sorter.sortDates(dates);

        System.out.println(sortedDates); // 2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01
    }
}
