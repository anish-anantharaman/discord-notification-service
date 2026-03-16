package com.anish.discord.util;

public class Constants {

    private Constants() { }

    public static final class CommonConstants {

        private CommonConstants() { }


        public static final String REQUEST_ID_HEADER = "X-Request-Id";
        public static final String REQUEST_ID = "requestId";
        public static final String USERNAME = "username";
        public static final String EMBEDS = "embeds";
        public static final String COLOR = "color";
        public static final String DESCRIPTION = "description";
        public static final String TITLE = "title";
    }

    public static final class SwaggerDocExamples {

        private SwaggerDocExamples() { }

        public static final String SUCCESS = """
                        {
                          "statusCode": 202,
                          "statusMessage": "Accepted",
                          "message": "Notification queued successfully",
                          "data": true
                        }
                """;

        public static final String BAD_REQUEST = """
                        {
                          "statusCode": 400,
                          "statusMessage": "Bad Request",
                          "message": "title : must not be blank; ",
                          "data": false
                        }
                """;

        public static final String INTERNAL_SERVER_ERROR = """
                        {
                          "statusCode": 500,
                          "statusMessage": "Internal Server Error",
                          "message": "Failed to queue the notification",
                          "data": false
                        }
                """;
    }
}
