package scalaComp;

import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

import static java.text.DateFormat.LONG;

/**
 * Created by Shiyi on 9/27/2016.
 */
public class FrenchDate {
    public static void main(String[] args) {
        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance(LONG, Locale.FRANCE);
        System.out.println(df.format(now));
    }
}
