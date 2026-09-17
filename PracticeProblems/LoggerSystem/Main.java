import appenders.ConsoleAppender;
import appenders.FileAppender;
import enums.LogLevel;
import formatter.PlainTextFormatter;

public class Main {
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
