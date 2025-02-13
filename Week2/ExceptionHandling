import java.util.Scanner;

public class ExceptionHandling {
    public void processInput(){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter the number: ");
            double num = sc.nextDouble();
            if (num == 0) throw new ArithmeticException("Cannot divide by zero");
            System.out.println("Reciprocal:" + (1/num));
        } catch (Exception e) {
            System.out.println("Invalid input "+ e.getMessage());
        }
    }
    public static void main(String[] args) {
        ExceptionHandling ex = new ExceptionHandling();
        ex.processInput();
    }
}
