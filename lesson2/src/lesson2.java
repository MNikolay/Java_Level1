import java.util.Arrays;

import static java.lang.Math.abs;

public class lesson2 {


    /*
    Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
    0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */
    private static void ArrayInvert()
    {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i=0; i<arr.length;i++)
        {
           switch (arr[i])
           {
               case 0: arr[i]=1;
               break;
               case 1: arr[i]=0;
               break;
               default:
           }
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
    Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
      значениями 0 3 6 9 12 15 18 21;
     */
    private static void ArrayFill()
    {
        int[] arr = new int[8];
        int j=0;
        for (int i=0; i<arr.length; i++)
        {
          arr[i]=j;
            j += 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
    Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
    умножить на 2;
     */
    private static void ArrayChange()
    {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i=0; i<arr.length; i++)
        {
            arr[i] = arr[i] * ((arr[i]<6)? 2:1);
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
    Создать квадратный двумерный целочисленный массив (количество строк и столбцов
    одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    private static void ArrayFillDiagonale1()
    {
        int[][] arr = new int [5][5];
        for (int i=0; i<arr.length; i++)
        {
            arr[i][i]=1;
        }
        System.out.println(Arrays.deepToString(arr));
    }

    /*
    Создать квадратный двумерный целочисленный массив (количество строк и столбцов
     одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    private static void ArrayFillDiagonale2()
    {
        int[][] arr = new int [4][4];
        for (int i=0; i<arr.length; i++)
        {
            for (int j=0; j<arr.length; j++)
            {
                if (j==i) arr[i][j]=1;
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }

    /*
    Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
    помощи интернета);
     */
    private static void ArrayMinMax()
    {
        int [] arr = {1200,32000,4545,130,232,30000,445,958};
        int min;
        int max;

        min=max=arr[0];

        for (int i=0;i<arr.length;i++)
        {
            if (arr[i]>=max) max=arr[i];

            if (arr[i]<=min) min=arr[i];
        }

        System.out.printf("Наименьшее число %d, наибольшее %d",min,max);
    }

    /*
    Написать метод, в который передается не пустой одномерный целочисленный массив,
     метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части
     массива равны.
     */
    private static boolean checkBalance(int [] arr)
    {
        int sum_left = 0;
        int sum_rigth = 0;
        int posBalance = 0;
        boolean result = false;

        while (posBalance<arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (i <= posBalance )
                    sum_left += arr[i];
                if (i > posBalance)
                    sum_rigth += arr[i];
            }
            if (sum_left==sum_rigth) {
                result=true;
                break;
            }
            posBalance +=1;
            sum_left=sum_rigth=0;
        }

        return result;
    }

    /*
    *     Написать метод, которому на вход подаётся одномерный массив и число n (может быть
         положительным, или отрицательным), при этом метод должен сместить все элементы
         массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными
        массивами.
     */
    private static void arrayShift (int[] arr, int shift)
    {
        for (int i=0;i<abs(shift);i++)
        {
            // сдвигаем вправо
            if (shift>0)
            {
                int t = arr[arr.length-1];
               for (int j=arr.length-1; j>0;j--)
               {
                   arr[j]=arr[j-1];
               }
               arr[0]=t;
            }
            // сдвигаем влево
            else
            {
                int t= arr[0];
                for (int j=0; j<arr.length-1;j++)
                {
                    arr[j]=arr[j+1];
                }
                arr[arr.length-1]=t;
            }
        }
    }

    public  static void main(String[] arg)
    {
       ArrayInvert();
       ArrayFill();
       ArrayChange();
       ArrayFillDiagonale1();
       ArrayFillDiagonale2();
       ArrayMinMax();
       System.out.println();

       int[] arr = {10,10,10};
       System.out.println(Arrays.toString(arr) + " Баланс - " + (checkBalance(arr)?" найден": "не найден"));

        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
       arrayShift(arr1,-3);
       System.out.println(Arrays.toString(arr1));
    }
}
