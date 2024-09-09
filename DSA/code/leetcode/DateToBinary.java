package leetcode;

import java.util.Arrays;

public class DateToBinary {
    public static String convertDateToBinary(String date) {
        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        String yearBinary = Integer.toBinaryString(year);
        String monthBinary = Integer.toBinaryString(month);
        String dayBinary = Integer.toBinaryString(day);

        return yearBinary + '-' + monthBinary + '-' + dayBinary;


    }

    public static void main(String[] args) {
        System.out.println(convertDateToBinary("2003-01-10"));
    }

}
