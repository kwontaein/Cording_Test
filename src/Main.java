import java.io.*;
import java.util.Scanner;


public class Main {
    static RollCakeCut subClass = new RollCakeCut();

    public static void main(String[] args) {
        System.out.println(subClass.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    }
}