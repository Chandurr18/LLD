package com.lld.practice.Logger.formatter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.lld.practice.Logger.model.LogMessage;

public class PlainTextFormatter implements LogFormatter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogMessage message) {
        String formattedTime = LocalDateTime
                .ofInstant(Instant.ofEpochMilli(message.getTimeStamp()), ZoneId.systemDefault()).format(FORMATTER);

        return String.format("%s [%s] - %s", formattedTime, message.getLogLevel(), message.getMessgage());
    }

}
