package com.guildedthorn.thornbot;

import com.guildedthorn.thornbot.Commands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import tech.xigam.cch.ComplexCommandHandler;
import java.util.EnumSet;

public class ThornBot {

    private static JDA jda;
    private static final ComplexCommandHandler commandHandler = new ComplexCommandHandler(true);
    
    public static void main(String[] args)  {
        try {
            commandHandler.setPrefix("tb!")
                    .registerCommand(new DeployCommand())
                    .registerCommand(new StatusCommand())
                    .registerCommand(new PortsCommand())
                    .registerCommand(new GithubCommand())
                    .registerCommand(new MachinesCommand());
            jda = JDABuilder.create("", EnumSet.allOf(GatewayIntent.class))
                    .addEventListeners(commandHandler)
                    .setActivity(Activity.watching("Thorn's Apartment"))
                    .setAutoReconnect(true)
                    .build();
            commandHandler.setJda(jda);
        } catch (Exception ignored) {}
    }
    
    public static JDA getJDA() {
        return jda;
    }
    
    public static ComplexCommandHandler getCommandHandler() {
        return commandHandler;
    }
}
