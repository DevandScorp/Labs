package Lab_6.v_5;

import java.util.*;
import java.text.*;

public class DateLocaleFormat {

    public static String getTimeStyle(Date now,Locale currentLocale) {
        DateFormat formatter = DateFormat.getTimeInstance(DateFormat.FULL, currentLocale);
        return formatter.format(now);
    }

}

