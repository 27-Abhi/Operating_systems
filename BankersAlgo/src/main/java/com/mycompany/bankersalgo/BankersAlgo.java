/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bankersalgo;

import java.util.*;

/**
 *
 * @author lenovo
 */
public class BankersAlgo {
    int np,nr;
     int[][] alloc ;
        int[][] max;
        // int[][] avail= new int[nr][np]; //available matrix - 
        int[] av_in ;
        boolean[] flag ;
        int[] f1;
        int[] seq ;
        int[][] need;

    public  boolean check(int i)
    {
       
         for(int k=0;k<nr;k++)
         {
          if(need[i][k]>av_in[k]) //cannot allocate
              return false;
          
                     
         }
        return true;
            
    }
    public void bank() {
        //taking input 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of process");
        int np = sc.nextInt(); //np-number of processes

        System.out.println("Enter the number of resources");
        int nr = sc.nextInt(); //np-number of processes
        
        
        alloc = new int[nr][np]; //allocation matrix
         max = new int[nr][np]; //max matrix
        // int[][] avail= new int[nr][np]; //available matrix - 
        av_in = new int[nr]; //to store the initial available
       flag = new boolean[np]; //flag to indicate whether the process is executed or not
        f1 = new int[np]; ///another flag
        seq = new int[np]; ///safe sequence
        need = new int[nr][np];

        //need matrix- calculated by max[][]-alloc[][]
        /*
        structure: pno | R1   R2   R3         nr->
                    1  | 0    1    1        NP   
                    2  | 1    0    2        |
                    3  | 2    2    1        V 
         */
        //input for matrix
        System.out.println("Enter for allocation matrix");
        for (int i = 0; i < np; i++) {
            for (int j = 0; j < nr; j++) {
                alloc[i][j] = sc.nextInt(); //np-number of processes
            }

        }

        System.out.println("Enter for max matrix");
        for (int i = 0; i < np; i++) {
            for (int j = 0; j < nr; j++) {
                max[i][j] = sc.nextInt(); //np-number of processes
            }

        }

        System.out.println("Enter the Available matrix");
        {
            for (int i = 0; i < nr; i++) {
                av_in[i] = sc.nextInt();
            }

        }

        //calculating need matirx
        for (int i = 0; i < np; i++) {
            for (int j = 0; j < nr; j++) {
                need[i][j] = max[i][j] - alloc[i][j]; //calculates need
            }
        }
        for (int i = 0; i < np; i++) {
            flag[i] = false; //initialising flag with 0 ie not completed ...1-completed
            f1[i] = 0;
        }
        
        int pc=0;
        while(pc<np)
        {
            for(int i=0;i<np;i++)
            {
                if(flag[i]==false && check(i)==true)
                {
                    for(int j=0;j<nr;j++)
                    {
                        av_in[j]+=alloc[i][j];
                        
                    }
                    seq[pc]=i;
                    pc++;
                    flag[i]=true;
                }
            }
            
            if(pc==np)
            {
                System.out.println("Safe seq exists ");
                for(int j=0;j<np;j++)
                    {
                   System.out.print(seq[j]+" ");
                    }
                break;
            }
             else
        System.out.println("All proceess cant be allocated safely");

        }
            
            
        }
    public static void main(String[] args)
    {
        new BankersAlgo().bank();
    
    }

        
         
         
         
         
         
         
         
         
         
         
         
         
    }        
         
         
         
         
         
         
         /*
        int count=0;
        int pc=0; //program counter
        while(count!=np)
        {
            for(int i=0;i<np;i++)
            {
                for(int j=0;j<nr;j++)
                {
                    if((need[i][j]>av_in[i]) && flag[i]==0)
                    {
                        f1[i]=1;
                        break;
                    }
                }
                if(f1[i]==0 && flag[i]==0)
                {
                    seq[count]=i;
                    count++;
                    for(int j=0;j<nr;j++)
                    {
                    av_in[j]+=alloc[i][j];
                    }
                    flag[i]=1;//done
                }
            }
            
            pc++;
            if(pc>1000)
            {
                System.out.println("Cannot allocate");
                break;
            }
        }
         
         for(int j=0;j<np;j++)
                    {
                   System.out.println(seq[j]+" ");
                    }
        
        
        
        
            
            
         
         
         
         
         
         
         
         
         
         
         
        //try to allocate
int count=0; // numbe rof times the while loop iterates
        int k=0;  //no of processes completed
        while(k<np){ //untill all process allocate
        for(int i=0;i<np;i++)
        {
            if(flag[i]==0 || f1[i]==-1) //checking if the process has not executed
                {
                    for(int j=0;j<nr;j++)
                    {
                       if(need[i][j]>av_in[j]) //ie cannot allocate 
                       {
                           f1[i]=-1;
                       }
                    
                    }
                    if(f1[i]!=-1) //can be allocated
                    { 
                        //update avaliable resource
                        for(int j=0;j<nr;j++)
                        {
                            av_in[j]=av_in[j]+alloc[i][j]; // releaseing the resources   
                        }
                        flag[i]=1; 
                        seq[k]=i;
                        k++;
                        System.out.println("Allocated process: "+i);
                        
                    
                    }
                    
                }
        }
        if(k==np)
        {
            System.out.println("All process allocated safely");
            break;
        }
        if(k<np)
        {count++;
        
           if(count>10)
           {
            System.out.println("Cannot be allocated safely");
            break;
        }
        }
        }
        
        */
