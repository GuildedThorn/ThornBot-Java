package com.guildedthorn.thornbot.Commands;

import com.guildedthorn.thornbot.Commands.time.UserSubCommand;
import tech.xigam.cch.command.Baseless;
import tech.xigam.cch.command.Command;
import tech.xigam.cch.utils.Interaction;

public final class TimeCommand extends Command  implements Baseless {
    
    public TimeCommand() {
        super("time", "Find a time in the server by user or city.");
        
        registerSubCommand(new UserSubCommand());
    }

    public void execute(Interaction interaction) {
        interaction.reply("Do `/time help` for more info.");
    }
}
