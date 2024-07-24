
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringCalculator Strcalc = new StringCalculator();
        Scanner in = new Scanner(System.in);
       String s = in.nextLine();
       boolean parseres = Strcalc.parseString(s);
        try {
            if(!parseres) {
                throw new Exception("Исключитильная ситуация: ощшибка во введенных дынных");
            }
        }                 //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
         catch(Exception ex){System.out.println(ex.getMessage());}
 try {
     if(parseres){if(Strcalc.checkoperation()) {
         System.out.println(Strcalc.firstoperand + Strcalc.op + Strcalc.secondoperand + "=" + Strcalc.operate());
     } else {
         throw new Exception("Исключительная ситуация: Недопустимая операция со строками");
     }}
 }
 catch(Exception ex)
 {System.out.println(ex.getMessage());
 }






    }
}
