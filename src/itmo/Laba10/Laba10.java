package itmo.Laba10;

import java.util.*;

public class Laba10
{
    public static void main(String[] args)
    {
        /** Лаба 10. Упражнение 1. */

        List<String> text1 = MyMethodsForFiles.getStringsFromFile("E:\\text.txt");

        MyMethodsForFiles.printText(text1);


        /** Лаба 10. Упражнение 2. */

        String text2 = "Программирование на Java - это круто! 2024";

        MyMethodsForFiles.writeStringIntoFile(text2, "E:\\text2.txt", false);


        /** Лаба 10. Упражнение 3. */

        MyMethodsForFiles.joinTextFiles("E:\\text.txt", "E:\\text2.txt", "E:\\text3.txt");


        /** Лаба 10. Упражнение 4. */

        MyMethodsForFiles.changeInFileNotLetterNotNumberByChar("E:\\text3.txt", '$');
    }
}
