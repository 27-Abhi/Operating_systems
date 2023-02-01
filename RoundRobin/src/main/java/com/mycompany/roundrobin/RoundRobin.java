/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.roundrobin;
import java.util.*;
/**
 *
 * @author lenovo
 */
public class RoundRobin {

    public static void main(String[] args) {
        System.out.println("Enter the number of processes");
        Scanner sc=new Scanner(System.in);
        int pno= sc.nextInt();
        
         System.out.println("Enter the Quantum time");
        int qt= sc.nextInt();
        
        //initialise array
        int[] bt=new int[pno];
        int[] wt=new int[pno];
        int[] tat=new int[pno];
        int[] ct=new int[pno]; //completion time
        int[] rem_bt=new int[pno]; //remaining burst time
         //counting the number of processes completed
        int time=0; //time of the whole thing
        
        System.out.println("Enter the burst time");
        for(int i=0;i<pno;i++)
        {
              bt[i]= sc.nextInt();
              rem_bt[i]=bt[i];
        }
        int i,count=0;
        
        
   while(count!=pno){
          for(i=0,count=0;i<pno;i++)
        {
            if(rem_bt[i]==0) //if the process has completed execution
            {
                count++; //inc pno
                continue; //skip this iteration since process has already executed
            }
            
            else if(rem_bt[i]>qt) //remaining time greater than qt
            {
                time=time+qt;
                rem_bt[i]=rem_bt[i]-qt;
                
            }
            else if(rem_bt[i]<=qt) //if remaining time of the process is less than the quantum time
            {
                time=time+rem_bt[i]; //adding the remaining time to the total time
                rem_bt[i]=0; //indicates that the process has completed execution
                ct[i]=time;
                //count++; //this process ha scompleted execution
            }
            if(count==pno)
            {
                break;
            }
        
        
      }}
            //calculate tat and wt
            for(i=0;i<pno;i++)
            {
                tat[i]=ct[i]; //since all process arrive at 0
                wt[i]=tat[i]-bt[i];
            }
             System.out.println("\tpid\t\tbt\t\ttat\t\twt\t\tct\t\t");
      for(i=0;i<pno;i++)
      {
      System.out.println("\t\t"+i+"\t\t"+bt[i]+"\t\t"+tat[i]+"\t\t"+wt[i]+"\t\t"+ct[i]+"\t\t");
      }
      System.out.println("time taken:"+time);
       //System.out.println(count);
    }
}
