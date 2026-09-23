import java.util.Scanner;

public class FitnessTracker {

    // Module 1: Constants
    static final int DAYS = 7;
    static final int STEPS_PER_CALORIE = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // Module 1: Scanner for input

        System.out.print("Enter your name: ");
        String name = sc.nextLine();           // Module 1: reading typed input
        System.out.println("Welcome " + name + "! Let's track your week.\n");

        System.out.print("Enter your daily step goal: ");
        int goal = sc.nextInt();

        String[] dayNames = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] steps = new int[DAYS];           // Module 3: 1D array
        double[] calories = new double[DAYS];
        int goalMetCount = 0;

        // Module 2: for loop (input + processing)
        for (int i = 0; i < DAYS; i++) {
            System.out.print("Enter steps for " + dayNames[i] + ": ");
            steps[i] = sc.nextInt();
            calories[i] = calculateCalories(steps[i]);

            // Module 1: relational operator
            String status = (steps[i] >= goal) ? "Goal Met" : "Goal Not Met";

            // Module 2: if statement
            if (steps[i] >= goal) {
                goalMetCount++;                // Module 1: unary operator
            }

            // Module 1:output (simple print, no formatting)
            System.out.println(dayNames[i] + " -> Steps: " + steps[i]
                    + " | Calories: " + calories[i]
                    + " | " + status);
        }

        // Module 3: average using a loop
        int totalSteps = 0;
        for (int i = 0; i < DAYS; i++) {
            totalSteps = totalSteps + steps[i];
        }
        double totalCalories = calculateCalories(totalSteps);
        double avgSteps = (double) totalSteps / DAYS;   // typecasting

        System.out.println("\n----- Summary -----");
        System.out.println("Total Steps: " + totalSteps);
        System.out.println("Total Calories: " + totalCalories);
        System.out.println("Average Steps/Day: " + avgSteps);
        System.out.println("Days Goal Achieved: " + goalMetCount + "/" + DAYS);

        System.out.print("\nDaily steps: ");
        for (int i = 0; i < DAYS; i++) {
            System.out.print(steps[i] + " ");
        }

        sc.close();
    }

    // Module 3: method with parameter and return value
    static double calculateCalories(int steps) {
        return (double) steps / STEPS_PER_CALORIE;   // arithmetic + typecasting
    }
}