
import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;


public class AssignmentMenthods {
    static void Assignment01() {
        Scanner userInput = new Scanner(System.in); //instantiate the ability to take in user input
        int[] numInput = new int[3];
        System.out.println("Please input 3 numbers: ");
        for (int i = 0; i < 3; i++) //loop to add input to the userInput array
        {
            while (userInput.hasNext())//checking to see if it is a valid input
            {
                if (userInput.hasNextInt()) {
                    numInput[i] = userInput.nextInt();
                    break;
                } else {
                    System.out.println("Please enter a valid input.");
                    userInput.next();
                }
            }
        }
//take the numbers and display the results
        System.out.println("The three numbers are: " + numInput[0] + ", " + numInput[1] + ", and " + numInput[2]);
        System.out.println("The sum of the numbers is: " + SUM(numInput));
        System.out.println("The average of the numbers is: " + AVG(numInput));
        // userInput.close(); //closing the scanner to not leak memory

    }

    static int SUM(int[] num) //function that adds all the numbers in the array together
    {
        int sum = 0;
        for (int j : num) {
            sum += j;
        }
        return sum;
    }

    static int AVG(int[] num)//function that uses the Sum function then divided by array length
    {
        int avg;
        avg = SUM(num) / num.length;
        return avg;
    }

    static void Assignment02() {

        // instantiation of variables needed
        int startPop = 312032486;
        double birth = (((60.0 / 7) * 60.0) * 24.0) * 365;//One birth every 7 seconds
        double death = (((60.0 / 13) * 60.0) * 24.0) * 365;//One death every 13 seconds
        double immi = (((60.0 / 45) * 60.0) * 24.0) * 365;//One new immigrant every 45 seconds
        int[] yearArray = new int[6];

        //equation for population of each year
        for (int i = 0; i < 6; i++) {
            yearArray[i] = (int) (((birth * i) - (death * i) + (immi * i)) + startPop);
        }

        //output to console
        System.out.println("Starting Population: " + yearArray[0]);
        System.out.println("Population Year One: " + yearArray[1]);
        System.out.println("Population Year Two: " + yearArray[2]);
        System.out.println("Population Year Three: " + yearArray[3]);
        System.out.println("Population Year Four: " + yearArray[4]);
        System.out.println("Population Year Five: " + yearArray[5]);
    }

    static void Assignment03() {
        //Variable Initialization
        float monthlyPayment;
        float totalPayment;
        float principle = 0.00f; //loan amount
        int periods = 0; //years
        Scanner userInput = new Scanner(System.in);

        //ask for user input on loan
        System.out.print("Please enter a loan amount, example 13000.65: ");
        while (userInput.hasNext()) //checking to see if input is a number
        {
            if (userInput.hasNextFloat()) {
                principle = userInput.nextFloat();
                break;
            } else {
                System.out.print("Please enter a valid input.\n");
                System.out.print("Please enter a loan amount, example 13000.65: ");
                userInput.next();
            }
        }
        //ask for user input on years
        System.out.print("Please enter the number of years as an integer, example 4: ");
        while (userInput.hasNext()) //another input check
        {
            if (userInput.hasNextInt()) {
                periods = userInput.nextInt();
                break;
            } else {
                System.out.print("Please enter a valid input.\n");
                System.out.print("Please enter the number of years as an integer, example 4: ");
                userInput.next();
            }
        }

        //output to show inputs
        System.out.printf("Your loan amount is: " + principle);
        System.out.printf("\nYour years are: " + periods);

        //output values header
        System.out.printf("\n%-22s%-22s%-22s", "Interest Rate", "Monthly Payment", "Total Payment");

        //loop to increment the rate for the monthly payment equation
        for (float rate = 5.000f; rate < 8.125f; ) {
            float deciRate = (rate / 100.0000f) / 12.0f;//rate in decimal form then /12 to get per month

            // M = (P * r) / (1 - Math.pow(1.0 + r, n * -12.0))
            monthlyPayment = (float) ((principle * deciRate) / (1 - Math.pow(1.0 + deciRate, periods * -12)));
            totalPayment = monthlyPayment * 12 * periods; //monthly converted to 1 year payment * number of years

            //print the values
            System.out.printf("\n%.3f" + "%-21c" + "%-22.2f%-22.2f", rate, '%', monthlyPayment, totalPayment);
            rate += 0.125f;// 1/8 increment
        }
        //userInput.close();
    }

