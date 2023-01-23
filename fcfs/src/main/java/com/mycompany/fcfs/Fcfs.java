/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fcfs;

import java.util.*;
import java.io.*;

public class Fcfs{
 
    public static void Cal(int at[],int bt[],int n){
    
        int[] wt=new int[n];
        
        wt[0]=0;
        int wtavg=0;
        int tatavg=0;
        for(int i=1;i<n;i++)
        {
            //cal waiting time
            wt[i]=at[i-1]+wt[i-1]+bt[i-1]-at[i];
            wtavg+=wt[i];
            
        }
        
        //cal tat
        int[] tat=new int[n];

        for(int i=0;i<n;i++)
        {
            tat[i]=wt[i]+bt[i];
            tatavg+=tat[i];
        }
        
         System.out.println("Pno\tat\tbt\ttat\twt\t");
       System.out.print("1"+ "\t\t" +  at[0]+ "\t\t" + bt[0]+ "\t\t" +  wt[0] +"\t\t"+tat[0]+"\n");

       for(int i=1;i<n;i++)
       {
             System.out.print(i+1 + "\t\t" +  at[i+1]+ "\t\t" + bt[i+1]+ "\t\t" +  wt[i+1] +"\t\t"+tat[i+1]+"\n");
       
       }
    }
    
    public static void main(String []args)
    {
        int n;
        
       
        System.out.println("Enter number of processes");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
         int[] at=new int[n];
        int[] bt=new int[n];
        
        System.out.println("Enter Arrval time");
       for(int i=0;i<n;i++)
       {
           at[i]=sc.nextInt();
       }
        
        System.out.println("Enter Burst time time");
       for(int i=0;i<n;i++)
       {
           bt[i]=sc.nextInt();
       }
       Fcfs.Cal(at,bt,n);
       
    }
}
