package fr.varchar.bot;

import fr.varchar.bot.commands.CommandsListener;
import fr.varchar.bot.listeners.JoinListener;
import fr.varchar.bot.util.Utils;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Bot
{
    public Bot() throws LoginException
    {
        final JDABuilder jdaBuilder = JDABuilder.createDefault(Utils.getToken());
        jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        jdaBuilder.addEventListeners(new JoinListener(), new CommandsListener());
        jdaBuilder.build();
    }
}
