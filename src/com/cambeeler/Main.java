package com.cambeeler;

import static com.cambeeler.ThreadColor.*;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class Main
{

    public static
    void main(String[] args)
    {
        System.out.println("Hello from the main thread ->" + currentThread().toString());

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("Blue");
        anotherThread.start();
        playingWithThreads();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.setName("Cam");

        new Thread()
        {
            public void run()
            {
                try
                {
                    currentThread().setName("Purple");
                    System.out.println(ANSI_PURPLE + "This is a test of the anonymous class " + currentThread().toString());

                    myRunnableThread.join(1000);
                    System.out.println(ANSI_CYAN + "Joined myRunnable with AnotherRunnable");
                }
                catch (InterruptedException i)
                {
                    System.out.println(ANSI_PURPLE + "Interrupted MyRunnable -> " + currentThread().toString());
                    return;
                }

            }
        }.start();

        Thread anotherRunnableThread = new Thread(new MyRunnable()
        {
            @Override
            public
            void run()
            {
                System.out.println(ANSI_BLUE + "Anonymous MyRunnable -> " + currentThread().toString());
            }
        });
        myRunnableThread.start();

        anotherRunnableThread.setName("Jon");
        anotherRunnableThread.start();

        try
        {
            sleep(500);
            System.out.println(ANSI_RESET + "After the anotherThread has been invoked..." + currentThread().toString());

        }
        catch (InterruptedException i)
        {
            System.out.println("stinking exception");
        }

    }

    public static
    void playingWithThreads()
    {
        Runnable run1 = new Runnable()
        {
            @Override
            public
            void run()
            {
                try
                {
                    currentThread().setName("Red");
                    threadTestMethod(125, 3, 1);
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        };

        Runnable run2 = new Runnable()
        {
            @Override
            public
            void run()
            {
                try
                {
                    currentThread().setName("Green");
                    threadTestMethod(50,10, 2);
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        };

        new Thread(run1).start();
        System.out.println("Finished from run1 thread ->" + currentThread().toString());

        new Thread(run2).start();
        System.out.println("Finished from run2 thread ->" + currentThread().toString());

    }

    public static
    void threadTestMethod(int millis, int incr, int color)
    throws Exception
    {
        if((millis<1) || (incr<1) || (color<0))
        {
            Exception error =  new Exception("Parameters must be positive integer values");
            throw error;
        }
        for(int i=0;i<=incr;i++)
        {
            sleep(millis);
            if(color == 1)
            {
                System.out.println(ANSI_RED + "iteration# " + i + ", Thread# ->" + currentThread().toString());

            }
            else
            {
                System.out.println(ANSI_GREEN + "iteration# " + i + ", Thread# ->" + currentThread().toString());
            }
        }
    }
}
