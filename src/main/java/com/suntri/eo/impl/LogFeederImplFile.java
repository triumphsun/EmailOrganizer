package com.suntri.eo.impl;

import com.suntri.eo.Email;
import com.suntri.eo.LogFeeder;

import java.io.*;
import java.util.Iterator;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/3
 */

public class LogFeederImplFile implements LogFeeder {

    private File logFile;
    private BufferedReader br;
    private Email.Deserializer <String> parser = new LogParserImpl();
    private String nextLine = null;

    Iterator <Email> iterator = new Iterator<Email>() {

        int count = 0;

        @Override
        public boolean hasNext() {
            return nextLine != null;
        }

        @Override
        public Email next() {
            //System.out.println(String.format("#%d\t%s", count++, nextLine));
            Email email = parser.deserialize(nextLine);
            //Email email = Email.getSample();
            LogFeederImplFile.this.preFetch();
            return email;
        }
    };

    public LogFeederImplFile(InputStream is){
        this.br = new BufferedReader(new InputStreamReader(is));
        this.preFetch();
    }

    public LogFeederImplFile(File file){
        this.logFile = file;
        try {
            this.br = new BufferedReader(new FileReader(this.logFile));
            this.preFetch();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public void preFetch(){
        try{
            this.nextLine = this.br.readLine();
        } catch(IOException e){
            this.nextLine = null;
            e.printStackTrace();
            try {
                this.br.close();
            } catch(IOException e1){
                e1.printStackTrace();
            }
        }
    }

    @Override
    public Iterator <Email> iterator() {
        return this.iterator;
    }
}
