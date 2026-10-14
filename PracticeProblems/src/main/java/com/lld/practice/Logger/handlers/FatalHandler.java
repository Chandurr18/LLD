package com.lld.practice.Logger.handlers;

import com.lld.practice.Logger.enums.LogLevel;

public class FatalHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.FATAL;
    }
}
