package fr.varchar.bot.commands;

import fr.varchar.bot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Libs extends Command{

    public Libs(String name, String description)
    {
        super(name, description);
    }

    @Override
    public void execution(MessageReceivedEvent event){
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("VarLib");
        embedBuilder.addField("GitHub", "https://github.com/Pierre-development/VarLib", false);
        embedBuilder.addField("Lien de téléchargement", "https://repo1.maven.org/maven2/fr/varchar-dev/varlib/" + Main.varLibVersion + "/varlib-" + Main.varLibVersion + ".jar", false);
        embedBuilder.setColor(Color.GREEN);
        embedBuilder.setFooter("VarLib | " + new SimpleDateFormat("'le' dd/MM/yyyy '\u00E0' kk:mm:ss").format(new Date()));
        event.getTextChannel().sendMessage(embedBuilder.build()).queue();
    }
}
