
package ui;

import java.util.Scanner;

import model.Control;

public class Main {
    private Scanner sc;
    private Control manager;

    public Main() {
        this.sc = new Scanner(System.in);
        this.manager = new Control();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public void menu() {
        boolean option = false;
        System.out.println("\n" +
                "Health Provider");
        while (option == false) {
            System.out.println(
                    "1) Register the person\n " +
                            "2) Show people\n " +
                            "3) Make an entry\n " +
                            "4) Make an exit\n " +
                            "5) Undo entry or exit\n " +
                            "6) CLOSE PROGRAM");
            int options = this.sc.nextInt();
            if (options != 1 && options != 2 && options != 3 && options != 4 && options != 5 && options != 6) {
                System.out.println("Error, please try option");
            } else {
                option = true;
            }
            switch (options) {
                case 1:
                    register();
                    break;
                case 2:
                    this.show();
                    break;
                case 3:
                    this.enter();
                    break;
                case 4:
                    this.out();
                    break;
                case 5:
                    this.edit();
                case 6:
                    break;
            }
        }
    }

    public void register() {
        boolean ch = false;
        System.out.print("Enter name of the person:\n ");
        String name = sc.nextLine();


        System.out.println("Enter the patient ID: ");
        String id = sc.nextLine();

        while (ch == false) {

            System.out.println("Enter the gender:\n" + "" +
                    "1) Male\n" +
                    "2) Female");
            int gender = Integer.parseInt(this.sc.nextLine());
            if (gender != 1 && gender != 2) {
                System.out.println("Error,please try");
            } else {
                ch = true;
            }


            System.out.println("Enter the age:");
            int age = Integer.parseInt(this.sc.nextLine());

            ch = false;

            System.out.println("Require Priority?\n" +
                    "1) Yes\n" +
                    "2)No");
            int priority = Integer.parseInt(this.sc.nextLine());
            if (priority != 1 && priority != 2) {
                System.out.println("Error, please try");
            } else {
                ch = true;
            }

            ch = false;

            if (priority == 1) {

                System.out.println("Enter the level of priority");
                System.out.print("1,2,3,4,5");
                int level;
                for (level = Integer.parseInt(this.sc.nextLine()); level < 1 || level > 5; level = Integer.parseInt(this.sc.nextLine())) {
                    System.out.println("Enter option valid");
                    System.out.println("The 1 to 5 how urgent is your attention");
                }
                this.manager.add(name, id, gender, age, true, level);
            } else {
                int level = 0;
                this.manager.add(name, id, gender, age, false, level);
            }
        }

    }


    public void show() {
        System.out.println(" ");
    }

    public void enter() {
        System.out.println("Enter the name: ");
        String name = this.sc.nextLine();
        if (!this.manager.patientVerifier(name)) {
            System.out.println("Registered");
        } else {
            System.out.println("Write the unity: ");
            System.out.println("1) Hematology");
            System.out.println("2) General purpose");
            int option = Integer.parseInt(this.sc.nextLine());
            this.manager.depositLine(name, option);
        }

    }

    public void out() {
        System.out.println("Write the unity: ");
        System.out.println("1) Hematology");
        System.out.println("2) General purpose");
        int option = Integer.parseInt(this.sc.nextLine());
        System.out.println(this.manager.removeLine(option));
    }

    public void edit() {
        System.out.println();
    }
}