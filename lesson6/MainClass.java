import javax.naming.spi.DirectoryManager;
import java.io.*;
import java.util.Scanner;

public class MainClass {
    /*
1.	Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
2.	Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла,
потом текст из второго.

3.	* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
4.  ** Написать метод, проверяющий, есть ли указанное слово в папке

    * */

    public static void main(String[] args) {
        try {

            //Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
            createFile('A', 10, "test1.txt");
            createFile('B', 2, "test2.txt");

            //Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла,
            //потом текст из второго.
            concatFile("test1.txt", "test2.txt", "test3.txt");

            //проверяет присутствует ли указанное пользователем слово в файле.
            String searchText="";
            System.out.println("Inter search text:");
            Scanner scan = new Scanner(System.in);
            searchText=scan.next();
            System.out.println(searchInFile("test1.txt",searchText));

            //метод, проверяющий, есть ли указанное слово в папке
            System.out.println(searchInFolder(searchText));

        } catch (FileNotFoundException f)
        {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile (char ch, int charCount, String fileName ) throws IOException
    {
        FileOutputStream fo = new FileOutputStream(fileName,false);
        for (int i=0;i<=charCount-1;i++)
        {
            fo.write(ch);
        }
        fo.close();
    }

    private static void concatFile (String file1, String file2, String file3) throws FileNotFoundException
    {
        StringBuilder str = new StringBuilder();

        Scanner scanner1 = new Scanner(new FileInputStream(file1));
        while (scanner1.hasNext())
        {
            str.append(scanner1.next());
        }
        scanner1.close();

        Scanner scanner2 = new Scanner(new FileInputStream(file2));
        while (scanner2.hasNext())
        {
            str.append(scanner2.next());
        }
        scanner2.close();

        PrintStream ps = new PrintStream(new FileOutputStream(file3,false));
        ps.println(str);
        ps.close();
    }

    private static boolean searchInFile (String fileName, String searchText) throws IOException
    {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        boolean result=false;

        while (scanner.hasNext()) {
                result = scanner.nextLine().equals(searchText);
                if (result) break;
            }
            scanner.close();

        return result;
    }

    private static boolean searchInFolder (String searchText) throws IOException
    {
        boolean result=false;
        String current = new java.io.File( "." ).getCanonicalPath();
        File file = new File(current);
        File[] fileList = file.listFiles();
        for (File fileName:fileList)
        {
            if (fileName.isFile()) {
                result = searchInFile(fileName.getName(), searchText);
                if (result)  break;
            }
        }
        return result;

    }
}
