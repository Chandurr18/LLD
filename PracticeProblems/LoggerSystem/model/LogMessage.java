package model;

import enums.LogLevel;

public class LogMessage {
    private LogLevel loglevel;
    private String message;
    private long timestamp;

    public LogMessage(LogLevel loglevel, String message, long timestamp) {
        this.loglevel = loglevel;
        this.message = message;
        this.timestamp = timestamp;
    }

    public LogLevel getLogLevel() {
        return loglevel;
    }

    public String getMessgage() {
        return message;
    }

    public long getTimeStamp() {
        return timestamp;
    }
}
