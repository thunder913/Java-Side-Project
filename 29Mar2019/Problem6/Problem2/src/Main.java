import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            var scanner = new Scanner(System.in);

            var caloriesPerMinute = 5;

            var minutesWalk = scanner.nextInt();
            var walksPerDay = scanner.nextInt();
            var calories = scanner.nextInt();

            var firedCalories = minutesWalk*walksPerDay*caloriesPerMinute;
            var neededFiredCalories = calories/2;

        if (firedCalories>= neededFiredCalories)
        {
            System.out.format("Yes, the walk for your cat is enough. Burned calories per day: %d.", firedCalories);
        }
        else
            {
                System.out.format("No, the walk for your cat is not enough. Burned calories per day: %d.", firedCalories);
            }
    }
}
