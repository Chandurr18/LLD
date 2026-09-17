package handlers;

import enums.LogLevel;

public class FatalHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.FATAL;
    }
}
