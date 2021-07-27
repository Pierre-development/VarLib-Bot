package fr.varchar.bot.commands;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Clear extends Command {

    public Clear(String name, String description)
    {
        super(name, description);
    }

    @Override
    public void execution(MessageReceivedEvent event) {
        if (event.getMember().hasPermission(Permission.MESSAGE_MANAGE)){
            String[] commandArgs = event.getMessage().getContentRaw().split("\\s+");
            final EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setColor(Color.GREEN);
            embedBuilder.setFooter("VarLib | " + new SimpleDateFormat("'le' dd/MM/yyyy '\u00E0' kk:mm:ss").format(new Date()));
            event.getMessage().delete().queue();

            if (1 < commandArgs.length){
                int amount = Integer.parseInt(commandArgs[1]);

                if (amount < 1){
                    embedBuilder.setTitle("Erreur");
                    embedBuilder.setDescription("Vous ne pouvez pas supprimer moins d'un message.");
                }else if (amount > 100){
                    embedBuilder.setTitle("Erreur");
                    embedBuilder.setDescription("Vous ne pouvez pas supprimer plus de cent messages.");
                }else{
                    List<Message> msgs = event.getChannel().getHistory().retrievePast(amount).complete();
                    event.getChannel().purgeMessages(msgs);
                    embedBuilder.setTitle("Succès");
                    embedBuilder.setDescription(String.format("Vous avez bien supprimé %s messages !", amount));
                }
            }else{
                embedBuilder.setTitle("Erreur");
                embedBuilder.setDescription("Référez-vous a la commande help.");
            }
            event.getTextChannel().sendMessage(embedBuilder.build()).queue();
        }
    }
}
