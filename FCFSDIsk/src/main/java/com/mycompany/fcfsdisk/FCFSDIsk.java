/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fcfsdisk;
import java.util.*;
/**
 *
 * @author lenovo
 */
public class FCFSDIsk {

    public static void main(String[] args) {
        System.out.println("Enter the nummber of requests");
        Scanner sc = new Scanner(System.in);
        int rno=sc.nextInt();
        
        int[] req= new int[rno];
        System.out.println("Enter the requests");
        for(int i=0;i<rno;i++)
        {
        req[i]=sc.nextInt();
        }
        
        System.out.println("Enter the current head");
        int head=sc.nextInt();
        
        int seek=0;
        
        for(int i=0;i<rno;i++)
        {
            seek=seek+Math.abs(head-req[i]);
            head=req[i];
        }
        
        System.out.println("Total distance covered by the head: "+seek);
        
        
    }
}
