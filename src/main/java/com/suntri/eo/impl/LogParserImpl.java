package com.suntri.eo.impl;

import com.suntri.eo.Email;
import com.suntri.eo.EmailImpl;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/3
 */

public class LogParserImpl implements Email.Deserializer <String> {

    @Override
    public Email deserialize(String line) {
        int start = line.indexOf("<");
        int end = line.indexOf(">");
        //System.out.println(String.format("strat=%d, end=%d", start, end));
        String address;
        String subject = line.substring(line.lastIndexOf(",")+1, line.length());
        try{
            address = line.substring(start+1, end).toLowerCase();
        } catch (IndexOutOfBoundsException e){
            address = "dummy@dummy.com";
        }
        //System.out.println(String.format("Address: %s", address));
        return new EmailImpl(address, subject);
    }

}
