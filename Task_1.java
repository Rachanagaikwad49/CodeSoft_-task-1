 // generate a number within a specified range , such as 1to 100.
 //prompt the user to enter their guess for the generated number.
 //compare the users guess number with generated number and provide feedback on whether the guess is correct, too high ,or too low
 //repeat step 2 and 3 until the user guesses the correct number
 //limit the number of attempts the user has to guess the number
 //add option for multiple rounds, allowing the user to play again
 //display the users score , which can be based on the number of attempts taken or rounds won

import java.util.Scanner;
import java.util.Random;
public class Task_1 {

    public static void main(String[] args) {
        Game myGame=new Game();
        boolean playGame=true;
        int userNumber;

        while(playGame==true) {
            userNumber=myGame.takeUserInput();
            boolean myBool=myGame.isCorrectNumber(userNumber);
            if(myBool==true) {
                System.out.print("Guessed in ");
                myGame.getNumberOfGuesses();
                System.out.print(" Guesses");
                System.out.println("");
                playGame=false;
                break;
            }
            else {
                playGame=true;
            }
        }
    }
}

class Game {
    private int computerNumber;
    private int numberOfGuesses=0;
    Scanner sc=new Scanner(System.in);

    Random rn=new Random();
    
    public Game() {
        computerNumber=rn.nextInt(101);
    }
    public int takeUserInput() {
        System.out.println("Guess the number (1-100) : ");
        int userNumber=sc.nextInt();
        return userNumber;
    }
    public boolean isCorrectNumber(int myNum) {
        int flag=0;
        if(myNum<=100 && myNum>=0) {
            setNumberOfGuesses();
            if(myNum==computerNumber) {
                System.out.println("Congrajulations You guessed it right. The number is "+myNum);
                flag=1;
                sc.close();
            }
            else if(myNum<computerNumber) {
                System.out.println("Your number is less than the actual number");
            }
            else if(myNum>computerNumber) {
                System.out.println("Your number is greater than the actual number");
            }
        }
        else {
            System.out.println("Please enter in range 0-100");
        }
        if(flag==1) {
            return true;
        }
        else {
            return false;
        }
    }
    public void setNumberOfGuesses() {
        numberOfGuesses++;
    }
    public void getNumberOfGuesses() {
        System.out.print(numberOfGuesses);
    }
}

