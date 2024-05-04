package itmo.Laba10;

import java.io.*;
import java.util.*;

public class MyMethodsForFiles
{
    public static List<String> getStringsFromFile(String filePath)
    {
        List<String> rezStrings = new ArrayList<>();

        BufferedReader reader = null;

        try
        {
            File file = new File(filePath);

            FileReader fr = new FileReader(file);

            reader = new BufferedReader(fr);

            String line = reader.readLine();

            while (line != null)
            {
                rezStrings.add(line);
                line = reader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Ошибка! Файл по указанному пути не найден. Проверьте корректность записи пути к файлу.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(reader != null) reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return rezStrings;
    }

    public static void printText(List<String> text)
    {
        if (!text.isEmpty())
        {
            for (String line : text)
            {
                System.out.println(line);
            }
            System.out.println("");
        }
    }

    public static void writeStringIntoFile(String text, String filePath, boolean isNotReWrite)
    {
        if(text != "" && text != null)
        {

            FileWriter writer = null;

            try
            {
                writer = new FileWriter(filePath, isNotReWrite);
                writer.write(text + System.lineSeparator());
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
            finally
            {
                try
                {
                    if (writer != null)
                    {
                        writer.close();
                    }
                }
                catch(IOException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public static void joinTextFiles(String filepath1, String filepath2, String filepathRezult)
    {
        List<String> text1 = getStringsFromFile(filepath1);
        List<String> text2 = getStringsFromFile(filepath2);

        List<String> textRezult = new ArrayList();

        textRezult.addAll(text1);
        textRezult.addAll(text2);

        boolean flag = false;

        if(!textRezult.isEmpty())
        {
            for(String line : textRezult)
            {
                writeStringIntoFile(line, filepathRezult, flag);
                flag = true;
            }
        }
    }

    public static String changeInStringNotLetterNotNumberByChar(String string, char symbol)
    {
        if (null == string) return null;
        if("" == string) return "";

        char[] chars = string.toCharArray();

        String rez = "";

        for (char ch : chars)
        {
            if(!Character.isLetter(ch) && !Character.isDigit(ch)) rez += symbol;
            else rez += ch;
        }

        return rez;
    }

    public static void changeInFileNotLetterNotNumberByChar(String filepath, char symbol)
    {
        List<String> text = getStringsFromFile(filepath);

        if(!text.isEmpty())
        {
            String str = "";

            boolean flag = false;

            for(String line : text)
            {
                str = changeInStringNotLetterNotNumberByChar(line, symbol);
                writeStringIntoFile(str, filepath, flag);
                flag = true;
            }
        }
    }
}
