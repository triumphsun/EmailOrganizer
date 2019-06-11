package com.suntri.utils;

import java.util.Comparator;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/5
 */

public class EmailAddressComparator implements Comparator <String> {

    private DomainNameComparator domainNameComparator = new DomainNameComparator();

    @Override
    public int compare(String address1, String address2){
        //System.out.println(String.format("Comparre %s <--> %s", address1, address2));
        if(address1.equals(address2))
            return 0;

        String domain1 = address1.substring(address1.indexOf('@')+1, address1.length());
        String domain2 = address2.substring(address2.indexOf('@')+1, address2.length());
        int compareDomain = this.domainNameComparator.compare(domain1, domain2);

        if(compareDomain == 0){
            String entity1 = address1.substring(0, address1.indexOf('@'));
            String entity2 = address2.substring(0, address2.indexOf('@'));
            return (entity1.compareTo(entity2));
        }

        return compareDomain;
    }

}
