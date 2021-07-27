package fr.varchar.bot;

import fr.varchar.bot.commands.CommandsListener;
import fr.varchar.bot.listeners.JoinListener;
import fr.varchar.bot.util.Utils;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Bot {
    public Bot() throws LoginException {
        String token = Utils.getToken();

        if (token == null){
            Main.LOGGER.error("I can't get token!");
            System.exit(0);
        }

        final JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        jdaBuilder.addEventListeners(new JoinListener(), new CommandsListener());
        jdaBuilder.setActivity(Activity.watching("https://github.com/Pierre-development/VarLib"));
        jdaBuilder.build();
    }
}
