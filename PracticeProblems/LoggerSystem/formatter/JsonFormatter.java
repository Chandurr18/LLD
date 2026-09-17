package formatter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import model.LogMessage;

public class JsonFormatter implements LogFormatter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogMessage message) {
        String formattedTime = LocalDateTime
                .ofInstant(Instant.ofEpochMilli(message.getTimeStamp()), ZoneId.systemDefault()).format(FORMATTER);

        return String.format("{\"timestamp\": %s, \"level\": %s, \"message\": %s}", formattedTime,
                message.getLogLevel(), message.getMessgage());
    }
}
