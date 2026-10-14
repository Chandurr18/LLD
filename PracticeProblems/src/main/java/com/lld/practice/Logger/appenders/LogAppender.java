package com.lld.practice.Logger.appenders;

import com.lld.practice.Logger.model.LogMessage;

public interface LogAppender {
    void append(LogMessage message);
}
