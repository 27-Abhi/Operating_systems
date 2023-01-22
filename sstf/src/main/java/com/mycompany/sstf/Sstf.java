/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sstf;
import java.util.*;
import java.util.Scanner;

        /**
 *
 * @author lenovo
 */
public class Sstf {


    public static void main(String[] args) {
		int head;
		int seekTime = 0;
		//Random rand = new Random();

		System.out.println("Enter starting head location: ");
		Scanner sc = new Scanner(System.in);
		head = sc.nextInt();

		System.out.println("Enter number of disk locations: ");
		int numberOfDiskLocations = sc.nextInt();

		int[] disk_location = new int[numberOfDiskLocations];

		//System.out.println("Enter disk range: ");
		//int temp = sc.nextInt();
		
		for (int i = 0; i < numberOfDiskLocations; i++) {
			disk_location[i] = sc.nextInt();
		}

		int[] visited = new int[numberOfDiskLocations + 1];

		System.out.println("Disk Location \t Seek Time");

		for (int i = 0; i < numberOfDiskLocations; i++) {
			int min = 99999;
			int pos = 0;
			for (int j = 0; j < numberOfDiskLocations; j++) {
				if (Math.abs(disk_location[j] - head) < min) {
					if (visited[j] == 0) {
						min = Math.abs(disk_location[j] - head);
						pos = j;
					}
				}
			}
			visited[pos] = 1;
			seekTime += Math.abs(disk_location[pos] - head);
			System.out.println(disk_location[pos] + "\t\t " + seekTime);
			head = disk_location[pos];
		}

		System.out.println();
		System.out.println("Total Seek Time :" + seekTime);
		sc.close();
	}
    }
    }

