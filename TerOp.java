public class TerOp {
    public static void main(String[] args) {
        int x = 5;
        int y;

        y = (x > 5) ? 1 : 0;
        System.out.println(y);
        System.out.println(getMax(3,7));

        int score = 49;
        String res = (score >= 70) ? "Pass" : (score >= 50) ? "Retake" : "Fail";
        System.out.println(res);

    }

    public static int getMax(int a, int b){
        return (a > b) ? a : b;
    }


}
