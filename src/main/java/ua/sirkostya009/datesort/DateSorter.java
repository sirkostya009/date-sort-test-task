package ua.sirkostya009.datesort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    private final static List<Integer> monthsWithR = Arrays.asList(1, 2, 3, 4, 9, 10, 11, 12);

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        return unsortedDates.stream()
                .sorted((a, b) -> {
                    boolean isAR = monthsWithR.contains(a.getMonthValue());
                    boolean isBR = monthsWithR.contains(b.getMonthValue());

                    if (isAR && isBR) {
                        return a.compareTo(b);
                    } else if (isAR) {
                        return -1;
                    } else if (isBR) {
                        return 1;
                    } else {
                        return b.compareTo(a);
                    }
                })
                .collect(Collectors.toList());
    }
}
