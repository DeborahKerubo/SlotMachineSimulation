// This program creates a Slot Machine game
import java.util.Scanner; // Needed for the Scanner class
import java.util.Random; // Needed for the Random Class
import java.io.*;      // Needed to throw the IO Exception
public class SlotMachineSimulation
{
   public static void main(String[] args) throws IOException
   {
   
      double money;   // To hold the user's amount of money for the bet.
      char repeat;   // To hold 'y' or 'n'
      String input;  // To hold the user's input
      double totalBets=0; // To hold the total amount of money entered by user
      double totalWinnings=0; // To hold the tolat amount of money won
      double netGain, netLoss; // To hold the loss or gain 
      int num1,num2,num3; // To hold the random word selected by the random number
      
      do
      {
      // Get the user's bet money amount
         money= getMoney(); // calling the method to get the money entred by the user
         num1= getNumber(); 
         num2= getNumber();
         num3= getNumber(); // Calling the method three times to display three different words
         totalBets+=money; //Total amount used for betting by user
      
        // If statements for the display results if  words match
         if((num1!=num2)&&(num1!=num3) &&(num2!=num3))
         {
            System.out.printf("Better luck next time ! You won $%,.2f " ,( money*0)); // if no words match
            totalWinnings+=(money*0);
         }
         else if (((num1==num2)&&(num1!=num3)) ||((num1==num3) &&(num1!=num2))||((num2==num3)&&(num2!=num1)))
         {
            System.out.printf( "Congratulations! You won $%,.2f ", (money*2));// if two words match
            totalWinnings+=(money*2);
         }
         else  if((num1==num2)&&(num1==num3)&& (num1==5))
         {
         // if three words match and they are sevens
            System.out.printf("Congratulations !You won $%,.2f " , (money*5));
            totalWinnings+=(money*5);
           
         }
         else // if three words match
         {
            System.out.printf("Congratulations ! You won $%,.2f " ,( money*3));
            totalWinnings+=(money*3);
         }
                                        
                //Create the Scanner object
         Scanner keyboard = new Scanner(System.in);
           
                 // Does the user want to average another set?
         System.out.println(); // print a blank line 
         System.out.println("Would you like to play another round?");
         System.out.print("Enter Y for yes or  N for no: ");
         input = keyboard.nextLine(); // Read  a line.
         repeat= input.charAt(0); // Get the first character
      
      } 
                    while (repeat == 'Y'|| repeat == 'y');
         
      System.out.printf("Total Bets :$%,.2f\n",totalBets);
      System.out.printf("Total Winnings :$%,.2f\n",totalWinnings);
          
      if(totalWinnings-totalBets<0)
      {
         netLoss=(totalWinnings - totalBets);
         System.out.printf("That is a Net Loss of $%,.2f\n",(netLoss*-1));//  Get rid of the negative sign infront of the net loss
      }
      
      else if(totalWinnings -totalBets >0)
      {
         netGain=(totalWinnings-totalBets);
         System.out.printf("That is a Net Gain of $%,.2f\n",netGain);
            
            
         double record; // Record of highest gain
         File file = new File("GRecord.txt");
                              
         if (!file.exists())// file does not exist
                
         {
             // Open  new file
            PrintWriter outputFile = new PrintWriter("GRecord.txt");
            // Write data to it
            outputFile.println(netGain);
           // Close the file
            outputFile.close();
         }
         else // file exists
         {
                             
           // Opening file to read data from it
            File myFile = new File ("GRecord.txt");
            Scanner inputFile= new Scanner (myFile);
            record = inputFile.nextDouble();
                                       // Display
            System.out.println("********RECORD SETTING WIN*********");
            System.out.printf("The previous record gain was $%,.2f\n",record);
                     
                     
            // Close file
            inputFile.close();
         
            if(netGain>record)
            {
                     
               // Appending data to the GameRecord file
            
               FileWriter fwriter = new FileWriter ("GRecord.txt",true);
               PrintWriter outputFile = new PrintWriter(fwriter);
               outputFile.println(netGain);
               // Close the file
               outputFile.close();
            }
         }
           
      }
      else // netgain==totalbets
         System.out.println("You broke even!");
     
   } // closing main method
   
   // Executing the getNumber Method
   public static int getNumber()
   {
        
      // Create the Random Class object
      Random randomNumbers = new Random();
      int  randomNumber;
      // Get the random number
      randomNumber = randomNumbers.nextInt(5) +1;
      
     // Display randomly selected words
      if(randomNumber==0) 
         System.out.print("Cherries");
      if(randomNumber==1) 
         System.out.print("Oranges");
      if(randomNumber==2) 
         System.out.print("Grapes");
      if (randomNumber==3) 
         System.out.print("Lemons");
      if (randomNumber==4)
         System.out.print("Bars");
      if (randomNumber==5) 
         System.out.print("Sevens");
      System.out.println(); // Prints a blank line
   
      // Return the value 
      return randomNumber;
   }
     
   // Executing the getMoney Method value returning method
      
   public static double getMoney()
   {
      // Create the scanner object
      Scanner keyboard = new Scanner(System.in);
     
      double betMoney;  //To hold the amount of money
      System.out.println("Step Right Up and Try Your Luck at Mong'are's Amazing Slot Machine!");
      System.out.print("What is the amount of your bet in this round? $");
      betMoney = keyboard.nextDouble();
            
      // Validate the input
      while(betMoney<=0)
      {
         System.out.print("Enter a positive value.Try again!:");
         betMoney = keyboard.nextDouble();
      }
      
      // Return the value to money
      return betMoney;
   }  
}   
             
    
