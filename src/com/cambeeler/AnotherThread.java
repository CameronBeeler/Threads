package com.cambeeler;

import static com.cambeeler.ThreadColor.ANSI_BLUE;

public
class AnotherThread extends Thread
{
    @Override
    public void run()
    {
        try
        {
            sleep(100);
            System.out.println(ANSI_BLUE + "really basic thread run method " + currentThread().toString());
        }
        catch(InterruptedException i)
        {
            i.printStackTrace();
        }
//        Thread myRunnableThread = new Thread(new MyRunnable());
//        myRunnableThread.setName("FromAnother");
//        myRunnableThread.start();
    }
}
