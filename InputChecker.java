import java.util.*;


     
    
    class InputChecker extends Thread
    {
        // to finish the tread
        
        private volatile boolean finishWork = false; 
        
        public void finish()
        {
            finishWork = false;
        }    
        
        public void run() 
        {
            do
            { 
                if (!finishWork)
                {
                    try 
                    {
                        Thread.sleep(10000);
                    } catch(InterruptedException e){}
                    Collections.sort(WebTestApp.inputNumbers);
                    System.out.print("I'm helping" + WebTestApp.inputNumbers.get(0));
                    WebTestApp.inputNumbers.remove(0);   
                }
            } while (true);
        }
    
    }
 