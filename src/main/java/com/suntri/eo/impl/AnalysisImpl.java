package com.suntri.eo.impl;

import com.suntri.eo.Analysis;
import com.suntri.eo.Email;
import com.suntri.eo.EmailComparator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/2
 */

public class AnalysisImpl implements Analysis {

    List <Email> list = new LinkedList <> ();
    Email.Presenter <String> presenter = new EmailPresenterImpl();
    Comparator <Email> comparator = new EmailComparator();

    @Override
    public void addEmail(Email email) {
        this.list.add(email);
    }

    @Override
    public void export(OutputStream os) {
        Collections.sort(this.list, this.comparator);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))){
            for(Email email: this.list){
                writer.write(presenter.presents(email));
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
