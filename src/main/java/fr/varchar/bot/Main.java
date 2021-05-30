package fr.varchar.bot;

import javax.security.auth.login.LoginException;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {
        try
        {
            new Bot();
        } catch (LoginException e)
        {
            e.printStackTrace();
        }
    }

}
