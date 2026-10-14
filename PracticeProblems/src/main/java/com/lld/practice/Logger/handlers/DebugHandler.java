package com.lld.practice.Logger.handlers;

import com.lld.practice.Logger.enums.LogLevel;

public class DebugHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.DEBUG;
    }
}
