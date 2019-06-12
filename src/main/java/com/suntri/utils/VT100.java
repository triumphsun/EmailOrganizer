package com.suntri.utils;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/11
 */

public class VT100 {

    public static final String ESCAPE = ANSI.ESC;
    public static final String CSI = "[";

    public static String textFormat(ANSI.SGR ... sgrs){
        StringBuilder sb = new StringBuilder();
        sb.append(ESCAPE).append(CSI);
        for(int i=0; i<sgrs.length; i++){
            sb.append(sgrs[i].getCode());
            if(i!=sgrs.length-1)
                sb.append(";");
        }
        sb.append("m");
        return sb.toString();
    }

    public static String cursorUp(int rows){
        return ESCAPE + CSI + rows + "A";
    }

    public static String cursorDown(int rows){
        return ESCAPE + CSI + rows + "B";
    }

    public static String cursorForward(int cols){
        return ESCAPE + CSI + cols + "C";
    }

    public static String cursorBackwaord(int cols){
        return ESCAPE + CSI + cols + "D";
    }

    public static String cursorNextLine(int rows){
        return ESCAPE + CSI + rows + "E";
    }

    public static String cursorPreviousLine(int rows){
        return ESCAPE + CSI + rows + "F";
    }

    public static String cursorToRow(int row){
        return ESCAPE + CSI + row + "G";
    }

    public static String cursorPosition(int col, int row){
        return ESCAPE + CSI + row + ";" + col + "H";
    }

    public static String eraseDisplay(){
        return ESCAPE + CSI + "2J";
    }

    public static String eraseLineFromCursorToLineEng(){
        return ESCAPE + CSI + "0K";
    }

    public static String eraseLineFromLineBeginToCursor(){
        return ESCAPE + CSI + "1K";
    }

    public static String eraseLine(){
        return ESCAPE + CSI + "2K";
    }

    public static void main(String [] args){
        String colorDefault = VT100.textFormat(ANSI.SGR.NORMAL);
        String colorImportant = VT100.textFormat(ANSI.SGR.BOLD, ANSI.SGR.BLUE, ANSI.SGR.BLINK);
        String colorNotice = VT100.textFormat(ANSI.SGR.NORMAL, ANSI.SGR.RED);
        System.out.print(VT100.eraseDisplay());
        System.out.print(VT100.cursorPosition(1, 1));
        System.out.println(colorImportant + "Hello" + colorDefault + " World");
        System.out.print(VT100.cursorPosition(1, 10));
        System.out.println(colorNotice + "Hello" + colorDefault + " World");
    }
}
