package handlers;

import enums.LogLevel;

public class DebugHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.DEBUG;
    }
}
