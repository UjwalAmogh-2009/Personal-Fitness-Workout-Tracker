import java.io.*;
import java.util.*;

class FitnessTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        int goal = readInt(sc, "Enter your daily step goal: ");

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        ArrayList<DayRecord> records = new ArrayList<>();
        int[] steps = new int[7];
        int total = 0, goalMet = 0;
        StringBuilder report = new StringBuilder("Weekly Report for " + name + "\n\n");

        for (int i = 0; i < 7; i++) {
            steps[i] = readInt(sc, "Enter steps for " + days[i] + ": ");
            records.add(new DayRecord(days[i], steps[i], goal));
        }
        for (DayRecord r : records) {
            total += r.getSteps();
            if (r.isGoalMet()) goalMet++;
            report.append(r.getDetails()).append("\n");
        }

        int[] sorted = steps.clone();
        Arrays.sort(sorted);
        report.append("\nTotal Steps: ").append(total)
              .append("\nTotal Calories: ").append(total / 20.0)
              .append("\nAverage Steps/Day: ").append(total / 7.0)
              .append("\nHighest: ").append(sorted[6]).append("  Lowest: ").append(sorted[0])
              .append("\nDays Goal Achieved: ").append(goalMet).append("/7\n");

        try {
            FileWriter w = new FileWriter("weekly_report.txt");
            w.write(report.toString());
            w.close();
            Scanner r = new Scanner(new File("weekly_report.txt"));
            System.out.println();
            while (r.hasNextLine()) System.out.println(r.nextLine());
            r.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        int key = readInt(sc, "\nEnter a step count to search: ");
        System.out.println(Arrays.binarySearch(sorted, key) >= 0 ? "Found" : "Not found");
    }

    static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int v = sc.nextInt();
                if (v >= 0) return v;
                System.out.println("Enter 0 or more.");
            } catch (InputMismatchException e) {
                System.out.println("Enter a whole number.");
                sc.next();
            }
        }
    }
}

class DayRecord {
    private String day;
    private int steps;
    private boolean goalMet;

    DayRecord(String day, int steps, int goal) {
        this.day = day;
        this.steps = steps;
        this.goalMet = steps >= goal;
    }

    int getSteps()      { return steps; }
    boolean isGoalMet() { return goalMet; }

    String getDetails() {
        return day + " -> Steps: " + steps + " | Calories: " + steps / 20.0
                + " | " + (goalMet ? "Goal Met" : "Goal Not Met");
    }
}
