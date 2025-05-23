package ui;
import java.util.Scanner;

public class Home {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Subs4U! Please choose an option to get started.");
        System.out.println("1. 🥪 Start New Order\n2. Exit");
        String input = sc.nextLine();

        switch (input){
            case 1 -> displayOrderScreen();
            case 2 -> {
                return;}
        }
    }

    public void displayOrderScreen(){

    }

}
