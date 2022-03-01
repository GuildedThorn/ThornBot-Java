package com.guildedthorn.thornbot.Commands;

import com.guildedthorn.thornbot.ThornBot;
import com.guildedthorn.thornbot.Utils.EmbedUtils;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import tech.xigam.cch.command.Arguments;
import tech.xigam.cch.command.Command;
import tech.xigam.cch.utils.Argument;
import tech.xigam.cch.utils.Interaction;

import java.util.Collection;
import java.util.List;

public class DeployCommand extends Command implements Arguments {
    
    public DeployCommand() {
        super("deploy", "Deploys slash-commands to this guild.");
    }

    @Override
    public void execute(Interaction interaction) {
        interaction.setEphemeral(false);
        if(!interaction.getMember().getId().matches("654849939175768074")) {
            interaction.reply(EmbedUtils.defaultEmbed("ThornBot | Deploy", "You cannot deploy slash-commands."));
            return;
        }
       
        boolean isGlobal = interaction.getArgument("global", false, Boolean.class);
        ThornBot.getCommandHandler().deployAll( isGlobal ? null : interaction.getGuild());
        interaction.reply(EmbedUtils.defaultEmbed("ThornBot | Deploy", "Deployed slash commands."));
    }

    @Override
    public Collection<Argument> getArguments() {
        return List.of(
           Argument.createWithChoices("type", "The type of slash command you want to deploy.", "type", OptionType.STRING, true, 0, "global", "guild")
        );
    }
}