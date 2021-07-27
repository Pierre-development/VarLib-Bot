package fr.varchar.bot;

import fr.varchar.bot.util.Utils;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.security.auth.login.LoginException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static String varLibVersion = null;

    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure(Main.class.getResourceAsStream("/log4j.properties"));

        TimerTask refreshVarLibVersion = new TimerTask () {
            @Override
            public void run () {
                try {
                    varLibVersion = Utils.getLatestVarLibVersion();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        new Timer().schedule(refreshVarLibVersion, 0L, 3600000);

        try{
            new Bot();
        } catch (LoginException e){
            e.printStackTrace();
        }
    }

}
