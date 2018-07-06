package com.minseokism.base;

import lombok.NonNull;
import lombok.val;
import org.hamcrest.core.IsNull;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class LombokTests {

    @Test
    public void 롬복_val() {
        val strVal = "hi";
        System.out.println(strVal);

        val arrVal = new ArrayList<String>();
        arrVal.add("하나");
        arrVal.add("둘");

        for (String str:
             arrVal) {
            System.out.println(str);
        }

        val intVal = 125;
        System.out.println(intVal + 5);

        val boolVal = true;
        System.out.println(!boolVal);
    }

    public String prt1(String str) {
        return str;
    }

    public String prt2(@NonNull String str) {
        return str;
    }


    @Test(expected = NullPointerException.class)
    public void 롬복_NonNull() {
        assertThat(prt1(null), is(nullValue()));
        assertThat(prt1(null), is(IsNull.nullValue()));

        prt2(null); // NullPointerException 발생
    }

}
