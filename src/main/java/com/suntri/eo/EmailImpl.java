package com.suntri.eo;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/6
 */

public class EmailImpl implements Email {

    private String sender;
    private String receivers = null;
    private String date;
    private String subject;
    private String content = null;

    public EmailImpl(String sender, String subject){
        this.sender = sender;
        this.subject = subject;
    }

    @Override
    public String getSender() {
        return this.sender;
    }

    @Override
    public String getReceivers() {
        return this.receivers;
    }

    @Override
    public String dateDate() {
        return this.date;
    }

    @Override
    public String getSubject() {
        return this.subject;
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
