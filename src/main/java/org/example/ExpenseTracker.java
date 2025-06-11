package org.example;

import java.util.ArrayList;
import java.util.Scanner;

// manages list of expenses and user menu
public class ExpenseTracker {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Expense> expenses = new ArrayList<>();

    public void menu() {
        while (true) {
            System.out.println("---Expense Tracker System----");
            System.out.println("1. Add expenses");
            System.out.println("2. View All expenses");
            System.out.println("3. Calculate total expenses");
            System.out.println("4. Filter by category");
            System.out.println("5. Filter by date");
            System.out.println("6. Delete an expense");
            System.out.println("7. Exit");

            System.out.println("Choose an option (1-6): ");

            int choice = scanner.nextInt();
            if (choice == 1) {
                addExpenses();
            } else if (choice == 2) {
                viewAllExpsenses();
            } else if (choice == 3) {
                calculateTotal();
            } else if (choice == 4) {
                filterByCategory();
            } else if (choice == 5) {
                filterByDate();
            } else if (choice == 6) {
                deleteAnExpense();

            } else if (choice == 7) {
                exit();
                break;
            } else {
                System.out.println("Invalid option! Try again");
            }

        }
    }

    public void addExpenses() {
        System.out.println("Enter amount");
        double amount = scanner.nextDouble();
        scanner.nextLine(); //

        System.out.println("Category");
        String category = scanner.nextLine();

        System.out.println("Date");
        String date = scanner.nextLine();

        System.out.println("Note");
        String note = scanner.nextLine();

        Expense expense = new Expense(amount, category, date, note);
        expenses.add(expense);
        System.out.println("Expense added: " + expense);
    }

    public void viewAllExpsenses() {
        if (expenses.isEmpty()) {
            System.out.println("There is nothing to see!");
        }
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public void exit() {
        System.out.println("Good bye!");

    }

    // Calculate total amount of money for spend
    public void calculateTotal() {
        double totalExpense = 0;
        for (Expense e : expenses) {
            totalExpense += e.getAmount();
        }
        System.out.println("Total amount: $" + totalExpense);
    }

    // Filter by category
    public void filterByCategory() {
        System.out.println("Enter category to filter:  ");
        scanner.nextLine();
        String inputCategory = scanner.nextLine();
        boolean found = false;

        for (Expense exp : expenses) {
            if (exp.getCategory().equalsIgnoreCase(inputCategory)) {
                System.out.println(exp);
            }
        }
        if (!found) {
            System.out.println("No expenses found in that category");
        }
    }

    public void filterByDate() {
        System.out.println("Enter the date!");
        String date = scanner.nextLine();

        for (Expense e : expenses) {
            e.getDate().equalsIgnoreCase(date);
            System.out.println(e);
        }
        if (date.isEmpty()) {
            System.out.println("No transaction on this day: " + date);
        }
    }

    public void deleteAnExpense() {
        if (expenses.isEmpty()) {
            System.out.println("There is no expense");
            return;
        }
        System.out.println("Expenses");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". " + expenses.get(i));
        }
        System.out.println("Please enter the number of your expenses: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 1 || number > expenses.size()) {
            System.out.println("Invalid number!!");
        }
        Expense removed = expenses.remove(number - 1);
        System.out.println("Deleted expense: " + removed);
    }

}
