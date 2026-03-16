package com.anish.discord.service;

import com.anish.discord.dto.NotificationRequestDto;

public interface DiscordService {

    void sendDiscordNotification(NotificationRequestDto request);
}
