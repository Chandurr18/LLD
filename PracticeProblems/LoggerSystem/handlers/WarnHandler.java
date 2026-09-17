package handlers;

import enums.LogLevel;

public class WarnHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.WARN;
    }
}
