package fr.varchar.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Libs extends Command
{

    public Libs(String name, String description)
    {
        super(name, description);
    }

    @Override
    public void execution(MessageReceivedEvent event)
    {
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("VarLib");
        embedBuilder.addField("Le Github", "https://github.com/pierre-development/varlib", false);
        embedBuilder.addField("Le lien", "https://repo1.maven.org/maven2/fr/varchar-dev/varlib/1.0.6/varlib-1.0.6.jar", false);
        embedBuilder.setColor(Color.GREEN);
        embedBuilder.setFooter("VarLib | " + new SimpleDateFormat("'le' dd/MM/yyyy '\u00E0' kk:mm:ss").format(new Date()));
        event.getTextChannel().sendMessage(embedBuilder.build()).queue();
    }
}
