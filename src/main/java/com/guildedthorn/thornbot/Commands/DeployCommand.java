package com.guildedthorn.thornbot.Commands;

import com.guildedthorn.thornbot.ThornBot;
import com.guildedthorn.thornbot.Utils.EmbedUtils;
import tech.xigam.cch.command.Command;
import tech.xigam.cch.utils.Interaction;

public class DeployCommand extends Command {
    
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

        interaction.reply(EmbedUtils.defaultEmbed("ThornBot | Deploy", "Attempting to deploy slash-commands..."));
        ThornBot.getCommandHandler().deployAll(interaction.getGuild());
    }
}