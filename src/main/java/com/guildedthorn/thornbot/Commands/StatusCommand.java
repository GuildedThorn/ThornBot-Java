package com.guildedthorn.thornbot.Commands;

import com.guildedthorn.thornbot.ThornBot;
import com.guildedthorn.thornbot.Utils.EmbedUtils;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import tech.xigam.cch.command.Arguments;
import tech.xigam.cch.command.Command;
import tech.xigam.cch.utils.Argument;
import tech.xigam.cch.utils.Interaction;

import java.util.Collection;
import java.util.List;

public class StatusCommand extends Command implements Arguments {
    
    public StatusCommand() {
        super("status", "Sets the bot's current status.");
    }

    @Override
    public void execute(Interaction interaction) {
        assert interaction.getMessage() != null;
        if (interaction.getMessage().getAuthor().getId().equals("654849939175768074")) {
            OnlineStatus status = OnlineStatus.fromKey(interaction.getArgument("status", String.class));
            ThornBot.getJDA().getPresence().setStatus(status);
            interaction.reply(EmbedUtils.defaultEmbed("ThornBot | Status", "Set status to: " + interaction.getArgument("status", String.class)));
        }
    }

    @Override
    public Collection<Argument> getArguments() {
        return List.of(
          Argument.createWithChoices("status", "The status you want the bot to be set to.", "status", OptionType.STRING, true, 0, "online", "offline", "dnd", "idle")      
        );
    }
}
