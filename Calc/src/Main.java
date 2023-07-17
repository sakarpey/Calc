import java.util.Scanner;                       // Библиотека ввода

public class Main {                             // КЛАСС
    public static void main(String[] args) throws Exception {     // МЕТОД
        String input;
        Scanner inputStr = new Scanner(System.in);
        System.out.println("Ведите выражение вида: \"1+1\" или \"V+V\" ");
        input = inputStr.nextLine();         // Вводим наш пример
        String itog=calc(input);            // Вызываем метод calc для решения
        System.out.print("Указанное вами, выражение равно " + itog);            // Выводим результат 'itog'
    }
    public static String calc(String input) throws Exception {
        String[] romVal = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        int otvet=0,a=0,b=0,i=0,l=0,znak=0,k=0,vvod=0;
        
        l=input.length();

        int [] rim = new int[2];       // массив для определения (римское число =1; арабское =2)

        char [] mass1= input.toCharArray();
        for (char x: mass1){  // x=v  k=2  znak=1  mass1[0]=t  mass1[1]=+ mass1[2]=t
            if(x=='+') {znak=1;k++;}
            if(x=='-') {znak=2;k++;} //    ищем знаки "+" и "-" в нашей строке
            if(x=='*') {znak=3;k++;}
            if(x=='/') {znak=4;k++;} //    ищем знаки "" и "/" в нашей строке
        }
        if (k>1) throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)"); //символов больше одного
        if (k<1) throw new Exception("строка не является математической операцией"); //нет (+, -, /, *)
        //проверяем первый сиввол на +, -, /, *
        if (mass1[0]=='+' || mass1[0]=='-' || mass1[0]=='*' || mass1[0]=='/') throw new Exception("строка не является математической операцией");
        //проверяем последний сиввол на +, -, /, *
        if (mass1[l-1]=='+' || mass1[l-1]=='-' || mass1[l-1]=='*' || mass1[l-1]=='/') throw new Exception("строка не является математической операцией");
        // проверка на лишнии буквы или символы в водимой строке
        for(i=0; i<l; i++) {   //i=4  vvod = 1   mass1[0]=I  mass1[1]=I mass1[2]=* mass1[3]=Y  l=4
            vvod=0;
            if (mass1[i]=='0' || mass1[i]=='1'|| mass1[i]=='2'|| mass1[i]=='3' ||mass1[i]=='4' ) vvod=1;
            if (mass1[i]=='5' || mass1[i]=='6'|| mass1[i]=='7'|| mass1[i]=='8' ||mass1[i]=='9') vvod=1;
            if (mass1[i]=='+' || mass1[i]=='-'|| mass1[i]=='*'|| mass1[i]=='/') vvod=1;
            if (mass1[i]=='I' || mass1[i]=='V'|| mass1[i]=='X') vvod=1;
            if (vvod==0)  throw new Exception("Вы ввели символы или буквы несоответствующие параметрам условия ввода");

            // n=2  x=6  rim[0]=1  rim[1]=2  mass[0]=5  mass[1]=6  mass[0]=5 mass[1]=6

        } // ---------------------------образуем наши два числа---------------------------------------------------------
        String [] mass= input.split("[+/*-]");int n=0; // делим нашу строку на два элемента массива mass до и после знака
        for (String x: mass) {    // запускаем цикл для сравнения наших двух элементов строк с нужными арабск. числами и римскими
            // присваиваем элементам массива mass[] наши вводимые числа до и после знака если они соответствуют параметрам ввода
            switch (x) {
                case "I" -> {mass[n] = "1";rim[n] = 1;}
                case "II" -> {mass[n] = "2";rim[n] = 1;}
                case "III" -> {mass[n] = "3";rim[n] = 1;}
                case "IV" -> {mass[n] = "4";rim[n] = 1;}
                case "V" -> {mass[n] = "5";rim[n] = 1;}
                case "VI" -> {mass[n] = "6";rim[n] = 1;}
                case "VII" -> {mass[n] = "7";rim[n] = 1;}
                case "VIII" -> {mass[n] = "8";rim[n] = 1;}
                case "IX" -> {mass[n] = "9";rim[n] = 1;}
                case "X" -> {mass[n] = "10";rim[n] = 1;}
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" -> rim[n] = 2;
                // если не соответствуют ни один параметр ввода
                default -> throw new Exception("Вы ввели числа несоответствующие условию параметрам ввода");

            }
            n++;          // дополнительный счетчик для массива mass[]
        }
        //   исключения
        // n=2  x=6  rim[0]=2  rim[1]=2  mass[0]=5  mass[1]=6  mass[0]=5 mass[1]=6 a=5  b=6  znak=3 otvet=30 romVal=XXX  input=  =XXX

        a=Integer.parseInt(mass[0]); b=Integer.parseInt(mass[1]);  //переводим строкоые элементы массива в целые значения
        if (rim[0]!=rim[1]) throw new Exception("т.к. используются одновременно разные системы счисления");
        if (znak==4 && b==0) throw new Exception("на 0 делить нельзя");
        if (a<b && rim[0]==1 && znak==2) throw  new Exception("в римской системе нет отрицательных чисел");
        if (a==b && rim[0]==1 && znak==2) throw  new Exception("в римской системе нет нуля");
        if (a<b && rim[0]==1 && znak==4) throw  new Exception("первое римское число должно быть не больше второго при делении");
        if (znak==1) otvet=a+b;
        if (znak==2) otvet=a-b;
        if (znak==3) otvet=a*b;
        if (znak==4) otvet=a/b;

        if (rim[0]==1) input = romVal[otvet-1];


        if (rim[0]==2){ input= String.valueOf(otvet); return input;}   // переводим обратно число полученное арабским вычислением в строку
        return input;
    }
}