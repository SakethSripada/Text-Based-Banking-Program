import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        int register;
        int login;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Would you like to register an account or sign in?");
        String input = scanner.nextLine();

        if (input.equals("signin")) {
            Scanner signIn= new Scanner(System.in);
            System.out.println("Enter your ID number to log in");
            String idNum = signIn.nextLine();
            Scanner signIn2= new Scanner(System.in);
            System.out.println("Enter your name to log in");
            String cuName = signIn.nextLine();

            try {
                File myObj = new File("javaproject.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if (data.equals(idNum)){
                        account x = new account(cuName, idNum);
                        x.showMenu();
                    }
                    else {
                        System.out.println("The ID number you entered is incorrect. Please try again.");
                        System.exit(0);
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                System.exit(0);
            }




        } else if (input.equals("register")) {
            ArrayList<String> userInfStrings = new ArrayList<String>();
            ArrayList<Integer> userInfInts = new ArrayList<Integer>();
            Scanner scanner2 = new Scanner(System.in);
                System.out.println("Please enter your first name: ");
                userInfStrings.add(scanner2.next());
                System.out.println("Please enter your last name: ");
                userInfStrings.add(scanner2.next());
                System.out.println("Please enter your phone number: ");
                userInfInts.add(scanner2.nextInt());
                System.out.println("Please enter your age: ");
                userInfInts.add(scanner2.nextInt());

                System.out.println(userInfStrings);
                System.out.println(userInfInts);


                    System.out.println("Type 'yes' or 'no' to verify if the above information is correct");
                    Scanner scanner3 = new Scanner(System.in);
                    String confirmation = scanner.nextLine();

                    if (confirmation.equals("yes")) {


                        File file = new File("javaproject.txt");
                        FileWriter fr = new FileWriter(file, true);
                        BufferedWriter br = new BufferedWriter(fr);
                        br.newLine();
                        br.write("A0001");

                        br.close();
                        fr.close();
                        account A0001 = new account(userInfStrings.get(0) + " " + userInfStrings.get(1), "A0001");
                        A0001.showMenu();

                    } else if (confirmation.equals("no")) {
                        System.out.println("Please reenter your information below");
                        System.out.println("=====================================");
                        Scanner scanner4 = new Scanner(System.in);
                        System.out.println("Please enter your first name: ");
                        String re1 = scanner.nextLine();
                        userInfStrings.set(0, re1);
                        System.out.println("Please enter your last name: ");
                        String re2 = scanner.nextLine();
                        userInfStrings.set(1, re2);
                        System.out.println("Please enter your phone number (no dashes): ");
                        int re3 = scanner.nextInt();
                        userInfInts.set(0, re3);
                        System.out.println("Please enter your age: ");
                        int re4 = scanner.nextInt();
                        userInfInts.set(1, re4);

                        System.out.println(userInfStrings);
                        System.out.println(userInfInts);
                    }

                        System.out.println("Is the above information now correct?");
                        Scanner scanner5 = new Scanner(System.in);
                        String confirmation2 = scanner5.nextLine();
                            if (confirmation2.equals("yes")) {
                            System.out.println("Thank you for signing up, your ID is A0001");
                            System.out.println("==========================================");
                                account A0001 = new account(userInfStrings.get(0) + " " + userInfStrings.get(1), "A0001");
                                A0001.showMenu();


                            }

                        }




            }


        }





