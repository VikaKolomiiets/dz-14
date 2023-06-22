package utils;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtils {
    private static final int RED_COLOR_INACCURACY = 10;
    private static final int GREEN_COLOR_INACCURACY = 20;
    private static final int BLUE_COLOR_INACCURACY =20;

    public static boolean isColorInGivenRange(String actualColorString, String expectedColorString) {
        return isColorInGivenRange(
                actualColorString,
                expectedColorString,
                RED_COLOR_INACCURACY,
                GREEN_COLOR_INACCURACY,
                BLUE_COLOR_INACCURACY);
    }

    public static boolean isColorInGivenRange(
            String actualColorString,
            String expectedColorString,
            int inaccuracyRed,
            int inaccuracyGreen,
            int inaccuracyBlue) {
        Color actualColor = parseColor(expectedColorString);
        System.out.println("actualColorString = " + actualColorString);
        Color expectedColor = parseColor(actualColorString);

        return (Math.abs(actualColor.getRed() - expectedColor.getRed()) < inaccuracyRed)
                && (Math.abs(actualColor.getGreen() - expectedColor.getGreen()) < inaccuracyGreen)
                && (Math.abs(actualColor.getBlue() - expectedColor.getBlue()) < inaccuracyBlue);
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
