package com.guildedthorn.thornbot.Commands;

import com.guildedthorn.thornbot.Utils.EmbedUtils;
import net.dv8tion.jda.api.entities.MessageEmbed;
import tech.xigam.cch.command.Command;
import tech.xigam.cch.utils.Interaction;

public class MachinesCommand extends Command {
    
    public MachinesCommand() {
        super("machines", "See what machines Thorn is underpaying.");
    }

    @Override
    public void execute(Interaction interaction) {
        interaction.setEphemeral(false);
        interaction.reply(EmbedUtils.defaultEmbedWithThreeFields("ThornBot | Machines", "See what machines Thorn is underpaying and what they are used for.", 
                new MessageEmbed.Field("Main PC", """
                        ```
                        CPU: Intel i3-6100 @ 3.70Ghz\s
                        RAM: 16gb ddr4-3600mhz corsair vengeance\s
                        Primary SSD: Western Digital 500Gb Sata SSD\s
                        Secondary HDD: Toshiba 1Tb Sata HDD\s
                        GPU: Windforce Geforce GTX 960\s
                        PSU: Corsair vx 550watt\s
                        ```""", true), 
                new MessageEmbed.Field("Kali Linux Laptop", """
                        ```
                        CPU: Intel i7-4720HQ @ 2.60Ghz\s
                        RAM: 16gb ddr3-1600mhz samsung\s
                        Primary SSD: 265gb m-sata SSD\s
                        GPU: Geforce GTX 960m\s
                        ```""", true), 
                new MessageEmbed.Field("Phones / Other Machines", """
                        ```
                        Samsung s9+\s
                        Samsung Tab S5e\s
                        1Tb ps4 slim\s
                        Canon Printer\s
                        NAS Cloud Storage
                        ```""", false)));
    }
}
