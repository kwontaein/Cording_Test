import java.io.*;
import java.util.Scanner;


public class Main {
    static DeliveryBox subClass = new DeliveryBox();

    public static void main(String[] args) {
        //1, 2, 3, 2, 3
        //3, 5, 2, 6, 7, 8, 1, 10, 9
        System.out.println(subClass.solution(new int[]{2, 1, 6, 7, 5, 8, 4, 9, 3, 10}));
    }
}