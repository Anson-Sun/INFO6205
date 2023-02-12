package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class HWQUPC_Solution {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Input Number n: ");
        int n = input.nextInt();
        while(n > 0) {
            UF_HWQUPC u = new UF_HWQUPC(n, true);
            Random random = new Random();

            int m = 0;
            while (u.components() > 1){
                int i = random.nextInt(n);
                int j = random.nextInt(n);
                if(u.connected(i, j))
                    continue;

                u.union(i, j);
                m++;
            }
            System.out.println("n = " + n + ", m =  " + m);
            n--;
        }
    }
}
