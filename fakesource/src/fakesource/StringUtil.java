package fakesource;

public class StringUtil {
    public static String defaultBlank( String text,  String defaultStr) {
        return isBlank(text) ? defaultStr : text;
    }
    public static boolean isBlank( String text) {
        return text == null || text.isEmpty();
    }
}
