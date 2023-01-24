/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.preemptivesjf;
import java.util.*;
/**
 *
 * @author lenovo
 */
public class PreemptiveSJF {

    public static void main(String[] args) {
        System.out.println("Enter the number of processes");
        Scanner sc= new Scanner(System.in);
       int pno=sc.nextInt();
       
       int[] at=new int[pno];
       int[] bt=new int[pno];
       int[] rt=new int[pno]; //remaining time
       int[] wt=new int[pno];
        int[] bt1=new int[pno];
       int[] ct=new int[pno];
       int[] flag=new int[pno];
       int[] tat=new int[pno];
       int[] pid=new int[pno];
       
       System.out.println("Enter the arrival time");
       for(int i=0;i<pno;i++)
       {
           at[i]=sc.nextInt();
       }
       
       System.out.println("Enter the burst time");
       for(int i=0;i<pno;i++)
       {
           bt[i]=sc.nextInt();
       }
        System.out.println("Please wait!");
       //initialising flag
        for(int i=0;i<pno;i++)
       {
          flag[i]=0;
       }
        
        //copying burst time in remaining time
       
       for(int i=0;i<pno;i++)
       {
          rt[i]=bt[i];
          bt1[i]=bt[i]; //for priniting purpose only
         
       }
       int st=0;
       int count=0;
       int smallest=0;
      //max number
       int end;//end time
       for(st=0;count!=pno;st++)
       {
            int min=99999;
           
        for(int i=0; i<pno; i++)
        {
            if(at[i]<=st && bt[i]<min && bt[i]>0 ) //chosing the smallest burst time
                smallest=i; //choosing the smallest burst time of all
                min=bt[i]; 
        }
        bt[smallest]--; //dec burst time by 1...we decrement step by step i.e 1 by 1 to check if there is any other process at that particular time having burst time less
       

        if(bt[smallest]==0) // iterate through loop untill bt=0 i.e process execution is completed
        {
            pid[smallest]++;
            count++;
            end=st+1;
            tat[smallest] = end - at[smallest];
            ct[smallest] = end;
            wt[smallest] =tat[smallest] - bt1[smallest];
            
        }
       
       }
        System.out.println("\tpid\t\tat\t\tbt\t\ttat\t\twt\t\tct\t\t");
      for(int i=0;i<pno;i++)
      {
      System.out.println("\t\t"+pid[i]+"\t\t"+at[i]+"\t\t"+bt1[i]+"\t\t"+tat[i]+"\t\t"+wt[i]+"\t\t"+ct[i]+"\t\t");
      }
     
       
       
        
    }
}
