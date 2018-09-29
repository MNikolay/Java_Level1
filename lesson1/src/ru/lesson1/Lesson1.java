package ru.lesson1;

public class Lesson1 {

    /*
        Mетод вычисляющий выражение a * (b + (c / d)). Метод работает с дробными числами
     */
    private static float Calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    /*
        Mетод вычисляющий выражение a * (b + (c / d)). Метод работает с целыми числами
     */
    private static int Calculate(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    /*
        Метод, принимающий на вход два числа, и проверяющий что их сумма лежит в
        пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
     */
    private static boolean inRange(int a, int b) {
        int sum = a + b;
        return (sum >= 10 && sum <= 20);
    }

    /*
        Метод должен напечатать в консоль положительное ли число передали, или отрицательное;
        Замечание: ноль считаем положительным числом.
     */
    private static void PositiveNegative (int a)
    {
        if (a>=0)
            System.out.printf("Число %d положительное",a);
        else
            System.out.printf("Число %d отрицательное",a);
    }

    /*
        Метод должен вернуть true, если число отрицательное;
     */
    private static boolean isNegative (int a)
    {
        return (a<0);
    }

    /*
       Метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    private static void Greetings (String a)
    {
        System.out.printf("Привет, %s!",a);
    }


    /*
       Метод, который определяет является ли год високосным, и выводит сообщение в консоль.
       Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    private static void isLeapYear (int year)
    {
      if (year%4==0 && (year%400==0 || year%100!=0))
           System.out.printf("Год %d - високосный",year);
      else
          System.out.printf("Год %d - не високосный",year);
    }

    public static void main(String[] arg) {


        byte _byte=127;
        short _shot=10;
        int _int=123456;
        long _long=40000L;
        float _floaf=100.0f;
        double _double=100.1234;
        char _char='A';
        boolean _bool=true;


        // вычислим выражение
        float resFloat = Calculate(2f, 1f, 5f, 3f);
        System.out.printf("a * (b + (c / d)) = %f",resFloat);
        System.out.println();

        // вычислим выражение
        int resInt = Calculate(2, 1, 5, 3);
        System.out.printf("a * (b + (c / d)) = %d",resInt);
        System.out.println();

        // проверим сумму двух чисел на попадание в диапазон от 10 до 20 включительно
        int a=5;
        int b=15;
        if (inRange(a, b))
            System.out.printf("Сумма %d + %d находится в диапазоне 10..20",a,b);
         else
            System.out.printf("Сумма %d + %d выходит за границы диапазона 10..20",a,b);
        System.out.println();


        // узнаем отрицательное или положительное указанное число
        PositiveNegative(8);
        System.out.println();

        // узнаем отрицательное ли указанное число
        int s=-30;
        if (isNegative(s))
            System.out.printf("Число %d отрицательное",s);
        else
            System.out.printf("Число %d не отрицательное",s);
        System.out.println();


        // выведем приветствие
        String name = "Николай";
        Greetings(name);
        System.out.println();

        // определим является ли указанный год високосным
        isLeapYear(2000);
    }
}
