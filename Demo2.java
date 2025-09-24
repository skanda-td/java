class CustomException extends Exception{
    public CustomException(String string){
        super(string);
    }
}

public class Demo2 {

    public static void main(String[] args) {
        int i = 20;
        int j = 0;
    
        try 
        {
            j = 18/i;
            if (j == 0) {
                throw new CustomException("No Zero Value Output");
            }
        } 
        catch (CustomException obj) 
        {
            j = 18/1;
            System.out.println("Something Went Wrong : " + obj);
            System.out.println("Default : " +  j);
        }
        catch (Exception e)
        {
            System.out.println("Something Went Wrong : " + e);
        }
    
        System.out.println(j);
        System.out.println("Bye");
    }

}
