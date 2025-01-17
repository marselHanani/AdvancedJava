package DesignPatterns.Creational.Singleton.SingletonFullApp;
import java.time.LocalDateTime;

public class LogMessage {
    public String message;
    public LogType logType;
    public LocalDateTime CreatedAt;
    public LogMessage(String message, LogType logType) {
        this.message = message;
        this.logType = logType;
        CreatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        CreatedAt = LocalDateTime.now();
        return "LogMessage{" +
                "message='" + message + '\'' +
                ", logType=" + logType +
                ", CreatedAt=" + CreatedAt +
                '}';
    }
}
