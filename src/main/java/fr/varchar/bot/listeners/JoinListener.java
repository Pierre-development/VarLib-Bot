package fr.varchar.bot.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JoinListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        event.getGuild().addRoleToMember(event.getMember().getId(), event.getGuild().getRoleById("846385800253538336")).queue();
        if (!event.getUser().isBot()) {
            final EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setThumbnail(event.getUser().getAvatarUrl() == null ? event.getUser().getDefaultAvatarUrl() : event.getUser().getAvatarUrl());
            embedBuilder.setTitle("Bienvenue \u00E0 " + event.getUser().getName());
            embedBuilder.setColor(Color.GREEN);
            embedBuilder.addField("Merci d'avoir rejoint et de faire grandir la communaut\u00E9 <3", "", false);
            embedBuilder.setFooter("VarLib | " + new SimpleDateFormat("'le' dd/MM/yyyy '\u00E0' kk:mm:ss").format(new Date()));
            event.getGuild().getTextChannelById("848583669371502642").sendMessage(embedBuilder.build()).queue();
        }
    }
}
