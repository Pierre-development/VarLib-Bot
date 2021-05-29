package fr.varchar.bot;

import fr.varchar.bot.util.Utils;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {

    public Bot()
    {
        final JDABuilder jdaBuilder = JDABuilder.createDefault(Utils.getToken());
        try {
            jdaBuilder.build();
            System.out.println("builded");
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
