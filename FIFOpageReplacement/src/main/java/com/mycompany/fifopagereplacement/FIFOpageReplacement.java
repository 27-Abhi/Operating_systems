package com.mycompany.fifopagereplacement;

import java.util.*;

public class FIFOpageReplacement {

    public static void main(String[] args) {
        ArrayList<Integer> frame = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the frame Size:");
        int fno = sc.nextInt();

        System.out.println("enter the number of pages:");
        int pno = sc.nextInt();
        int[] page = new int[pno];

        System.out.println("enter page reference");
        for (int i = 0; i < pno; i++) {
            page[i] = sc.nextInt();
        }
        int found;
        int i;
        int hit = 0;
        int miss = 0;
        for (int val : page) {
            if (frame.size() == 0) //adding the first frame
            {
                frame.add(val);
                miss++;
                continue;
            }

            found = 0;
            i = 0;
            while (frame.size() != i) {
                if (frame.get(i) == val) //iterating through frames until page found
                { //if page found--> found=1 || if Page not found --> found=0
                    found = 1;
                    break;
                }
                i++;
            }

            if (found == 1) //page found
            {
                hit++;
                continue;
            } else if (found == 0) //page not found
            {
                if (frame.size() < fno) //if all frames not filled yet
                {
                    frame.add(val); //apppending the value to the frame 
                    miss++;
                    continue;
                } else { //if frame is full
                    frame.remove(0); //remove the first element 
                    frame.add(val); //appending the page reference 
                    miss++;
                    continue;
                }
            }
        }
        System.out.println("Hits:" + hit);
        System.out.println("Miss" + miss);
    }
}
