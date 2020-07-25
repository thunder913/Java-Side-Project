import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float bitcoin = 1168f;
        float euro = 1.95f;
        float dollar = 1.76f;
        float chineseUan = (float) (0.15*dollar);

        Scanner scanner = new Scanner(System.in);

        var bitcoins = scanner.nextFloat();
        var chinese = scanner.nextFloat();
        var comission = scanner.nextFloat();

        var result = (bitcoins*bitcoin + chinese*chineseUan)/euro;
        var moneyAfterComission = result*(1-comission/100);
        System.out.printf("%.2f", moneyAfterComission);
    }
}
