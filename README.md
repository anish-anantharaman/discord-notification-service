# Discord Notification Service

## Overview

Discord Notification Service allows applications to send notifications to Discord servers with webhook URL.
The service is exposes REST endpoint built with Spring Boot, uses Jakarta Bean Validation for request validation 
and is fully integrates with Springdoc OpenAPI to automatically generate Swagger UI documentation.

## The service provides
- Structured and validated payloads
- Clear success/failure response models
- API documentation with Swagger

<br />
<br />

## Getting Started

⚠️ Note: You need to create an incoming webhook in Discord server to get started.
Check their official documentation [here](https://support.discord.com/hc/en-us/articles/228383668-Intro-to-Webhooks).
You can also check out this [YouTube link](https://www.youtube.com/watch?v=CHmjprU4Zck).

### 1. Running Locally

#### Prerequisites
- Java 25
- Maven 3.9+
- Discord account


#### Configuration

Before running the application, set the environment variables DISCORD_WEBHOOK_URL and CHAT_USER (this is the username 
that will appear when you send messages to the Discord server).


```bash
export CHAT_USER="${CHAT_USER}"
export DISCORD_WEBHOOK_URL="${DISCORD_WEBHOOK_URL}"
```

#### Steps

```bash
# Clone the repo
git clone -b main https://github.com/anish-anantharaman/discord-notification-service.git

# Build the project
mvn clean install

# Run the unit and integration tests (Optional)
> Currently, the application does not include any automated tests.  
> You can add your own unit or integration tests as needed, and then run:
mvn test

# Run the application
mvn spring-boot:run
```

### 2. Running with Docker (Optional)

For a quick start without building locally, you can use Docker. No tests are included in this Docker build.

```bash
# Build Docker image
docker build -t discord-notification-service .

# Run the container with the environment variables
docker run \
-e DISCORD_WEBHOOK_URL="${DISCORD_WEBHOOK_URL}" \
-e CHAT_USER="${CHAT_USER}" \  
-p 8080:8080 discord-notification-service
```

This is useful if you want to start the service quickly without installing Java or Maven locally.

### 3. Sending a Test Message

Once the service is running, you can send a test notification using the curl command below:

```bash
curl --location 'http://localhost:8080/api/v1/notifications' \
--header 'Content-Type: application/json' \
--data '{
  "title": "Server Down",
  "subtitle": "Production Alert",
  "content": "The production server is down since 2 PM",
  "linkText": "View more",
  "linkUrl": "https://www.google.com"
}'
```

### 4. Swagger API Documentation

Once the application is running, open your browser to:

http://localhost:8080/swagger-ui/index.html#/Notifications/sendDiscordNotification

<br />
<br />

## Contributing

This project is open for suggestions, improvements, and PRs.
Feel free to fork the repo, make changes, and submit a PR. Your contributions are welcome!