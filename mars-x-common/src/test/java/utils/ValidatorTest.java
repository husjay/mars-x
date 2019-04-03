package utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sj.hu on 2019/4/2.
 */
public class ValidatorTest {

    @Test
    public void testIsLetterDigitOrChinese() {

        Assert.assertEquals(true, Validator.isLetterDigitOrChinese("name"));
        Assert.assertEquals(true, Validator.isLetterDigitOrChinese("姓名"));
        Assert.assertEquals(true, Validator.isLetterDigitOrChinese("name姓名"));
        Assert.assertEquals(true, Validator.isLetterDigitOrChinese("姓名是123name"));
        Assert.assertEquals(false, Validator.isLetterDigitOrChinese("姓名：123"));

    }

}