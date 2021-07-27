package fr.varchar.bot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static fr.varchar.bot.util.Constants.PREFIX;

public class CommandsListener extends ListenerAdapter {
    private static final List<Command> COMMANDS = new ArrayList<>();

    public CommandsListener(){
        COMMANDS.add(new Help("help", "Affiche les commandes disponibles"));
        COMMANDS.add(new Libs("libs", "Afficher les informations sur VarLib"));
        COMMANDS.add(new Clear("clear", "Supprimer des messages"));
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event){

        super.onMessageReceived(event);
        if (event.getMessage().getContentRaw().startsWith(PREFIX)){
            for (Command command : COMMANDS){
                if (event.getMessage().getContentRaw().startsWith(PREFIX + command.getName())){
                    command.execution(event);
                }
            }
        }
    }

    public static List<Command> getCommandList()
    {
        return COMMANDS;
    }
}
