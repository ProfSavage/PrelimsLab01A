//==============================================================================
//Name: Myke Louie S. De Jesus, Luke Asher V. Offemaria
//Section: BSIT12A
//Purpose: Lab Exercise
//Date: March 9, 2024
//==============================================================================
package com.mycompany.prelimslab01a;

import java.util.Scanner;

public class PrelimsLab01A {

    public String[][] phoneBook = {
        {"09052456874", "Billie Eilish"},
        {"09254879624", "Ed Sheeran"},
        {"09858457156", "Taylor Swift"},
        {"", ""},
        {"", ""}

    };

    public PrelimsLab01A() {

        Scanner input = new Scanner(System.in);
        String action = "";
        String name = "";
        String num = "";
        int flag = 0;

        showPhoneBook();

        while (true) {
            System.out.print("Enter action >>: ");
            action = input.nextLine().trim();
            if (action.equalsIgnoreCase("A")) {
                for (int i = 0; i < phoneBook.length; i++) {
                    for (int j = 0; j < phoneBook[0].length; j++) {
                        if (phoneBook[i][j].equals("")) {
                            flag = 0;
                        } else {
                            flag = 1;
                        }
                    }
                }
                if (flag == 0) {
                    System.out.println("======================================="
                            + "========");
                    System.out.println("Enter Information");
                    System.out.println("======================================="
                            + "========");

                    while (true) {
                        System.out.print("Enter Name >>: ");
                        name = input.nextLine();

                        if (name.trim().equals("")) {
                            System.out.println("Name must not be empty.");
                            continue;
                        } else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Enter number >>: ");
                        num = input.nextLine();

                        if (num.trim().equals("")) {
                            System.out.println("Number must not be empty.");
                            continue;
                        } else if (num.length() != 11) {
                            System.out.println("Number must be valid. "
                                    + "(11 digits.)");
                            continue;
                        } else {
                            break;
                        }
                    }

                    addToPhoneBook(name, num);
                    System.out.println("======================================="
                            + "========");
                    System.out.println("\t\t   UPDATED");
                    showPhoneBook();
                } else {
                    System.out.println("Phone Book is already full.");
                }
            } else if (action.equalsIgnoreCase("E")) {
                System.out.println("=========================================="
                        + "=====");
                System.out.println("Phone Book closed.");
                break;
            } else {
                System.out.println("Must choose from actions.");
            }
        }

    }

    public void showPhoneBook() {

        System.out.println("===============================================");
        System.out.println("                 PHONE BOOK                   ");
        System.out.println("===============================================");
        System.out.println("          NUMBER      |      NAME              ");
        System.out.println("===============================================");

        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook[0].length; j++) {

                if (phoneBook[i][j].equals("")) {
                    break;
                } else if (j == 0) {
                    System.out.print("[" + (i + 1) + "]");
                    System.out.print("   " + phoneBook[i][j] + "\t");
                } else {
                    System.out.print("   " + phoneBook[i][j] + "\t");
                    System.out.println("");
                }
            }
        }
        System.out.println("===============================================");
        System.out.println("ACTIONS:");
        System.out.println("[A]dd");
        System.out.println("[E]xit");

    }

    public void addToPhoneBook(String name, String number) {
        int flag = 0;

        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook[0].length; j++) {
                if (flag == 0) {
                    if (phoneBook[i][j].equals("")) {
                        if (j == 0) {
                            phoneBook[i][j] = number;
                        } else {
                            phoneBook[i][j] = name;
                            flag++;
                        }
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        PrelimsLab01A lab = new PrelimsLab01A();

    }
}
