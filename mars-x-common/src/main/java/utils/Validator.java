package utils;

/**
 * Created by sj.hu on 2019/4/2.
 */
public class Validator {

    public static boolean isLetterDigitOrChinese(String str) {
        String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
        return str.matches(regex);
    }

}
