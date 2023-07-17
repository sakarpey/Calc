import java.util.Scanner;                       // библиотеки ввода

public class Main {                             // КЛАСС
    public static void main(String[] args) throws Exception {     // МЕТОД
        String input;
        Scanner inputStr = new Scanner(System.in);
        System.out.println("Ведите пример:");
        input = inputStr.nextLine();         // Вводим наш пример
        String itog=calc(input);            // Вызываем метод calc для решение
        System.out.print(itog);            // Выводим результат 'itog'
    }
    public static String calc(String input) throws Exception {

        int otvet=0,a=0,b=0,i=0,l=0,znak=0,k=0,vvod=0;
        String s="";
        l=input.length();
        String [] mstr = new String[2]; //массива mstr[] присваиваем до и после знака если они соответствуют параметрам ввода
        int [] rim = new int[2];       // массив для определение римское число =1; арабское =2

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

            // n=2  x=6  rim[0]=1  rim[1]=2  mstr[0]=5  mstr[1]=6  mass[0]=5 mass[1]=6

        } // ---------------------------образуем наши два числа---------------------------------------------------------
        String [] mass= input.split("[\\+/*-]");int n=0; // делим нашу строку на два элемента массива mass до и после знака
        for (String x: mass) {    // запускаем цикл для сравнения наших двух элементов строк с нужными арабск. числами и римскими
            // присваиваем элементам массива mstr[] наши вводимые числа до и после знака если они соответствуют параметрам ввода
            if (x.equals("I")) {mstr[n] = "1"; rim[n]=1;}else if (x.equals("II")) {mstr[n] = "2";rim[n]=1;}
            else  if (x.equals("III")) {mstr[n] = "3"; rim[n]=1;} else  if (x.equals("IV")) {mstr[n] = "4";rim[n]=1;}
            else  if (x.equals("V")) {mstr[n] = "5"; rim[n]=1;} else  if (x.equals("VI")) {mstr[n] = "6";rim[n]=1;}
            else  if (x.equals("VII")) {mstr[n] = "7"; rim[n]=1;} else  if (x.equals("VIII")) {mstr[n] = "8";rim[n]=1;}
            else  if (x.equals("IX")) {mstr[n] = "9"; rim[n]=1;} else  if (x.equals("X")) {mstr[n] = "10";rim[n]=1;}
            else  if (x.equals("1")) {mstr[n] = "1"; rim[n]=2;} else  if (x.equals("2")) {mstr[n] = "2";rim[n]=2;}
            else  if (x.equals("3")) {mstr[n] = "3"; rim[n]=2;} else  if (x.equals("4")) {mstr[n] = "4";rim[n]=2;}
            else  if (x.equals("5")) {mstr[n] = "5"; rim[n]=2;} else  if (x.equals("6")) {mstr[n] = "6";rim[n]=2;}
            else  if (x.equals("7")) {mstr[n] = "7"; rim[n]=2;} else  if (x.equals("8")) {mstr[n] = "8";rim[n]=2;}
            else  if (x.equals("9")) {mstr[n] = "9"; rim[n]=2;} else  if (x.equals("10")) {mstr[n] = "10";rim[n]=2;}
            else  if (x.equals("0")) {mstr[n] = "0"; rim[n]=2;}
            // если не соответствуют ни один параметр ввода
            else throw new Exception ("Вы ввели числа несоответствующие условию параметрам ввода");
            n++;          // дополнительный счетчик для массива mstr[]
        }
        //   инициализация
        // n=2  x=6  rim[0]=2  rim[1]=2  mstr[0]=5  mstr[1]=6  mass[0]=5 mass[1]=6 a=5  b=6  znak=3 otvet=30 s=xxx  input=  =XXX

        a=Integer.parseInt(mstr[0]); b=Integer.parseInt(mstr[1]);  //переводим строкоые элементы массива в целые значения
        if (rim[0]!=rim[1]) throw new Exception("т.к. используются одновременно разные системы счисления");
        if (znak==4 && b==0) throw new Exception("на 0 делить нельзя");
        if (a<b && rim[0]==1 && znak==2) throw  new Exception("в римской системе нет отрицательных чисел");
        if (a==b && rim[0]==1 && znak==2) throw  new Exception("в римской системе нет нуля");
        if (a<b && rim[0]==1 && znak==4) throw  new Exception("первое римское число должно быть не больше второго при делении");
        if (znak==1) otvet=a+b;
        if (znak==2) otvet=a-b;
        if (znak==3) otvet=a*b;
        if (znak==4) otvet=a/b;

