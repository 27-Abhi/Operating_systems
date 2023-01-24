/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nonpremprivesjf;
import java.util.*;
/**
 *
 * @author lenovo
 */
public class NonprempriveSJF {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
       System.out.println("Enter the number of processes");
       int pno=sc.nextInt();
       
       int[] pid=new int[pno];
       int[] at=new int[pno];
       int[] bt=new int[pno];
       int[] wt=new int[pno];
       int[] tat=new int[pno];
       int[] ct=new int[pno];
      int[] flag=new int[pno];
      int st=0;
     
      
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
      for(int i=0;i<pno;i++)
      {
      flag[i]=0;
      }
      int tot=0;
      while(true)
      { 
          int c=pno;
           int min=9999; //initialise inside the loop so that the value of min is 99999 whenever there is a new iteraiton   
           if(tot==pno)
         {
             break;
         }
           for(int i=0;i<pno;i++)
          {if(flag[i]==0 && at[i]<=st && bt[i]<min) //why at[i]<st?
          {
              min=bt[i];
              c=i;
          }
          }
       
          if(c==pno)
          {
          st++;
          }
          
          
          
          else{
              ct[c]=bt[c]+st;
              st+=bt[c];
              tat[c]=ct[c]-at[c];
              wt[c]=tat[c]-bt[c];
              flag[c]=1;
              pid[tot]=c++;
              tot++;
              
            }
      
      }
      System.out.println("\tpid\t\tat\t\tbt\t\ttat\t\twt\t\tct\t\t");
      for(int i=0;i<pno;i++)
      {
      System.out.println("\t\t"+pid[i]+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+tat[i]+"\t\t"+wt[i]+"\t\t"+ct[i]+"\t\t");
      }
      
      
      
    }
}
