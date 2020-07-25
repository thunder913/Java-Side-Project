import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var boughtDogFood = Integer.parseInt(scanner.nextLine()) * 1000;
        int neededFood = 0;
        var command = scanner.nextLine();
        while (!command.equals("Adopted"))
        {
            var foodEaten = Integer.parseInt(command);
            neededFood += foodEaten;
            command = scanner.nextLine();
        }
        if (neededFood<=boughtDogFood){
            System.out.format("Food is enough! Leftovers: %d grams.", boughtDogFood-neededFood );
        }else{
            System.out.format("Food is not enough. You need %d grams more.", neededFood-boughtDogFood);
        }
    }
}