        if (rim[0]==1){
            if (otvet==1) s = "I"; if (otvet==2) s = "II";if (otvet==3) s = "III";if (otvet==4) s = "IV";if (otvet==5) s = "V";
            if (otvet==6) s = "VI"; if (otvet==7) s = "VII";if (otvet==8) s = "VIII";if (otvet==9) s = "IX";if (otvet==10) s = "X";
            if (otvet==11) s = "XI"; if (otvet==12) s = "XII";if (otvet==13) s = "XIII";if (otvet==14) s = "XIV";if (otvet==15) s = "XV";
            if (otvet==16) s = "XVI"; if (otvet==17) s = "XVII";if (otvet==18) s = "XVIII";if (otvet==19) s = "IXX";if (otvet==20) s = "XX";
            if (otvet==21) s = "XXI"; if (otvet==22) s = "XXII";if (otvet==23) s = "XXIII";if (otvet==24) s = "XXIV";if (otvet==25) s = "XXV";
            if (otvet==26) s = "XXVI"; if (otvet==27) s = "XXVII";if (otvet==28) s = "XXVIII";if (otvet==29) s = "XXIX";if (otvet==30) s = "XXX";
            if (otvet==31) s = "XXXI"; if (otvet==32) s = "XXXII";if (otvet==33) s = "XXXIII";if (otvet==34) s = "XXXIV";if (otvet==35) s = "XXXV";
            if (otvet==36) s = "XXXVI"; if (otvet==37) s = "XXXVII";if (otvet==38) s = "XXXVIII";if (otvet==39) s = "XXXIX";if (otvet==40) s = "XL";
            if (otvet==41) s = "XLI"; if (otvet==42) s = "XLII";if (otvet==43) s = "XLIII";if (otvet==44) s = "XLIV";if (otvet==45) s = "XLV";
            if (otvet==46) s = "XLVI"; if (otvet==47) s = "XLVII";if (otvet==48) s = "XLVIII";if (otvet==49) s = "XLIX";if (otvet==50) s = "L";
            if (otvet==51) s = "LI"; if (otvet==52) s = "LII";if (otvet==53) s = "LIII";if (otvet==54) s = "LIV";if (otvet==55) s = "LV";
            if (otvet==56) s = "LVI"; if (otvet==57) s = "LVII";if (otvet==58) s = "LVIII";if (otvet==59) s = "LIX";if (otvet==60) s = "LX";
            if (otvet==61) s = "LXI"; if (otvet==62) s = "LXII";if (otvet==63) s = "LXIII";if (otvet==64) s = "LXIV";if (otvet==65) s = "LXV";
            if (otvet==66) s = "LXVI"; if (otvet==67) s = "LXVII";if (otvet==68) s = "LXVIII";if (otvet==69) s = "LXIX";if (otvet==70) s = "LXX";
            if (otvet==71) s = "LXXI"; if (otvet==72) s = "LXXII";if (otvet==73) s = "LXXIII";if (otvet==74) s = "LXXV";if (otvet==75) s = "LXXV";
            if (otvet==76) s = "LXXVI"; if (otvet==77) s = "LXXVII";if (otvet==78) s = "LXXVIII";if (otvet==79) s = "LXXIX";if (otvet==80) s = "LXXX";
            if (otvet==81) s = "LXXXI"; if (otvet==82) s = "LXXXII";if (otvet==83) s = "LXXXIII";if (otvet==84) s = "LXXXIV";if (otvet==85) s = "LXXXV";
            if (otvet==86) s = "LXXXVI"; if (otvet==87) s = "LXXXVII";if (otvet==88) s = "LXXXVIII";if (otvet==89) s = "LXXXIX";if (otvet==90) s = "XC";
            if (otvet==91) s = "XCI"; if (otvet==92) s = "XCII";if (otvet==93) s = "XCIII";if (otvet==94) s = "XCIV";if (otvet==95) s = "XCIV";
            if (otvet==96) s = "XCVI"; if (otvet==97) s = "XCVII";if (otvet==98) s = "XCVIII";if (otvet==99) s = "XCIX";if (otvet==100) s = "C";
            input="="+s;
        }
        if (rim[0]==2){ input= String.valueOf(otvet); input="="+input;return input;}   // переводим обратно число полученное арабским вычислением в строку
        return input;
    }
}