import java.io.*;
import java.util.Scanner;


public class Main {
    static ParkingFee subClass = new ParkingFee();

    public static void main(String[] args) {
        //1, 2, 3, 2, 3
        //3, 5, 2, 6, 7, 8, 1, 10, 9
        System.out.println(subClass.solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"}));
    }
}