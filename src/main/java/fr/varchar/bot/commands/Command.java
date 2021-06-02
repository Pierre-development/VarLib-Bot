package fr.varchar.bot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class Command
{
    private final String name;
    private final String description;

    public Command(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public abstract void execution(MessageReceivedEvent event);


    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }


}