package fr.varchar.bot.util;

import java.io.*;

public class Utils {
    public static String getToken()
    {
        try
        {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("token.txt")));
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
