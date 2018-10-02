package com.cambeeler;

import static com.cambeeler.ThreadColor.ANSI_CYAN;
import static com.cambeeler.ThreadColor.ANSI_RED;
import static java.lang.Thread.sleep;

public
class MyRunnable implements Runnable
{
    @Override
    public
    void run()
    {
        try
        {
            sleep(3000);
            System.out.println(ANSI_CYAN + "MyRunnable Object -> " + Thread.currentThread().toString());
        }
        catch(InterruptedException i)
        {
            System.out.println("The thread was interrupted");
            System.out.println(ANSI_RED + "Interrupted-> " + Thread.currentThread().toString());

        }

    }
}
