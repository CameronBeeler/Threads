package com.cambeeler;

public
class AnotherThread extends Thread
{
    @Override
    public void run()
    {
        try
        {
            sleep(100);
            System.out.println("really basic thread run method " + Thread.currentThread().toString());
        }
        catch(InterruptedException i)
        {
            i.printStackTrace();
        }
    }
}
