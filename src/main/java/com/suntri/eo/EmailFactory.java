package com.suntri.eo;

import java.util.Random;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/6
 */

public class EmailFactory {

    private static Email[] sample = {
            new EmailImpl("user@gmail.com", null),
            new EmailImpl("dummy@mail.google.com", null),
            new EmailImpl("hello@apple.com", null)
    };

    public static Email getSample(){
        Random random = new Random();
        int index = random.nextInt(sample.length);
        return sample[index];
    }
}
