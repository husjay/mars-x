package com.mars.x.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by sj.hu on 2019/4/24.
 */
public class CallableClassTest {

    @Test
    public void test() {

        HashSet<String> config = new HashSet<String>();
        config.add("0030010");
        config.add("012001");

        String str = "012001,002001,003001,004001";
        HashSet<String> strings = new HashSet<String>(new ArrayList<String>(Arrays.asList(str.split(","))));
        System.out.println(strings);
        System.out.println(strings.containsAll(config));

    }

}