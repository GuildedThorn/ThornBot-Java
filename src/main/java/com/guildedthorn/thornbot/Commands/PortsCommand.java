package com.guildedthorn.thornbot.Commands;

import com.guildedthorn.thornbot.Utils.EmbedUtils;
import net.dv8tion.jda.api.entities.MessageEmbed;
import tech.xigam.cch.command.Command;
import tech.xigam.cch.utils.Interaction;

public class PortsCommand extends Command {
    
    public PortsCommand() {
        super("ports", "see what ports thorn is forwarding and what they are used for.");
    }

    @Override
    public void execute(Interaction interaction) {
        interaction.reply(EmbedUtils.defaultEmbedWithField("ThornBot | Ports", "A list of thorn's used ports", 
                new MessageEmbed.Field("Ports", """
                        ```
                        Kali Linux SSH/SFTP:22\s
                        Kali Linux RDP:3389\s
                        Network Area Storage:21\s
                        Teamspeak UDP:9987\s
                        Teamspeak TCP:30033\s
                        HTTP:80\s
                        HTTPS:443\s
                        ```""", false)));
    }
}
