package com.guildedthorn.thornbot.Commands.time;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import tech.xigam.cch.command.Arguments;
import tech.xigam.cch.command.SubCommand;
import tech.xigam.cch.utils.Argument;
import tech.xigam.cch.utils.Interaction;

import java.util.Collection;
import java.util.List;

public final class UserSubCommand extends SubCommand implements Arguments {
    public UserSubCommand() {
        super("user", "Displays information about a user's time.");
    }

    public void execute(Interaction interaction) {
        var user = interaction.getArgument("user", String.class);
        interaction.reply("getting user: " + user);
    }

    public Collection<Argument> getArguments() {
        return List.of(
                Argument.createWithChoices("user", "The user to get the time of.", "user", OptionType.STRING, true, 0, "magix")
        );
    }
}
