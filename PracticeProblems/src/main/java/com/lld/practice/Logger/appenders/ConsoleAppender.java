package com.lld.practice.Logger.appenders;

import com.lld.practice.Logger.formatter.LogFormatter;
import com.lld.practice.Logger.model.LogMessage;

public class ConsoleAppender implements LogAppender {
    private final LogFormatter formatter;

    public ConsoleAppender(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(LogMessage message) {
        System.out.println(formatter.format(message));
    }
}
