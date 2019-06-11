package com.suntri.eo;

import com.suntri.utils.EmailAddressComparator;

import java.util.Comparator;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/3
 */

public class EmailComparator implements Comparator <Email> {

    private Comparator <String> addressComparator = new EmailAddressComparator();

    @Override
    public int compare(Email o1, Email o2) {
        String address1 = o1.getSender();
        String address2 = o2.getSender();
        return this.addressComparator.compare(address1, address2);
    }
}
