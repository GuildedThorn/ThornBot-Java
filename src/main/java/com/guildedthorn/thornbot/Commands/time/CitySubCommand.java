package com.guildedthorn.thornbot.Commands.time;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import tech.xigam.cch.command.Arguments;
import tech.xigam.cch.command.SubCommand;
import tech.xigam.cch.utils.Argument;
import tech.xigam.cch.utils.Interaction;

import java.util.Collection;
import java.util.List;

public final class CitySubCommand extends SubCommand implements Arguments {

    public CitySubCommand() {
        super("city", "Displays information about a specific city's time.");
    }
    
    @Override
    public void execute(Interaction interaction) {
        var city = interaction.getArgument("city", String.class);
        interaction.reply("getting city: " + city);
    }

    @Override
    public Collection<Argument> getArguments() {
        return List.of(
          Argument.create("city", "The city to get the time of.", "city", OptionType.STRING, true, 0)      
        );
    }
}
