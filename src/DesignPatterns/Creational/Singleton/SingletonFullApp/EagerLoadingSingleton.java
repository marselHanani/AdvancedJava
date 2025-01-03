package DesignPatterns.Creational.Singleton.SingletonFullApp;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EagerLoadingSingleton {
    private int _infoCount=0;
    private int _ErrorCount=0;
    private int _warningCount=0;
    private static final EagerLoadingSingleton instance = new EagerLoadingSingleton();
    private EagerLoadingSingleton(){}
    public static EagerLoadingSingleton getInstance(){
        return instance;
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
