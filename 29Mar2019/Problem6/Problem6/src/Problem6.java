import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var totalDays = Integer.parseInt(scanner.nextLine());
        float totalMoney = 0f;
        var wonDays = 0;
        var lostDays = 0;
        for (int i = 0; i < totalDays; i++) {
            var winsToday = 0;
            var losesToday = 0;
            float currentMoney = 0;
            var command = scanner.nextLine();
            while (!command.equals("Finish")){
                var result = scanner.nextLine();
                if (result.equals("win")){
                    currentMoney+=20;
                    winsToday++;
                }else{
                    losesToday++;

                }
                command = scanner.nextLine();
            }
            if (winsToday>losesToday){
                currentMoney*=1.1;
                wonDays++;
            }else{
                lostDays++;
            }
            totalMoney += currentMoney;
        }
        if (wonDays>lostDays){
            totalMoney*=1.2;
            System.out.format("You won the tournament! Total raised money: %.2f", totalMoney);
        }else{
            System.out.format("You lost the tournament! Total raised money: %.2f", totalMoney);
        }

    }
}
