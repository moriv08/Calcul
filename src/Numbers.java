import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {

    public String simbol(String str){
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/')
                return str.valueOf(str.charAt(i));
        }
        return "";
    }

    public void answer(String a, String b, String simbol){

        Pattern wRoman = Pattern.compile("(I|V|X){1,}");
        Matcher matcher1 = wRoman.matcher(a);
        Matcher matcher2 = wRoman.matcher(b);

        boolean m1 = matcher1.find();
        boolean m2 = matcher2.find();

        if (m1 && m2 && (simbol.equals("-") || simbol.equals("/"))){
            isWRoman(a, b, simbol);
        }else {

            int i;
            int k;

            i = numbType(a);
            k = numbType(b);

            if ((i < 11 && i >= 0) && (k < 11 && k >= 0))
                switch (simbol) {
                    case "+":
                        System.out.println(i + k);
                        break;
                    case "-":
                        System.out.println(i - k);
                        break;
                    case "*":
                        System.out.println(i * k);
                        break;
                    case "/":
                        if (k == 0) {
                            System.out.println("На ноль делить нельзя");
                            tryAgain();
                        } else {
                            if (i % k != 0)
                                System.out.println((double) i / k);
                            else
                                System.out.println(i / k);
                        }
                        break;
                    default:
                        tryAgain();
                }
            else {
                tryAgain();
            }
        }
    }

    public int numbType(String nbr){

        if (nbr.charAt(0) > 47 && nbr.charAt(0) < 58)
            return arabicNbr(nbr);
        else{
            return romanNbr(nbr);
        }
    }

    public int arabicNbr(String src){

        int numb = 0;

        for (int i = 0; i < src.length(); i++){

                    numb *= 10;
                    numb += src.charAt(i) - 48;
        }
        return numb;
    }

    public int romanNbr(String nbr){

        if (nbr.equalsIgnoreCase("I")) return 1;

        else if (nbr.equalsIgnoreCase("II")) return 2;

        else if (nbr.equalsIgnoreCase("III")) return 3;

        else if (nbr.equalsIgnoreCase("IV")) return 4;

        else if (nbr.equalsIgnoreCase("V")) return 5;

        else if (nbr.equalsIgnoreCase("VI")) return 6;

        else if (nbr.equalsIgnoreCase("VII")) return 7;

        else if (nbr.equalsIgnoreCase("VIII")) return 8;

        else if (nbr.equalsIgnoreCase("IX")) return 9;

        else if (nbr.equalsIgnoreCase("X")) return 10;

        else {
            System.out.println("Данные римские цифры недопустимы");
            return -1;
        }
    }

    public void printRomanMns(int i){
        if (i == 0)
            System.out.println("0");
        else if (i == 1)
            System.out.println("I");
        else if (i == 2)
            System.out.println("II");
        else if (i == 3)
            System.out.println("III");
        else if (i == 4)
            System.out.println("IV");
        else if (i == 5)
            System.out.println("IV");
        else if (i == 6)
            System.out.println("VI");
        else if (i == 7)
            System.out.println("VII");
        else if (i == 8)
            System.out.println("VIII");
        else if (i == 9)
            System.out.println("IX");
    }

    public void tryAgain(){
        System.err.println("Неправильно введены данные. Попробуйте ещё раз.\n");
        System.out.println("Введите 2 числа от 0 до 10 арабскими или римскими цифрами, по образцу: \n" +
                "1 + 1 или V - III или X * 4 или 3 / 4 " +
                " (римские цифры указываются заглавными буквами  I, V, X)");
    }

    public void isWRoman(String a, String b, String simbol){

        int i;
        int k;

        i = romanNbr(a);
        k = romanNbr(b);

        if (simbol.equals("/"))
            if (i % k != 0){
                System.out.println((double) i / k);
            }else {

                int ans;

                ans = i / k;
                if (ans == 1)
                    System.out.println("I");
                else if (ans == 2)
                    System.out.println("II");
                else if (ans == 3)
                    System.out.println("III");
                else if (ans == 4)
                    System.out.println("IV");
                else if (ans == 5)
                    System.out.println("V");
            }
        else{
            if (i - k < 0){
                System.out.printf("-");
                printRomanMns(k - i);
            }else
                printRomanMns(i - k);
        }
    }
}
