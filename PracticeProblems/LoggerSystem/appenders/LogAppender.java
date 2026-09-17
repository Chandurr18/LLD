package appenders;

import model.LogMessage;

public interface LogAppender {
    void append(LogMessage message);
}
