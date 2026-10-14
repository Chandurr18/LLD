package com.lld.practice.Logger.formatter;

import com.lld.practice.Logger.model.LogMessage;

public interface LogFormatter {
    String format(LogMessage message);
}
