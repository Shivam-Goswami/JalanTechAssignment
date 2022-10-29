import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeHousing {
    String coffee;
    String addOn;
    int bill;
    ArrayList<String> billList = new ArrayList<>();

    CoffeeHousing() {
        bill = 0;
        System.out.println("Welcome to Coffee Housing");
        System.out.println("List of Coffee Available:\nEspresso\nCappuccino\nLatte");
        System.out.println("List of Add-ons Available:\nMilk\nCream\nLatte");
    }

    public void setCoffee(String choice) {
        Scanner in = new Scanner(System.in);
        switch (choice.toLowerCase()) {
            case "espresso":
                this.coffee = "Espresso";
                break;
            case "cappuccino":
                this.coffee = "Cappuccino";
                break;
            case "latte":
                this.coffee = "Latte";
                break;
            default:
                System.out.println("wrong choice entered, Please enter correct choice: ");
                String newChoice = in.next();
                setCoffee(newChoice);
        }
        in.close();
    }

    public String getCoffee() {
        return this.coffee;
    }

    public void setAddOn(String choice) {
        Scanner sc = new Scanner(System.in);
        switch (choice.toLowerCase()) {
            case "milk":
                this.addOn = "Milk";
                break;
            case "cream":
                this.addOn = "Cream";
                break;
            case "latte":
                this.addOn = "Latte";
                break;
            default:
                System.out.println("wrong choice entered, Please enter correct choice: ");
                String newChoice = sc.next();
                setAddOn(newChoice);
        }
        sc.close();
    }

    public String getAddOn() {
        return this.addOn;
    }

    public void setBillList() {
        String coffee = getCoffee();
        String addOn = getAddOn();
        int bill = 0;
        if (coffee.equalsIgnoreCase("espresso")) {
            if (addOn.equalsIgnoreCase("milk"))
                bill = 60;
            else if (addOn.equalsIgnoreCase("cream"))
                bill = 75;
            else
                bill = 100;
        } else if (coffee.equalsIgnoreCase("capucciono")) {
            if (addOn.equalsIgnoreCase("milk"))
                bill = 80;
            else if (addOn.equalsIgnoreCase("cream"))
                bill = 90;
            else
                bill = 125;
        } else {
            if (addOn.equalsIgnoreCase("milk"))
                bill = 100;
            else if (addOn.equalsIgnoreCase("cream"))
                bill = 125;
            else
                bill = 150;
        }
        String bl = coffee + " with " + addOn + " : " + bill;
        this.bill += bill;
        this.billList.add(bl);
    }

    public void displayBill() {
        System.out.println("Here's your list of order: ");
        for (int i = 0; i < this.billList.size(); i++) {
            System.out.println((i + 1) + ". " + this.billList.get(i));
        }
        System.out.println("Grand Total : " + this.bill);

    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        CoffeeHousing ch = new CoffeeHousing();
        char c;
        do {
            System.out.println("Enter the Coffee of Your Choice");
            String coffeeChoice = scan.next();
            ch.setCoffee(coffeeChoice);
            System.out.println("Coffee added was: " + ch.getCoffee());
            System.out.println("Enter the add-on of your choice");
            String adOnchoice = scan.next();
            ch.setAddOn(adOnchoice);
            System.out.println("Add on added was: " + ch.getAddOn());
            ch.setBillList();
            System.out.println("Do you wish to give some new order?");
            System.out.println("Enter 'y' for new order & 'n' to termiante and genrate bill");
            c = scan.next().charAt(0);
        } while (c == 'y');
        ch.displayBill();
        scan.close();
    }

}
