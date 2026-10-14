package com.lld.practice.Logger;

import com.lld.practice.Logger.enums.LogLevel;
import com.lld.practice.Logger.handlers.LogHandler;
import com.lld.practice.Logger.model.LogMessage;

public enum Logger {
    INSTANCE;

    private final LogHandler handlerChain;

    private Logger() {
        handlerChain = LogHandlerConfiguration.build();
    }

    public void log(LogLevel level, String message) {
        LogMessage msg = new LogMessage(level, message, System.currentTimeMillis());
        handlerChain.handle(msg);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }

}
