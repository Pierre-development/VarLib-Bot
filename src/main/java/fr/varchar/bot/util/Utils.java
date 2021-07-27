package fr.varchar.bot.util;

import java.io.*;
import java.net.URL;

public class Utils {

    public static String getToken(){
        try{
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("token.txt")));
            return bufferedReader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getLatestVarLibVersion() throws IOException {
        String varLibVersion = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL("https://repo1.maven.org/maven2/fr/varchar-dev/varlib/maven-metadata.xml").openStream()));

        for(String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()){
            if (line.contains("latest")){
                varLibVersion = line.replace("    <latest>", "").replace("</latest>", "");
            }
        }
        bufferedReader.close();
        return varLibVersion;
    }

}
