package diningphilo;
import java.util.concurrent.*;
import java.util.*;
public class DiningPhilo 
{ 
    public static int no=5;
    public static chopsticks[] chopstick = new chopsticks[no];
    public static philosopher[] philosophers = new philosopher[no];
    
    
    public static class chopsticks
    {
        public static Semaphore mutex = new Semaphore(1);
        
        public void grab()
        {
            mutex.acquire();
        }
        public void release()
        {
            mutex.release();
        }
        
        public static boolean isFree()
        {
            return mutex.availablePermits()>0;
        }
    }
    
    public static class philosopher extends Thread
    {
        int pno;
        public chopsticks cleft;
        public chopsticks cright;
        philosopher(int no,chopsticks l,chopsticks r)
        {
            pno=no;
            cleft=l;
            cright=r;
        }
        
        public void run()
        {
            cleft.grab();
            System.out.println("Philosopher "+pno+"Grabs left chopstick");
            cright.grab();
            System.out.println("Philosopher "+pno+"Grabs right chopstick");
            eat();
            cleft.release();
            System.out.println("Philosopher "+pno+"releases left chopstick");
            cright.release();
            System.out.println("Philosopher "+pno+"releases right chopstick");
        }
        
        public void eat()
        {
            Thread.sleep(1000);
            System.out.println("Philosopher "+pno+"Eats");
        }
        
        
    
    
    }
    
    public static void main(String[] args)
    {
        for(int i=0;i<no;i++)
        {
            chopstick[i]= new chopsticks();
        }
        
        for(int i=0;i<no;i++)
        {
            philosophers[i]= new philosopher(i,chopstick[i],chopstick[((i+1)%5)]);
            philosophers[i].start();
        }
       
        while(true)
        {
            Thread.sleep(1000);
            boolean deadlock=true;
            for(chopsticks cs: chopstick)
            {if(cs.isFree())
            {
                deadlock=false;
                break;
            }
            }
       
        if(deadlock)
        {
            Thread.sleep(2000);
            System.out.println("Everyone eats");
            break;
        }
        
    }
     System.out.println("end of program");
    
    
    
}
}

    /*
//defining the number of philosophers  
static int philosopher = 5;  
//initializing an array of philosophers with the number of philosophers  
static Philosopher philosophers[] = new Philosopher[philosopher];  
//initializing an array of chosticks with the number of philosophers  
static Chopstick chopsticks[] = new Chopstick[philosopher];  
static class Chopstick   
{  
//creating a constructor of the Semaphore class that accepts the number permits  
public Semaphore mutex = new Semaphore(1);  
//the method grabs the chopstick  
void grab()   
{  
try   
{  
//acquires a permit from the semaphore  
mutex.acquire();  
}  
catch (Exception e)   
{  
e.printStackTrace(System.out);  
}  
}  
//release the chopstick  
void release()   
{  
//releases an acquire a permit and increases the number of available permits by one  
mutex.release();  
}  
//checks if the chopstick is free or not  
boolean isFree()   
{  
//the method returns the current number of permits available in the semaphore  
//returns true if available permits is greater than 0, else returns false  
return mutex.availablePermits() > 0;  
}  
}  //end of Chopstick class  
static class Philosopher extends Thread   
{  
public int number;  
//represents left chopstick  
public Chopstick leftchopstick;  
//represents right chopstick  
public Chopstick rightchopstick;  
//creating a constructor of the Philosopher class  
Philosopher(int num, Chopstick left, Chopstick right)   
{  
number = num;  
leftchopstick = left;  
rightchopstick = right;  
}  
public void run()  
{  
while (true)   
{  
//philosopher grabs the chopsticks if both are free  
leftchopstick.grab();  
System.out.println("Philosopher " + (number+1) + " grabs left chopstick.");  
rightchopstick.grab();  
System.out.println("Philosopher " + (number+1) + " grabs right chopstick.");  
//hunger philosopher starts eating   
eat();  
//releases left and right chopsticks when philosopher is not hunger  
leftchopstick.release();  
System.out.println("Philosopher " + (number+1) + " releases left chopstick.");  
rightchopstick.release();  
System.out.println("Philosopher " + (number+1) + " releases right chopstick.");  
}  //end of while loop  
} //end of run() method  
//the method invokes after grabbing both the chopsticks (left and right)  
void eat()   
{  
try   
{  
//determines the pseudorandom number between 0 to 1000 that represents the sleep time in milli seconds  
int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);  
System.out.println("Philosopher " + (number+1) + " eats for " + sleepTime +"ms"); //sleeps the thread for a specified time  
Thread.sleep(sleepTime);  
}  
catch (Exception e)   
{  
e.printStackTrace(System.out);  
}  
}// end of eat() method  
}  
public static void main(String args[])   
{  
//loop iterates over chopsticks  
for (int i = 0; i < philosopher; i++)   
{  
chopsticks[i] = new Chopstick();  
} //end of for loop  
//loop iterates over philosopher  
for (int i = 0; i < philosopher; i++)   
{  
philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % philosopher]);  
//begins the execution of the thread  
philosophers[i].start();  
} //end of for loop  
while (true)   
{  

//thread sleep for 1 sec or 1000ms  
Thread.sleep(2000);  
//check for deadlock condition  
boolean deadlock = true;  
//for each loop iterates over chopsticks  
for (Chopstick cs : chopsticks)   
{  
//checks if chopstick is free or not   
if (cs.isFree())   
{  
deadlock = false;  
break;  
} //end of if  
} //end of for loop  
//deadlock occurs if sleep time is 1000ms it means each philosopher is eating  
if (deadlock)   
{  
Thread.sleep(2000);  
System.out.println("Everyone Eats");  
break;  
} //end of if  
}  
  
System.out.println("Exit The Program!");  
System.exit(0);  
}

}
*/