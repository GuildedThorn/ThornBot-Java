package com.guildedthorn.thornbot.Commands;

import com.guildedthorn.thornbot.Utils.EmbedUtils;
import tech.xigam.cch.command.Command;
import tech.xigam.cch.utils.Interaction;

public class GithubCommand extends Command {
    
    public GithubCommand() {
        super("github", "See what Thorn's Github looks like.");
    }

    @Override
    public void execute(Interaction interaction) {
        interaction.setEphemeral(false);
        interaction.reply(EmbedUtils.defaultEmbed("ThornBot | Github", "https://github.com/GuildedThorn"));
    }
}
