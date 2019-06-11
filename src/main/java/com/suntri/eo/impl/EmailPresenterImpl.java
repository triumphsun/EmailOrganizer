package com.suntri.eo.impl;

import com.suntri.eo.Email;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/3
 */

public class EmailPresenterImpl implements Email.Presenter <String> {

    @Override
    public String presents(Email email) {
        return String.format("%s, %s", email.getSender(), email.getSubject());
    }
}
