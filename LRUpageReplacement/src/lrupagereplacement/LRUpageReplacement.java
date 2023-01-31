package lrupagereplacement;
import java.util.*;
public class LRUpageReplacement {

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

        int hits = 0;
        int miss = 0;
        int j;
        int found;
        for (int val : page) //iterating through page references
        {
            //
            if (frame.size() == 0) //if the frame size is not  filled at all, add the page..
            {
                frame.add(val);
                miss++;
                continue;
            }
            j = 0;
            found = 0;
            while (frame.size() != j) //iterate through the frame to check if page already exists in it
            {
                if (val == frame.get(j)) {
                    found = 1; //page found 
                    break;
                }
                j++;
            }

            if (found == 1)// page found
            {
                frame.remove(j); //the first element i.e index 0 is the least recently used page.
                //hence if there is any hit, we remove the page and add the page at the end(append) 

                frame.add(val);
                hits++;
                continue;

            } else if (found == 0) {
                if (frame.size() < fno) //if the frame size is not  filled, add the page at the end
                {
                    frame.add(val);
                    miss++;
                    continue;
                } else if (frame.size() == fno) {
                    frame.remove(0); //the first element i.e index 0 is the least recently used page(TO be replaced)
                    frame.add(val);
                    miss++;
                    continue;
                }

            }

        }
        System.out.println("Hits:" + hits);
        System.out.println("Miss" + miss);

    }

}

//issue: the frame loop for searching is not iterating for all values
//solution: make another for loop dedicated to search the value and return the index or -1(incase not found) 
//OR MAke a while loop to find if the page is present in the frame and return the index
