
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int menuChoice = 0;
        while(menuChoice != 9)
        {
            System.out.println("____MENU____\n" +
                    "1. Assignment 1\n" +
                    "2. Assignment 2\n" +
                    "3. Assignment 3\n" +
                    "4. Assignment 4\n" +
                    "5. Assignment 5\n" +
                    "6. Assignment 6\n" +
                    "7. Assignment 7\n" +
                    "8. Assignment 8\n" +
                    "9. Exit Program\n" +
                    "Please choose a program to run: ");
            menuChoice = input.nextInt();
            switch (menuChoice) {
                case 1:
                    AssignmentMenthods.Assignment01();
                    break;
                case 2:
                    AssignmentMenthods.Assignment02();
                    break;
                case 3:
                    AssignmentMenthods.Assignment03();
                    break;
                case 4:
                    AssignmentMenthods.Assignment04();
                    break;
                case 5:
                    AssignmentMenthods.Assignment05();
                    break;
                case 6:
                    AssignmentMenthods.Assignment06();
                    break;
                case 7:
                    AssignmentMenthods.Assignment07();
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("Closing Program.");
                    break;
                default:
                    System.out.println("Please try again.");
                    break;
            }
        }
        input.close();
    }
}
