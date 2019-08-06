package com.hujie.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateUtilsTest {

    @Test
    public void isLeapYear_should_return_true() {
        assertTrue(DateUtils.isLeapYear(2000));
        assertTrue(DateUtils.isLeapYear(2004));
    }

    @Test
    public void isLeapYear_should_return_false() {
        assertFalse(DateUtils.isLeapYear(1999));
    }
}