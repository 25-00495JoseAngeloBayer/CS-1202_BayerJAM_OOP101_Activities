import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String[] menuItems = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
        double[] menuPrices = {80.00, 120.00, 100.00, 70.00, 90.00};

        int totalQuantity = 0;
        double totalBeforeDiscount = 0.0;
        double totalDiscount = 0.0;

        char orderAgain;

        do {
            
            System.out.println("=====    MENU     =====");
            for (int i = 0; i < menuItems.length; i++) {
                System.out.printf("%d. %-10s - $%.2f%n", (i + 1), menuItems[i], menuPrices[i]);
            }
            System.out.println();

            
            System.out.print("Enter item number: ");
            int itemNum = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

           
            if (itemNum < 1 || itemNum > menuItems.length || quantity < 1 || quantity > 10) {
                System.out.println("Invalid order! Please enter a valid item and quantity.");
                
               
                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = scanner.next().toUpperCase().charAt(0);
                System.out.println();
                
                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char studentInput = scanner.next().toUpperCase().charAt(0);
            boolean isStudent = (studentInput == 'Y');
            double itemPrice = menuPrices[itemNum - 1];
            double subtotal = itemPrice * quantity;

            double discountRate = 0.0;
            if (isStudent && subtotal >= 500.0) {
                discountRate = 0.15;
            } else if (isStudent) {
                discountRate = 0.10;
            } else if (subtotal >= 500.0) {
                discountRate = 0.05;
            }

            double discountAmount = subtotal * discountRate;
            double orderTotal = subtotal - discountAmount;

            totalQuantity += quantity;
            totalBeforeDiscount += subtotal;
            totalDiscount += discountAmount;

            System.out.printf("Subtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Order total: $%.2f%n", orderTotal);
            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = scanner.next().toUpperCase().charAt(0);
            System.out.println();

        } while (orderAgain == 'Y');

        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println("===== ORDER SUMMARY =====");
        System.out.printf("Total items: %d%n", totalQuantity);
        System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");

        scanner.close();
    }
}