package com.suntri.eo;

import java.util.Iterator;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/3
 */

public class LogFeederImplRandom implements LogFeeder {

    private int MAX = 100;
    private EmailFactory factory = new EmailFactory();

    Iterator <Email> iterator = new Iterator<Email>() {

        int count = 0;

        @Override
        public boolean hasNext() {
            return (count++ < MAX) ? true : false;
        }

        @Override
        public Email next() {
            return factory.getSample();
        }
    };

    @Override
    public Iterator <Email> iterator() {
        return this.iterator;
    }
}
