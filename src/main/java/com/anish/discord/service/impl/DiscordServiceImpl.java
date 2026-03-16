package com.anish.discord.service.impl;

import com.anish.discord.config.properties.DiscordProperties;
import com.anish.discord.dto.NotificationRequestDto;
import com.anish.discord.service.DiscordService;
import com.anish.discord.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.ObjectNode;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiscordServiceImpl implements DiscordService {

    private final ObjectMapper objectMapper;

    private final WebClient webClient;

    private final DiscordProperties discordProperties;

    @Override
    @Async("asyncExecutor")
    public void sendDiscordNotification(NotificationRequestDto request) {
        log.info("Sending message with payload: {}", request);
        JsonNode payload = buildRequest(request);
        sendMessage(payload);
        log.info("Discord notification sent");
    }

    private void sendMessage(JsonNode payload) {
        URI uri = URI.create(discordProperties.url());
        webClient.post()
                .uri(uri)
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(body -> log.info("Response: {}", body))
                .block();

    }

    private JsonNode buildRequest(NotificationRequestDto requestDto) {
        ObjectNode root = objectMapper.createObjectNode();
        root.put(Constants.CommonConstants.USERNAME, discordProperties.chatUser());

        ArrayNode embeds = objectMapper.createArrayNode();
        ObjectNode embed = objectMapper.createObjectNode();

        embed.put(Constants.CommonConstants.TITLE, requestDto.title());
        String messageFormatter = "%s\n\n%s\n\n[%s](%s)";
        String description = messageFormatter.formatted(requestDto.subtitle(),
                requestDto.content(), requestDto.linkText(), requestDto.linkUrl());

        embed.put(Constants.CommonConstants.DESCRIPTION, description);
        embed.put(Constants.CommonConstants.COLOR, 15158332);  // Set a default color (red)

        embeds.add(embed);
        root.set(Constants.CommonConstants.EMBEDS, embeds);
        return root;
    }
}
