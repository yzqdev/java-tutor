package com.yzq.util;


enum Color {

    /**
     * 黑色
     */
    BLACK(30),
    /**
     * 红色
     */
    RED(31),
    /**
     * 绿色
     */
    GREEN(32),
    /**
     * 黄色
     */
    YELLOW(33),
    /**
     * 蓝色
     */
    BLUE(34),
    /**
     * 粉红色
     */
    PINK(35),
    /**
     * 青色
     */
    CYAN(36),
    WHITE(37),


    bgBLACK(40),
    /**
     * 红色
     */
    bgRED(41),
    /**
     * 绿色
     */
    bgGREEN(42),
    /**
     * 黄色
     */
    bgYELLOW(44),
    /**
     * 蓝色
     */
    bgBLUE(44),
    /**
     * 粉红色
     */
    bgPINK(45),
    /**
     * 青色
     */
    bgCYAN(46),
    bgWHITE(47),
    lightRed(91);
    public int code;

    Color(int code) {
        this.code = code;
    }
}

public class ColorUtil {

    public static void print(Color color, String str) {

        System.out.println("\033[" + color.code + ";2m" + str + "\033[0m");
    }

    public static void printUnderline(Color color, String str) {

        System.out.println("\033[" + color.code + ";4m" + str + "\033[0m");
    }

    /**
     * 红色
     *
     * @param str  str
     * @param args 是否下划线
     */
    public static void red(String str, String... args) {
        if (args.length > 0) {
            printUnderline(Color.RED, str);
        } else {
            print(Color.RED, str);
        }

    }

    public static void green(String str, String... args) {
        if (args.length > 0) {
            printUnderline(Color.GREEN, str);
        } else {
            print(Color.GREEN, str);
        }

    }

    public static void yellow(String str, String... args) {
        if (args.length > 0) {
            printUnderline(Color.YELLOW, str);
        } else {
            print(Color.YELLOW, str);
        }

    }

    public static void blue(String str, String... args) {
        if (args.length > 0) {
            printUnderline(Color.BLUE, str);
        } else {
            print(Color.BLUE, str);
        }

    }


    public static void cyan(String str) {
        print(Color.CYAN, str);
    }

    public static void cyan(String str, String... args) {
        if (args.length > 0) {
            printUnderline(Color.CYAN, str);
        }
    }

    public static void pink(String str, String... args) {
        if (args.length > 0) {
            printUnderline(Color.PINK, str);
        } else {
            print(Color.PINK, str);
        }

    }   public static void black(String str, String... args) {
        if (args.length > 0) {
            printUnderline(Color.BLACK, str);
        } else {
            print(Color.BLACK, str);
        }

    }



    public static void bgGreen(String str) {
        print(Color.bgGREEN, str);
    }

    public static void bgRed(String str) {
        print(Color.bgRED, str);
    }

    public static void bgYellow(String str) {
        print(Color.bgYELLOW, str);
    }

    public static void bgBlue(String str) {
        print(Color.bgBLUE, str);
    }

    public static void bgPink(String str) {
        print(Color.bgPINK, str);
    }

    public static void bgCyan(String str) {
        print(Color.CYAN, str);
    }

    public static void bgWhite(String str) {
        print(Color.bgWHITE, str);
    }

    public static void lightWhite(String str) {
        print(Color.lightRed, str);
    }


}
