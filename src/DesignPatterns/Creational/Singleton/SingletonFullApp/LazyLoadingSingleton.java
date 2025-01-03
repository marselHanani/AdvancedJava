package DesignPatterns.Creational.Singleton.SingletonFullApp;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LazyLoadingSingleton {
    private int _infoCount=0;
    private int _ErrorCount=0;
    private int _warningCount=0;
    private LazyLoadingSingleton() {}
    private static class SingletonHolder {
        private static final LazyLoadingSingleton INSTANCE = new LazyLoadingSingleton();
    }
    public static LazyLoadingSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private List<LogMessage> _logs = new ArrayList<>();
    public List<LogMessage> getLogs() {
        return Collections.unmodifiableList(_logs);
    }

    private void Log(String message, LogType logType) {
        _logs.add(new LogMessage(message, logType));
    }
    public void LogInfo(String message) {
        Log(message, LogType.INFO);
        _infoCount++;
    }
    public void LogError(String message) {
        Log(message, LogType.ERROR);
        _ErrorCount++;
    }
    public void LogWarning(String message) {
        Log(message, LogType.WARNING);
        _warningCount++;
    }
    public void ShowLogs() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (LogMessage logMessage : _logs) {
            System.out.println(logMessage.CreatedAt.format(formatter) + " - " + logMessage.logType + " - " + logMessage.message);
        }
        System.out.println("==============================================================");
        System.out.println("Info Count: " + _infoCount + ", Error Count: " + _ErrorCount + ", Warning Count: " + _warningCount);
    }
}
