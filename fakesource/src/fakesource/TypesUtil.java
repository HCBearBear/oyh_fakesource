package fakesource;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import static java.util.Objects.nonNull;

/**
 * TypesUtil
 *
 * @author Sero
 * @since 2021/10/22
 **/
public final class TypesUtil {

    private TypesUtil() {}

    // 科學記號表示法正規表達式
    private static final String SCIENTIFIC_NOTATION_REGEX = "[+-]?\\d[.]?\\d*[Ee][+-]?\\d+";
    // 數字正規表達式
    private static final String NUMBER_PATTERN_REGEX = "^[+-]?\\d+(\\.\\d+)?$";

    /**
     * 轉換字串，若為null則不轉換
     *
     * @param object object
     * @return String
     */
    public static String parseStr(Object object) {
        if (object == null || typeInvalid(object))
            return null;
        String result = String.valueOf(object);
        // 防止科學記號問題，自我轉換
        if (object instanceof BigDecimal || result.matches(SCIENTIFIC_NOTATION_REGEX)) {
            BigDecimal resultBd = object instanceof BigDecimal ? ((BigDecimal) object) : new BigDecimal(result);
            result = resultBd.toPlainString();
        } else {
            result = String.valueOf(object);
        }
        return result;
    }

    

    private static boolean typeInvalid(Object object) {
        Class<?> parseClass = object.getClass();
        switch (parseClass.getSimpleName()) {
            case "String":
            case "Byte":
            case "Integer":
            case "Double":
            case "Long":
            case "Float":
            case "Short":
            case "BigDecimal":
            case "BigInteger":
                return false;
            default:
                return true;
        }
    }
    public static String parseStrZeroPadding(Object object, int formatLength) {
        String str = null;
        Integer integer = parseInteger(object);
        if (integer != null) {
            String format = "%0" + formatLength + "d";
            str = String.format(format, integer);
        }
        return str;
    }
    public static Integer parseInteger(Object object) {
        if (object == null || typeInvalid(object)) {
            return null;
        }
        if (object instanceof BigDecimal) {
            return ((BigDecimal) object).intValue();
        }

        Integer integer = null;
        String str = StringUtil.defaultBlank(parseStr(object), "");
        if (str.matches("[+-]?\\d+")) {
            integer = Integer.parseInt(str);
        }
        return integer;
       
    }
}