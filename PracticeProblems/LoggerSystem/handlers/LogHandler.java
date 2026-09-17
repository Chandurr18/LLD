package handlers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import appenders.LogAppender;
import enums.LogLevel;
import model.LogMessage;

public abstract class LogHandler {
    protected LogHandler next;
    protected final List<LogAppender> appenders = new CopyOnWriteArrayList<>(); // for multithreaded environment

    public void setNext(LogHandler next) {
        this.next = next;
    }

    public void subscribe(LogAppender observer) {
        appenders.add(observer);
    }

    public void notifyObservers(LogMessage message) {
        for (LogAppender appender : appenders) {
            appender.append(message);
        }
    }

    public void handle(LogMessage message) {
        if (canHandle(message.getLogLevel())) {
            notifyObservers(message);
        } else if (next != null) {
            next.handle(message);
        }
    }

    protected abstract boolean canHandle(LogLevel level);
}
