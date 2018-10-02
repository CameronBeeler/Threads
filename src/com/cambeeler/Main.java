package com.cambeeler;

import static java.lang.Thread.sleep;

public class Main
{

    public static
    void main(String[] args)
    {
        System.out.println("Hello from the main thread ->" + Thread.currentThread().toString());

        Thread anotherThread = new AnotherThread();
//        anotherThread.start();
        anotherThread.run();
        System.out.println("After the anotherThread has been invoked..." + Thread.currentThread().toString());
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
                    threadTestMethod(700, 3);
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
                    threadTestMethod(50,10);
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        };

        new Thread(run1).start();
        System.out.println("Finished from run1 thread ->" + Thread.currentThread().toString());

        new Thread(run2).start();
        System.out.println("Finished from run2 thread ->" + Thread.currentThread().toString());

    }

    public static
    void threadTestMethod(int millis, int incr)
    throws Exception
    {
        if((millis<1) || (incr<1))
        {
            Exception error =  new Exception("Parameters must be positive integer values");
            throw error;
        }
        for(int i=0;i<=incr;i++)
        {
            sleep(millis);
            System.out.println("iteration# " + i + ", Thread# ->" + Thread.currentThread().toString());
        }
    }
}
