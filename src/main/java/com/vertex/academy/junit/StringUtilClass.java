package com.vertex.academy.junit;

import java.util.Optional;

/**
 * Created by vertex0007 on 25.03.2017.
 */
public class StringUtilClass implements StringUtil {

    @Override
    public boolean isPalindrome(String suspect) {
       return  Optional.ofNullable(suspect).map(s->s.equalsIgnoreCase(revertString(s))).orElse(false);


    }

     @Override
    public String revertString(String s) {
        StringBuilder sb = new StringBuilder(s);
       return sb.reverse().toString();
    }
}
