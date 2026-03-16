package com.anish.discord.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "discord.webhook")
public record DiscordProperties(
        String chatUser,
        String url
) { }
