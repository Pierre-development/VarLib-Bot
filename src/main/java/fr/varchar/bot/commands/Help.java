package fr.varchar.bot.commands;

import fr.varchar.bot.listeners.JoinListener;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Help extends Command
{

    public Help(String name, String description)
    {
        super(name, description);
    }

    @Override
    public void execution(MessageReceivedEvent event)
    {
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("liste des commandes disponibles");
        embedBuilder.setColor(Color.GREEN);
        for (Command command : CommandsListener.getCommandList())
        {
            embedBuilder.addField(command.getName(), command.getDescription(), false);
        }
        embedBuilder.setFooter("VarLib | " + new SimpleDateFormat("'le' dd/MM/yyyy '\u00E0' kk:mm:ss").format(new Date()));
        event.getTextChannel().sendMessage(embedBuilder.build()).queue();
    }
}
