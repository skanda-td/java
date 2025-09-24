public class Demo {
    public static void main(String[] args) {
        
        int i = 2;
        int j = 0;

        int [] nums = new int[5];
        String string = null;

        try 
        {
            System.out.println(string.length());
            System.out.println(nums[5]);
            j = 18/i;
        } 
        catch (ArithmeticException obj) 
        {
            System.out.println(obj);
            System.out.println("Cannot Divide By Zero!!");  
        }
        catch (ArrayIndexOutOfBoundsException obj) 
        {
            System.out.println(obj);
            System.out.println("Array Index Out of Bound");  
        }
        catch (Exception e)
        {
            System.out.println("Something Went Wrong : " + e);
        }

        System.out.println(j);
        System.out.println("Bye");
    }
}
