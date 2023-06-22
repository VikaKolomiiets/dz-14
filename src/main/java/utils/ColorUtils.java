package utils;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtils {
    private static final int RANGE_OF_INACCURACY = 10;

    private static boolean isColorInGivenRange(String actualColorString, String expectedColorString) {
        return isColorInGivenRange(actualColorString, expectedColorString, RANGE_OF_INACCURACY);
    }

    private static boolean isColorInGivenRange(String actualColorString, String expectedColorString, int inaccuracy) {
        Color actualColor = parseColor(expectedColorString);
        System.out.println("actualColorString = " + actualColorString);
        Color expectedColor = parseColor(actualColorString);

        return (Math.abs(actualColor.getRed() - expectedColor.getRed()) < inaccuracy)
                && (Math.abs(actualColor.getGreen() - expectedColor.getGreen()) < inaccuracy)
                && (Math.abs(actualColor.getBlue() - expectedColor.getBlue()) < inaccuracy);
    }

    public static Color parseColor(String input) {
        Pattern c = Pattern.compile("rgb *\\( *([0-9]+), *([0-9]+), *([0-9]+) *\\)");
        Matcher m = c.matcher(input);

        if (m.matches()) {
            return new Color(Integer.valueOf(m.group(1)),  // red
                    Integer.valueOf(m.group(2)),  // green
                    Integer.valueOf(m.group(3)), // blue
                    1);
        }
        return null;
    }
}
