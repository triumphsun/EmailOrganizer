package com.suntri.utils;

import java.util.Comparator;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/5
 */

public class DomainNameComparator implements Comparator <String> {

    @Override
    public int compare(String domain1, String domain2) {
        if(domain1.equals(domain2)){
            return 0;
        }

        String [] token1 = domain1.split("\\.");
        String [] token2 = domain2.split("\\.");

        int length = Math.min(token1.length, token2.length);
        for(int i=0; i<length; i++){
            String d1 = token1[token1.length-1-i];
            String d2 = token2[token2.length-1-i];
            int compare = d1.compareTo(d2);
            if(compare != 0){
                return compare;
            }
        }

        if(token1.length == token2.length){
            return 0;
        } else {
            return (token1.length > token2.length) ? 1 : -1;
        }
    }
}
