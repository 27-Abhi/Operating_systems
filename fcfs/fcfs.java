/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.*;
/**
 *
 * @author lenovo ff
 */
public class fcfs{
    

// Function to Calculate waiting time
// and average waiting time
        public static void CalculateWaitingTime(int at[],int bt[], int N)
        {

            // Declare the array for waiting
            // time
            int []wt = new int[N];

            // Waiting time for first process
            // is 0
            wt[0] = 0;

            // Print waiting time process 1
            System.out.print("P.No.\tArrival Time\t"
                    + "Burst Time\tWaiting Time\n");
            System.out.print("1"
                    + "\t\t" +  at[0]+ "\t\t"
                    + bt[0]+ "\t\t" +  wt[0] +"\n");

            // Calculating waiting time for
            // each process from the given
            // formula
            for (int i = 1; i < 5; i++) {
                wt[i] = (at[i - 1] + bt[i - 1] + wt[i - 1]) - at[i];

                // Print the waiting time for
                // each process
                System.out.print(i + 1+ "\t\t" +  at[i]
                        + "\t\t" +  bt[i]+ "\t\t"
                        + wt[i] +"\n");
            }

            // Declare variable to calculate
            // average
            float average;
            float sum = 0;

            // Loop to calculate sum of all
            // waiting time
            for (int i = 0; i < 5; i++) {
                sum = sum + wt[i];
            }

            // Find average waiting time
            // by dividing it by no. of process
            average = sum / 5;

            // Print Average Waiting Time
            System.out.print("Average waiting time = "
                    + average);
        }

// Driver code
        public static void main(String[] args)
        {
            // Number of process
            int N = 5;

            // Array for Arrival time
            int at[] = { 0, 1, 2, 3, 4 };

            // Array for Burst Time
            int bt[] = { 4, 3, 1, 2, 5 };

            // Function call to find
            // waiting time
            CalculateWaitingTime(at, bt, N);
        }
    }

}
