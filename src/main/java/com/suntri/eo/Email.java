package com.suntri.eo;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/2
 */

public interface Email {

    public static interface Presenter <T> {
        public T presents(Email email);
    }

    public static interface Deserializer <T> {
        public Email deserialize(T object) throws IllegalArgumentException;
    }

    public String getSender();
    public String getReceivers();
    public String dateDate();
    public String getSubject();
    public String getContent();
}
