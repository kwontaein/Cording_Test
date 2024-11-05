import java.io.*;
import java.util.Scanner;


public class Main {
    static ParkingFee subClass = new ParkingFee();

    public static void main(String[] args) {
        //1, 2, 3, 2, 3
        //3, 5, 2, 6, 7, 8, 1, 10, 9
        System.out.println(subClass.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }
}