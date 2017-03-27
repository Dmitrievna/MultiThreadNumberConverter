import java.util.*;

public class WebTestApp {
    
    // Display a message, prececed by the name of the current thread
    
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }
    
    private static class MessageLoop implements Runnable {
        public void run() {
            String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat iby too"            
            };
            try {
                for (int i = 0; i < importantInfo.length; i++ ) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);                
                }
            
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");            
            }        
        }    
    }

    
    
    class InputChecker implements Runnable {
        public void run() {
        
            System.out.print("I'm helping");
        
        }
    
    }
    
    // support function for a quick replace a text number with an actuall number
    static String quickNumber (String input) { 
        if (input.equals("one")||input.equals("teen") ) { return "1"; }
        if (input.equals("two") || input.equals("twen") ) { return "2"; }
        if (input.equals("three") || input.equals("thir")) { return "3"; }
        if (input.equals("four") || input.equals("for")) { return "4";}
        if (input.equals("five") || input.equals("fif")) { return "5"; }
        if (input.equals("six")) { return "6"; }
        if (input.equals("seven")) { return "7"; }
        if (input.equals("eight") || input.equals("eigh")) { return "8"; }
        if (input.equals("nine")) { return "9"; }
        if (input.equals("ten")) { return "01"; }
        if (input.equals("eleven")) { return "11"; }
        if (input.equals("twelve")) { return "21"; }  
        if (input.equals("ty")) { return ""; }  
        return "error";
    
    }
    
  
    // logics of replacing text to numbers
    static Integer wordsToNumbers (String input) {
        
        String[] words = input.split(" ");
        String number = "";
        ArrayList <String> tens = new ArrayList<String>();
        tens.add("ty");
        tens.add("teen");
        
        for (int i = words.length - 1; i >= 0; i--) {
            if (!(words[i].equals("thousand") || words[i].equals("hundred"))) {
                
                if (words[i].contains(tens.get(0)) || words[i].contains(tens.get(1))) {
                for (int j = 0; j < tens.size(); j++) {
                    if (words[i].contains(tens.get(j))) {
                        
                    number += quickNumber(words[i].substring(0,words[i].lastIndexOf("t"))); 
                    number += quickNumber(tens.get(j));
                     }
                   }
                }
                else {
                
                number += quickNumber(words[i]);
                }
            
            
            }
        }
        StringBuffer result = new StringBuffer(number).reverse();
        number = result.toString();
        
        
        // add extra zeros
        if (words[words.length - 1].equals("thousand")) {number += "000";}
        if (words[words.length - 1].equals("hundred")) {number += "00";}
        if (words[words.length - 1].contains("ty")) {number += "0";}
        if (words.length >= 2 && words[0].contains("teen") && (!(words[1].contains("ty")) ) ) {
            number = number.substring(0,2) + "0" + number.substring(2, number.length());       
        }
        
        if (Arrays.asList(words).contains("thousand") && !Arrays.asList(words).contains("hundred")) {
            number = number.substring(0,1) + "0" + number.substring(1, number.length());
        }
        if ((words.length >= 2 && Arrays.asList(words).contains("hundred"))) { // add more
                number = number.substring(0,1) + "0" + number.substring(1, number.length());
        }
            
            
        
        System.out.println(number);
        return 42;
           
    
    }
   
    public static void main(String args[]) {
        
        Scanner input = new Scanner(System.in);
        List<Integer> inputNumbers = Collections.synchronizedList(new ArrayList<Integer>());
        String answer = " ";
        while (answer.equals("exit") == false) {
        
        answer = input.nextLine();
        inputNumbers.add(wordsToNumbers(answer));
        System.out.println("meanwhile: "+ answer + (answer != "exit"));
        } 
        
        for(int i=0; i<inputNumbers.size(); i++){
            System.out.print(inputNumbers.get(i) + ",");
        }
        
    
    
    
    
    }
        
       /* throws InterruptedException {
        
        // Delay, in miliseconds before
        // We interrupt MessageLoop
        // thread (default one hour)
        long patience = 1000 * 60;
            
        // if command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument should've been an integer.");
                System.exit(1);
            }
        }
        
        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();
        
        threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exists
        while (t.isAlive()) {
             threadMessage("Still waiting...");
             // Wait maximum of 1 second
             // for MessageLoop thread
             // to finish
             t.join(1000);
             if ((System.currentTimeMillis() - startTime) > patience && t.isAlive()) {
                 threadMessage("Tired of waiting");
                 t.interrupt();
                 // Shouldn't be long now
                 // -- wait indefinitely
                 t.join();   
             }
        }
    threadMessage("Finally");
    }
*/





}