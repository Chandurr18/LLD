package com.lld.practice.Logger;

import com.lld.practice.Logger.LogHandlerConfiguration;
import com.lld.practice.Logger.Logger;
import com.lld.practice.Logger.appenders.ConsoleAppender;
import com.lld.practice.Logger.appenders.FileAppender;
import com.lld.practice.Logger.enums.LogLevel;
import com.lld.practice.Logger.formatter.PlainTextFormatter;


public class LoggerClient {
    public static void main(String[] args) {
        Logger logger = Logger.INSTANCE;

        LogHandlerConfiguration.addAppenderForLevel(
                LogLevel.INFO,
                new ConsoleAppender(new PlainTextFormatter()));

        LogHandlerConfiguration.addAppenderForLevel(
                LogLevel.ERROR,
                new ConsoleAppender(new PlainTextFormatter()));
        LogHandlerConfiguration.addAppenderForLevel(
                LogLevel.ERROR,
                new FileAppender(new PlainTextFormatter(), "logs.txt"));

        // usage
        logger.info("This is some information");
        logger.error("Oh no!, this is some error");

    }
}
