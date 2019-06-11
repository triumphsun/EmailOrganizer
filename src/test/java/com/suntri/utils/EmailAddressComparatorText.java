package com.suntri.utils;


import org.junit.Assert;
import org.junit.Test;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/11
 */

public class EmailAddressComparatorText {

    EmailAddressComparator comparator = new EmailAddressComparator();

    @Test
    public void testDomainsWithSameDepthSameLength(){
        Assert.assertTrue(comparator.compare("user@gmail.com", "user@gmail.com") == 0);     // g = g
        Assert.assertTrue(comparator.compare("user@gmail.com", "user@yahoo.com") < 0);      // g < y
        Assert.assertTrue(comparator.compare("user@gmail.com", "user@apple.com") > 0);      // g > a
    }

    @Test
    public void testDomainWithSameDepthDifferentLength(){
        Assert.assertTrue(comparator.compare("user@gmail.com", "user@citi.com") > 0);       // first is longer
        Assert.assertTrue(comparator.compare("user@gmail.com", "user@twitter.com") < 0);    // second is longer
    }

    @Test
    public void testDomainWithDifferentDepth(){
        Assert.assertTrue(comparator.compare("user@gmail.google.com", "user@google.com") > 0);
    }

    @Test
    public void testDomainWithDifferentDomain(){
        Assert.assertTrue(comparator.compare("user@mail.gmail.com", "user@mail.yahoo.com") < 0);
    }
}
