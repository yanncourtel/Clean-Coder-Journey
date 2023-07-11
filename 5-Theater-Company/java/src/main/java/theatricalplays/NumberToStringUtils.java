package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberToStringUtils {
    private static NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    public static String toFormattedNumber(double number) {
        return frmt.format(number);
    }
}
