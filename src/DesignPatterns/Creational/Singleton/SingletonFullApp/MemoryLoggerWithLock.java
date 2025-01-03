package DesignPatterns.Creational.Singleton.SingletonFullApp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MemoryLoggerWithLock {
    private int _infoCount=0;
    private int _ErrorCount=0;
    private int _warningCount=0;
    private static MemoryLoggerWithLock _instance = null ;
    private static final ReentrantLock lock = new ReentrantLock();
//! the ReentrantLock is a method that is used to create a lock from Lock library
    private MemoryLoggerWithLock(){}
    public static MemoryLoggerWithLock getInstance(){
         //* Thread 2
            lock.lock(); //* the Thread 2 will wait here until the Thread 1 release the lock
            try {
                if (_instance == null) { //* thread 1
                    _instance = new MemoryLoggerWithLock();
                }
            } finally {
                lock.unlock();
            }
        return _instance;
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
