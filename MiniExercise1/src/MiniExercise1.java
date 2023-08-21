import java.util.Random;
import java.util.Scanner;

public class MiniExercise1 {
    // main method
    public static void main(String[] args) {

        Task1();

         Task2();
    }

    // Task 1
    static void Task1() {

        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements would you like to create? ");
        int howMany = sc.nextInt();
        Object[] arr = new Object[howMany];

        for(int i=0; i<howMany; i++) {
            System.out.println("Please enter the values");
            int value = sc.nextInt();

            if (value == 0) {
                boolean boolFalse = false;
                arr[i] = boolFalse;
            } else if (value == 1) {
                boolean boolTrue = true;
                arr[i] = boolTrue;
            } else if (value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE) {
                arr[i] = (byte) value;
            } else if (value >= Short.MIN_VALUE && value <= Short.MAX_VALUE) {
                arr[i] = (short) value;
            } else if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
                arr[i] = (int) value;  // It doesn't need to covert the type into Integer but I added this to make sure
            } else {
                System.out.println("You entered invalid number.");
            }
        }
        // print out the values and types
        for(int i =0; i<arr.length; i++) {
            System.out.println("[Value]: " + arr[i] + ", [Type]: " +  arr[i].getClass().getName());
        }
    } // Task 1 end


    // Task 2
    static void Task2() {

        int[][] arr = new int[10][10];

        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                arr[i][j] = (i+1)*(j+1);
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\nHow many questions do you want to solve?");
        int num = sc.nextInt();

        int correctCnt = 0;

        for(int i=0; i<num; i++) {
            // crate random
            Random rand = new Random();

            // random number is from 1 to 10
            int randNum1 = rand.nextInt(1, 11);
            int randNum2 = rand.nextInt(1, 11);
            System.out.println("\n>> What is "+ randNum1 + " x " + randNum2 + " ?");

            // store the user's answer
            int userAnswer = sc.nextInt();

            // Print out the
            if(randNum1*randNum2 == userAnswer) {
                System.out.println("Congrats! It's correct!\n");
                correctCnt ++;
            }else {
                System.out.println("Incorrect..\n");
            }

            // Print out multidimensional index number
            for(int r=0; r<10; r++){
                for(int c=0; c<10; c++) {
                    if(arr[r][c] == randNum1*randNum2) {
                        System.out.println( "The answer "+ randNum1*randNum2 + " is ["+ r + "," + c + "] in the Multiplication Table");
                    }
                }
            }
        }
        int percentage = Math.round((correctCnt*100 / num));
        System.out.printf("\n** You answered %d out of %d questions. That's a percentage of %d%%.", correctCnt, num, percentage);
    }
}  // class end

