import java.util.*;

public class SimpleExpenseSplitter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Number of friends
        System.out.print("Enter number of friends: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];
        double[] paid = new double[n];

        // Step 2: Take names
        for (int i = 0; i < n; i++) {
            System.out.print("Enter friend " + (i+1) + " name: ");
            names[i] = sc.nextLine();
        }

        // Step 3: Expenses
        System.out.print("Enter number of expenses: ");
        int e = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < e; i++) {
            System.out.println("Expense " + (i+1));

            System.out.print("Paid by (name): ");
            String payer = sc.nextLine();

            System.out.print("Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            // Find payer in names[]
            for (int j = 0; j < n; j++) {
                if (names[j].equalsIgnoreCase(payer)) {
                    paid[j] += amount;
                }
            }
        }

        // Step 4: Calculate total + equal share
        double total = 0;
        for (double x : paid) total += x;

        double share = total / n;

        // Step 5: Show Results
        System.out.println("\n--- FINAL SPLIT RESULT ---");
        System.out.println("Total Expense: " + total);
        System.out.println("Each Should Pay: " + share + "\n");

        for (int i = 0; i < n; i++) {
            double balance = paid[i] - share;

            if (balance > 0) {
                System.out.println(names[i] + " should RECEIVE: " + balance);
            } else if (balance < 0) {
                System.out.println(names[i] + " should PAY: " + Math.abs(balance));
            } else {
                System.out.println(names[i] + " is SETTLED.");
            }
        }
    }
}