package question;

public class Question2 {
    //    5 days a week office
//    X days public, Y Days Private
//    Public Cost : costX, Private : CostY
//    Public: IncX %, Private: incY %
//    Term :
//    Total, Private, Public
    public static void main(String[] args) {

        Travel emp1 = new Travel(3, 2, 20, 200, 5, 20, 10);
        Travel emp2 = new Travel(2, 3, 50, 100, 25, 50, 15);

        System.out.println(emp1.totalCost());
//        System.out.println(emp2.totalCost());

        System.out.println(totalCost(3, 2, 20, 200, 5, 20, 10));
    }

    public static double totalCost(int x, int y, int costX, int costY, int incX, int incY, int term) {
        int totalPublicDays = 52 * x;
        int totalPrivateDays = 52 * y;

        int publicCost = 0, privateCost = 0;

        for (int i = 1; i <= term; i++) {
            publicCost += costX * totalPublicDays;
            privateCost += costY + totalPrivateDays;

            costX += (costX * incX / 100);
            costY += (costY * incY / 100);
        }

        System.out.println("public :" + publicCost);
        System.out.println("private :" + privateCost);
        return (double) (privateCost + publicCost);
    }

}

class Travel {
    int x;
    int y;
    int costX;
    int costY;
    int incX;
    int incY;
    int term;

    Travel(int x, int y, int costX, int costY, int incX, int incY, int term) {
        this.x = x;
        this.y = y;
        this.costX = costX;
        this.costY = costY;
        this.incX = incX;
        this.incY = incY;
        this.term = term;
    }

    public double totalCost() {
        int totalPublicDays = 52 * x;
        int totalPrivateDays = 52 * y;

        int publicCost = 0, privateCost = 0;

        for (int i = 1; i <= term; i++) {
            publicCost += costX * totalPublicDays;
            privateCost += costY + totalPrivateDays;

            costX += (costX * incX / 100);
            costY += (costY * incY / 100);
        }

        System.out.println("public :" + publicCost);
        System.out.println("private :" + privateCost);
        return (double) (privateCost + publicCost);
    }
}
