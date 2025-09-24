public class PowerNum {
    public static void main(String[] args) {
        int num = 25;
        int left = 1;
        int right = num;
        int mid;

        while (right >= left) {
            mid = (left + right)/2;
            if (mid * mid == num) {
                System.out.println(mid);
                return;
            }
            else if (mid * mid > num) right = mid - 1;
            else left = mid + 1;
        }
    }
}
