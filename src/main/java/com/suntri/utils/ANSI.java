package com.suntri.utils;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 * Date: 2019/6/11
 */

public class ANSI {

    public static final String BEL = "\007"; // Bell
    public static final String BS  = "\010"; // Backspace
    public static final String HT  = "\011"; // Horizontal Tab
    public static final String LF  = "\012"; // Line Feed
    public static final String CR  = "\015"; // Carriage Return
    public static final String ESC = "\033"; // Eecape
    public static final String DEL = "\177"; // Delete

    public enum SGR {

        NORMAL(0),
        BOLD(1),
        UNDERLINE(4),
        BLINK(5),
        INVISIBLE(8),
        BOLD_OFF(22),
        UNDERLINE_OFF(24),
        BLINK_OFF(25),
        INVISIBLE_OFF(28),
        BLACK(30),
        RED(31),
        GREEN(32),
        YELLOW(33),
        BLUE(34),
        MAGENTA(35),
        CYAN(36),
        WHITE(37),
        BLACK_BACKGROUND(40),
        RED_BACKGROUND(41),
        GREEN_BACKGROUND(42),
        YELLOW_BACKGROUND(43),
        BLUE_BACKGROUND(44),
        MAGENTA_BACKGROUND(45),
        CYAN_BACKGROUND(46),
        WHITE_BACKGROUND(47);

        private final int code;

        SGR(int code){
            this.code = code;
        }

        public int getCode(){
            return this.code;
        }
    }
}
