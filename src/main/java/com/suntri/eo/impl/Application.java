package com.suntri.eo.impl;

import com.suntri.eo.Analysis;
import com.suntri.eo.Email;
import com.suntri.eo.LogFeeder;
import com.suntri.eo.LogFeederImplRandom;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/2
 */

public class Application {

    private OutputStream os = System.out;
    private LogFeeder feeder;
    private Analysis analysis;

    public Application(LogFeeder feeder){
        this(feeder, System.out);
    }

    public Application(LogFeeder feeder, OutputStream os){
        this.os = os;
        this.feeder = feeder;
        this.analysis = new AnalysisImpl();
    }

    public void addEmail(Email email){
        this.analysis.addEmail(email);
    }

    public void dump(){
        this.analysis.export(this.os);
    }

    public void start(){
        Iterator <Email> itr = this.feeder.iterator();
        while(itr.hasNext()){
            this.addEmail(itr.next());
        }
    }

    public static void usage(PrintStream ps){
        ps.println("\n");
        ps.println("Usage: java -cp lib.jar com.suntri.oe.impl.Application [--file=FILE | --stdin]");
        ps.println("Options: ");
        ps.println("\t-i,  --input\t\tThe file to progress.");
        ps.println("\t-s,  --stdin\t\tRead file from standard input.");
        ps.println("\t-h,  --help\t\tPrint this message.");
        ps.println("\n");
    }

    public static void main(String [] args){
        LogFeeder feeder = null;

        for(int i=0; i<args.length; i++){
            if("--help".equals(args[i]) || "-h".equals(args[i])){
                Application.usage(System.err);
                return;
            }

            if("--stdin".equals(args[i])){
                feeder = new LogFeederImplFile(System.in);
            } else if("--input".equals(args[i]) || "-i".equals(args[i])){
                if(i == args.length-1){
                    Application.usage(System.err);
                    return;
                }
                File file = new File(args[i+1]);
                feeder = new LogFeederImplFile((file));
            }
        }

        if(feeder == null){
            feeder = new LogFeederImplRandom();
        }

        Application app = new Application(feeder);
        app.start();
        app.dump();
    }

}
