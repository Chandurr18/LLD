package com.lld.practice.Logger;

import com.lld.practice.Logger.appenders.LogAppender;
import com.lld.practice.Logger.enums.LogLevel;
import com.lld.practice.Logger.handlers.DebugHandler;
import com.lld.practice.Logger.handlers.ErrorHandler;
import com.lld.practice.Logger.handlers.FatalHandler;
import com.lld.practice.Logger.handlers.InfoHandler;
import com.lld.practice.Logger.handlers.LogHandler;
import com.lld.practice.Logger.handlers.WarnHandler;

public class LogHandlerConfiguration {
    private static final LogHandler debug = new DebugHandler();
    private static final LogHandler info = new InfoHandler();
    private static final LogHandler warn = new WarnHandler();
    private static final LogHandler error = new ErrorHandler();
    private static final LogHandler fatal = new FatalHandler();

    public static LogHandler build() {
        debug.setNext(info);
        info.setNext(warn);
        warn.setNext(error);
        error.setNext(fatal);

        return debug;
    }

    public static void addAppenderForLevel(LogLevel level, LogAppender appender) {
        switch (level) {
            case DEBUG -> debug.subscribe(appender);
            case INFO -> info.subscribe(appender);
            case WARN -> warn.subscribe(appender);
            case ERROR -> error.subscribe(appender);
            case FATAL -> fatal.subscribe(appender);
        }
    }
}
