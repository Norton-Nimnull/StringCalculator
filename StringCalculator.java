public class StringCalculator {
    public  int num;
    public  char op;
    public  boolean secisnum=false;
    public  boolean numiscorr=false;

    public  String firstoperand;
    public  String secondoperand;
    public void getinfo(){
        System.out.println(minus("fuck you","you"));
    }
    public boolean parseString(String str)
    {   boolean result = false;
        int index = str.indexOf('"');
        if (index != 0) {
            System.out.println("первый операнд должен быть строкой");
        } else
        {
            int index2 = str.indexOf('"', index + 1);
            // System.out.println(index2);
            String firststr = str.substring(index + 1, index2);
            firstoperand = firststr;
            // System.out.println(firststr);
            int index3 = 0;
            int index4 = 0;
            for (int i = index2 + 1; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '"') {
                    if (index3 == 0) {
                        index3 = i;
                    } else {
                        index4 = i;
                    }
                }
            }
            if ((index3 > 0) & (index4 > 0)) {
                String str2 = str.substring(index2 + 1, index3);
                String str3 = str.substring(index3 + 1, index4);
                String operstr = str2.trim();
                op = operstr.charAt(0);
                //  System.out.println(op);
                String secondstr = str3.trim();
                if(((firstoperand.length()<11)&&(secondstr.length()<11)))
                {secondoperand = secondstr;
                result = true;}else{System.out.println("строки должны быть до 10 символов");}
            } else {
                if ((index3 == 0) & (index4 == 0)) {
                    //second string is number
                    //System.out.println("second string is number");
                    int curind = index2 + 1;
                    boolean nowisspaces = false;
                    boolean nowisstring = false;
                    String curstr = "";
                    String[] Strings = new String[5];
                    int sind = 0;
                    for (int i = curind; i < str.length(); i++) {
                        char c = str.charAt(i);
                        if (c == ' ') {
                            nowisspaces = true;
                            if (nowisstring) {
                                Strings[sind] = curstr;
                                sind = sind + 1;
                                curstr = "";
                                nowisstring = false;
                            }
                        } else {
                            nowisspaces = false;
                            nowisstring = true;
                            curstr = curstr + c;
                            if (i == str.length() - 1) {
                                Strings[sind] = curstr;
                                sind = sind + 1;
                            }
                        }
                    }
                    //System.out.println("length="+Strings[0]);
                    op = Strings[0].charAt(0);
                    //System.out.println(op);
                    //System.out.println("length="+Strings[1]);
                    String ns = Strings[1];
                    secondoperand = ns;

                    if (isNumber(ns))
                    {
                        num = Integer.parseInt(ns);
                        if((num>0)&&(num<11))
                        {result = true;
                        secisnum = true;
                        numiscorr = true;
                            //System.out.println("число корректное");
                    } else {
                        System.out.println("второй операнд не соответвует целочисленному значению от 1 до 10");
                    }}

                }
            }
        }
    return result;}
    public  String plus(String s1,String s2){
        return cut(s1+s2);
    }
    public static String minus(String s1, String s2){
        int ind = s1.indexOf(s2);
        if(!(ind==-1)){return s1.replace(s2,""); } else{
            return s1;}
    }
    public static String multiply(String s1, int n){
        String result = "";
        for(int i=0;i<n;i++)
        {result = result+s1;}
        return cut(result);
    }
    public static String divideby(String s, int n){
        int nl = s.length() / n;
        String result = s.substring(0,nl);
        return result;
    }
    public static String cut(String S){
        String result="";
        if(S.length()>40){result=S.substring(0,39)+"...";}else {result = S;}
        return result;
    }
    public boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
public boolean checkoperation(){
boolean result = false;
if( secisnum){if((op=='+')|(op=='-')){System.out.println("Нельзя складывать и вычитать строку с числом");}else{result = true;}}
if(!secisnum){if((op=='*')|(op=='/')){System.out.println("Нельзя умножать и делить строки");}else{result = true;}}
        return result&&((op=='+')|(op=='-')|(op=='*')|(op=='/'));
}
    public  String operate(){
        String result="";
        if(!secisnum){
            switch (op) {
                case '+':result = plus(firstoperand, secondoperand);
                    break;
                case '-':result = minus(firstoperand,secondoperand);
                    break;
            }}
        else{if(numiscorr){switch (op){
            case '*':result = multiply(firstoperand,num);
                break;
            case '/':result = divideby(firstoperand,num);
                break;

        }}}
        return result;
    }
}
