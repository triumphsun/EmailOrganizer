package com.suntri.eo;

import java.io.OutputStream;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/2
 */

public interface Analysis {
    public void addEmail(Email email);
    public void export(OutputStream os);
}
