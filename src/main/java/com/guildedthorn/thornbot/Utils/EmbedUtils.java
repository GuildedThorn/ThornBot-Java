package com.guildedthorn.thornbot.Utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.time.OffsetDateTime;

public final class EmbedUtils {
    
    public static MessageEmbed defaultEmbed(String title, String description) {
        return new EmbedBuilder()
                .setTitle(title)
                .setDescription(description)
                .setColor(new Color(32, 42, 68))
                .setTimestamp(OffsetDateTime.now())
                .build();
    }
    
    public static MessageEmbed defaultEmbedWithField(String title, String description, MessageEmbed.Field field) {
        return new EmbedBuilder()
                .setTitle(title)
                .setDescription(description)
                .setColor(new Color(32, 42, 68))
                .addField(field)
                .setTimestamp(OffsetDateTime.now())
                .build();
    }
    
    public static MessageEmbed defaultEmbedWithTwoFields(String title, String description, String field1, String field2) {
        return new EmbedBuilder()
                .setTitle(title)
                .setDescription(description)
                .setColor(new Color(32, 42, 68))
                .setTimestamp(OffsetDateTime.now())
                .addField(field1, field2, false)
                .build();
    }

    public static MessageEmbed defaultEmbedWithThreeFields(String title, String description, MessageEmbed.Field field1, MessageEmbed.Field field2, MessageEmbed.Field field3) {
        return new EmbedBuilder()
                .setTitle(title)
                .setDescription(description)
                .setColor(new Color(32, 42, 68))
                .setTimestamp(OffsetDateTime.now())
                .addField(field1)
                .addField(field2)
                .addField(field3)
                .build();
    }
}
