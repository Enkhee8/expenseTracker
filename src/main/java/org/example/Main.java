package org.example;
//        A console-based app where you can:
//        Add a new expense (amount, category, date, note)
//        View all expenses
//        View total spending
//        Filter expenses by category or date
//        Delete an expense
//        Exit the program

public class Main {
    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        expenseTracker.menu();
    }
}