    static void Assignment04() {
        //100 Lockers
        boolean[] lockers = new boolean[101]; //101 due to wanting to start at 1

        //All lockers start closed
        for (int i = 1; i < lockers.length; i++) {
            lockers[i] = false;
        }
        LockerChange(lockers);
        for (int i = 1; i < lockers.length; i++) {
            if (lockers[i]) {
                //print all open lockers
                System.out.println("Locker " + i + " is open.");
            }
        }
    }

    static void LockerChange(boolean[] locker) {
        for (int i = 1; i < locker.length; i++)//current student starting at student 1
        {
            for (int j = i; j < locker.length; )//go through each locker starting at locker 1
            {
                if (!locker[j]) {
                    locker[j] = true;
                } else {
                    locker[j] = false;
                }
                j = j + i; // moving x lockers down where x = student number
            }
        }
    }


    static void Assignment05() {
        String numberBorn = "";
        //grab user input
        Scanner userInput = new Scanner(System.in);

        String year;
        while (true) {
            System.out.print("Enter year between 2001 and 2010 inclusively: ");
            year = userInput.next();
            int intYear = Integer.parseInt(year);
            if (intYear >= 2001 && intYear <= 2010)
                break;
            else
                System.out.println("Please try again.");
        }

        String gender;
        while (true) {
            System.out.print("Enter gender: ");
            gender = userInput.next();
            if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))
                break;
            else
                System.out.println("Please try again.");
        }

        System.out.print("Enter name: ");
        String name = userInput.next() + " ";
        //userInput.close();
        //get the file
        File myFile = new File("Babynamesranking" + year + ".txt");
        int rank = 1;
        try {
            Scanner read = new Scanner(myFile); //read the file
            while (read.hasNext()) {
                String line = read.nextLine();//current line of the file
                String[] temp = line.split("\t");//current line data ignoring the tab

                if (gender.equalsIgnoreCase("M") && temp[1].equalsIgnoreCase(name))//baby boy
                {
                    numberBorn = temp[2];//number of births associated
                    break;
                } else if (gender.equalsIgnoreCase("F") && temp[3].equalsIgnoreCase(name))//baby girl
                {
                    numberBorn = temp[4];
                    break;
                } else if (rank >= 1000)//if rank goes past the last line of the file
                {
                    rank = 0;
                    break;
                }
                rank++;
            }
            read.close();
        } catch (FileNotFoundException excep) {
            excep.printStackTrace();
        }
        if (rank == 0)//if the name was not found
            System.out.println("The name " + name + "is not ranked in year " + year);
        else//display info if the name was found
            System.out.println(name + "is ranked #" + rank + " in year " + year + " with " + numberBorn + " " + gender + " babies born.");
    }

    static void Assignment06() {
        int id;
        int choice;
        double balance;
        boolean check = true;
        Account[] acc = new Account[10];
        for (int i = 0; i < acc.length; i++)//populate accounts
        {
            acc[i] = new Account(i, 100.00);
        }
        Scanner userInput = new Scanner(System.in);
        id = validate(userInput, check); //validate account number
        while (check) {
            System.out.println("\nMain menu\n");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");
            System.out.print("\nEnter a choice: ");
            choice = userInput.nextInt();
            switch (choice) {
                case 1:
                    balance = acc[id].getBalance();
                    System.out.printf("\nYour current balance is %.2f.\n", balance);
                    break;
                case 2:
                    System.out.print("\nEnter an amount to withdraw: ");
                    double withdrawAmount = userInput.nextDouble();
                    acc[id].withdraw(withdrawAmount);
                    balance = acc[id].getBalance();// grabs balance to show user new balance
                    System.out.printf("\nYour new balance is %.2f.\n", balance);
                    break;
                case 3:
                    System.out.print("\nEnter an amount to deposit: ");
                    double depositAmount = userInput.nextDouble();
                    acc[id].deposite(depositAmount);
                    balance = acc[id].getBalance();
                    System.out.printf("\nYour new balance is %.2f.\n", balance);
                    break;
                case 4:
                    // exit the program
                    System.out.println("\nThank you. Goodbye!");
                    check = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
                    break;
            }
        }
    }
    static int validate(Scanner userInput, boolean check) {
        int newid;
        while (check) {
            System.out.println("Please enter an Account Number between 1 and 10: ");
            newid = userInput.nextInt();
            if (newid < 0 || newid >= 10) {
                System.out.println("Invalid Account Number. Please try again.\n");
            } else {
                return newid;//return valid id
            }
        }
        return 0;
    }

    static void Assignment07()
    {
        System.out.println("Creating a maple tree, tulip, and rose...");
        MapleTree mapleTree = new MapleTree();
        Tulip tulip = new Tulip();
        Rose rose = new Rose(); //created Rose object to use methods
        System.out.println("Entering a loop to simulate 3 years");
        for (int i = 0; i < 3; i++) {
            mapleTree.doSpring();
            tulip.doSpring();
            rose.doSpring();
            mapleTree.doSummer();
            tulip.doSummer();
            rose.doSummer();
            mapleTree.doFall();
            tulip.doFall();
            rose.doFall();
            mapleTree.doWinter();
            tulip.doWinter();
            rose.doWinter();
        }
    }

    static void Assignment08()
    {
        int choice;
        int double_age = 99; // age is set so user can do choice 3 regardless
        boolean check = true;
        Scanner userInput = new Scanner(System.in);
        while(check)//loop menu until exit is chosen
        {
            System.out.println("Main menu\n");
            System.out.println("1: Repeat name.");
            System.out.println("2: Double your age.");
            System.out.println("3: Are you a teenager?");
            System.out.println("4: Triangle.");
            System.out.println("5: Exit");
            System.out.print("\n#3 will use the doubled age from #2. \nIf you did not do #2 the default age is 99.");
            System.out.print("\n\nEnter a choice: ");
            choice = userInput.nextInt();
            switch (choice) //calls the specific method attached to the menu option
            {
                case 1:
                    printName(userInput);
                    break;
                case 2:
                    double_age = printAge( double_age, userInput, check);
                    break;
                case 3:
                    isTeenager(double_age);
                    break;
                case 4:
                    try {
                        triangleDisplay(userInput, check);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    // exit the program
                    System.out.println("\nThank you. Goodbye!");
                    check = false;
                    break;
                default:
                    //if the user chooses a number that is not a choice it will flag as invalid
                    System.out.println("\nInvalid choice. Please try again.");
                    break;
            }
        }

    }
    static void printName(Scanner userInput)
    {
        String name;
        System.out.println("Please enter your name: ");
        name = userInput.next();//grab the string that is the username, no validation attached
        for(int i = 0; i < 20; i++)
        {
            System.out.println(name);
        }
    }
    static int printAge(int double_age, Scanner userInput, boolean check)
    {
        int age;
        System.out.println("Please enter your age: ");
        age = validateAge(userInput,check); //grabs initial age from the user
        System.out.println("Your current age is " + age);
        double_age = age * 2;
        System.out.println("Your age doubled is " + double_age);
        return double_age; //returns the doubled age to be used in option 3
    }
    static void isTeenager(int age)
    {
        System.out.println("You are currently " + age + " years old.");
        if(age != 99)//if the age is not 99 or the default age
            System.out.println("Since you are not 99 years old you are a teenager.");
        else//all other ages
            System.out.println("Since you are 99 years old, you are NOT a teenager.");
    }
    static void triangleDisplay(Scanner userInput, boolean check) throws FileNotFoundException
    {
        int num = validateTriangle(userInput,check); //asks and validates input
        FileWriter writer;//file writer object creation
        try {
            writer = new FileWriter("triangle.txt");//create and select file to write to
            for(int i = 0; i < num; i++)//each row of the triangle
            {
                for(int j = 0; j <= i; j++)//each X of the triangle
                {
                    System.out.print("X");//output to console
                    writer.write("X");//write to file
                }
                System.out.println();//next line
                writer.write("\n");//next line

            }
            writer.close();//close the file
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    static int validateAge(Scanner userInput, boolean check)
    {
        int age;
        while(check)//while the age is out of bounds ask the user for the age
        {
            System.out.println("Please enter a age between 0 and 112: ");
            age = userInput.nextInt();
            if(age <= 0 || age >= 112)
                System.out.println("Invalid Age. Please try again.\n");
            else
                return age;//returns validated age
        }
        return 0;
    }
    static int validateTriangle(Scanner userInput, boolean check)
    {
        int tri;
        while(check)//while the number is out of bounds ask the user for an number
        {
            System.out.println("Please enter a number between 3 and 50: ");
            tri = userInput.nextInt();
            if(tri < 3 || tri > 50)
                System.out.println("Invalid Number. Please try again.\n");
            else
                return tri;//returns validated number
        }
        return 0;
    }

}





