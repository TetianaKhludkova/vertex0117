package com.vertex.academy;


import com.vertex.academy.junit.StringUtil;
import com.vertex.academy.junit.StringUtilClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vertex0007 on 25.03.2017.
 */
public class StringUnitTest  {
StringUtil underTest;

    @Before
    public void setUnderTest(){
        underTest=new StringUtilClass();
    }
    @Test
    public void isPalindrome(){
      boolean result = underTest.isPalindrome("ABA");
        //assert result==true : "WRONG";
        assertEquals("FAIL!","true",Boolean.toString(result));
        System.out.println("EVERYTHING IS FINE");
    }
           // TODO https://sourcemaking.com/design_patterns/behavioral_patterns

}
