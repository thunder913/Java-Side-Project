import java.sql.SQLOutput;
import java.util.Scanner;

public class FoodForPets
{
    public static void main(String[] args)
    {
        var scanner = new Scanner(System.in);
        var days = scanner.nextInt();
        var totalFood = scanner.nextFloat();
        var eatenBiscuits = 0f;
        var dogFoodEaten = 0;
        var catFoodEaten = 0;
        for (int i = 1; i <= days; i++)
        {
            var dogFood = scanner.nextInt();
            var catFood = scanner.nextInt();
            var foodForDay = dogFood+catFood;
            if (i%3==0)
            {
                eatenBiscuits+= (float)foodForDay/10;
            }
            dogFoodEaten += dogFood;
            catFoodEaten += catFood;

        }
        int roundedBiscuits = Math.round(eatenBiscuits);
        var totalFoodEaten = dogFoodEaten+catFoodEaten;
        var totalFoodEatenPercent = totalFoodEaten/totalFood*100;
        var dogPercent = ((float)dogFoodEaten / (float)totalFoodEaten) * 100;
        var catPercent = ((float)catFoodEaten / (float)totalFoodEaten) * 100;
        System.out.format("Total eaten biscuits: " + roundedBiscuits + "gr.");
        System.out.println();
        System.out.format("%.2f", totalFoodEatenPercent);
        System.out.println("% of the food has been eaten.");
        System.out.format("%.2f", dogPercent);
        System.out.println("% eaten from the dog.");
        System.out.format("%.2f", catPercent);
        System.out.println("% eaten from the cat.");

    }
}
