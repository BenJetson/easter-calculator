import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

/**
 * Calculates the date of Easter for a given year.
 *
 * @author Ben Godfrey;
 * @version 30 MAR 2018;
 */
public class Easter {
    
    private int a;
    private int b;
    private int c;
    private int k;
    private int p;
    private int q; 
    private int m;
    private int n;
    private int d;
    private int e;
    private Year year;
    private Month month;
    private int day;
    private LocalDate date;

    public Easter() {
        this(Year.now().getValue());
    }

    public Easter(int year) {
        this.year = Year.of(year);

        a = year % 19;
        b = year % 4;
        c = year % 7;
        k = year / 100;
        p = (13 + (8 * k)) / 25;
        q = k / 4;
        m = (15 - p + k - q) % 30;
        n = (4 + k - q) % 7;
        d = ((19 * a) + m) % 30;
        e = ((2 * b) + (4 * c) + (6 * d) + n) % 7;

        int march = 22 + d + e;
        int april = d + e - 9;

        if (march > 31) {
            month = Month.APRIL;
            day = april;
        } else {
            month = Month.MARCH;
            day = march;
        }

        date = LocalDate.of(year, month, day);

    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @return the year
     */
    public Year getYear() {
        return year;
    }

    /**
     * @return the month
     */
    public Month getMonth() {
        return month;
    }
    
    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    public String toString() {
        return String.format("[Easter: a=%d, b=%d, c=%d, k=%d, p=%d, q=%d, m=%d, n=%d, d=%d, e=%d, date=%s]",
                             a, b, c, k, p, q, m, n, d, e, date.toString());
    }

}