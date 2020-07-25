import java.io.Reader;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        var scan = new Scanner(System.in);
        var fruit = scan.nextLine();
        var size = scan.nextLine();
        var orderedSets = scan.nextInt();
        float price = 0;
        switch (size)
        {
            case "small":
                switch (fruit)
                {
                    case "Watermelon":
                        price = 56f*2;
                        break;
                    case "Mango":
                        price = 36.66f*2;
                        break;
                    case "Pineapple":
                        price = 42.10f*2;
                        break;
                    case "Raspberry":
                        price = 20f*2;
                        break;

                }
                break;
            case "big":
                switch (fruit)
                {
                    case "Watermelon":
                        price = 28.7f*5;
                        break;
                    case "Mango":
                        price = 19.60f*5;
                        break;
                    case "Pineapple":
                        price = 24.80f*5;
                        break;
                    case "Raspberry":
                        price = 15.2f*5;
                        break;

                }
                break;
        }
        var sum = price*orderedSets;
        if (sum>=400 &&sum <=1000){sum *= 0.85;}
        else if(sum>1000){sum*=0.5;}

        System.out.format("%.2f lv.", sum);
    }
}
