import java.util.*;

public class WebTestApp 
{
   static InputChecker secondThread; 
   public static List<Integer> inputNumbers  = Collections.synchronizedList(new ArrayList<Integer>());
   
   public static String returnNumber(String input)
   {
       if (input.equals("one")) {return "1";}
       if (input.equals("two") || input.equals("twen")) {return "2";}
       if (input.equals("three") || input.equals("thir")) {return "3";}
       if (input.equals("four")) {return "4";}
       if (input.equals("five") || input.equals("fif")) {return "5";}
       if (input.equals("six")) {return "6";}
       if (input.equals("seven")) {return "7";}
       if (input.equals("eight") || input.equals("eigh")) {return "8";}
       if (input.equals("nine")) {return "9";}
       if (input.equals("ten")) {return "10";}
       if (input.equals("eleven")) {return "11";}
       if (input.equals("twelve")) {return "12";}
       if (input.equals("zero")) {return "0";}
       return "error";
   }    
   
   public static Integer converterFunc(String input)
   {
       
       String[] listOfWords = input.split(" ");
       String number = new String("");
       for (int i=0; i<listOfWords.length; i++)
       {
           if (listOfWords[i].contains("ty"))
           {
               number += returnNumber(listOfWords[i].substring(0, listOfWords[i].lastIndexOf("t")));
               if (listOfWords.length == 1)
               {
                   number += "0";
               }
           } else
               if (listOfWords[i].contains("teen"))
           {
               number += "1";
               number += returnNumber(listOfWords[i].substring(0, listOfWords[i].lastIndexOf("t")));
           } else
               if (listOfWords.length == 1) 
           {
               number += returnNumber(listOfWords[i]);
           }
       
       }
       System.out.println("number = "+ number);
       return Integer.parseInt(number); 
     
   }    
   public static Integer tempConverterFunc(String number) 
   {
        return Integer.parseInt(number); 
   } 
   
    public static void main(String args[]) 
    {
        
        Scanner input = new Scanner(System.in);
        secondThread = new InputChecker();
        secondThread.start();
        String answer = "0";
        while (answer.equals("exit") == false) 
        {
        
        answer = input.nextLine();
        inputNumbers.add(converterFunc(answer));
        System.out.println("meanwhile: "+ answer + (answer != "exit"));
        
        }
        secondThread.finish();
    
    
    }




}