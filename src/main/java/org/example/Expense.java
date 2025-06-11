package org.example;

//Individual expenses
public class Expense {
    private double amount;
    private String category;
    private String date;
    private String note;

    public Expense(double amount, String category, String date, String note){
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.note = note;
    }
    public String toString(){
        return "$" + amount + " | " + category + " | " + date + " | " + note;
    }
    public double getAmount(){
        return amount;
    }
    public String getCategory(){
        return category;
    }
    public String getDate() {
        return date;

    }
}
