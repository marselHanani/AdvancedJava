package DesignPatterns.Creational.Singleton.SingletonFullApp;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryLogger {
    private int _infoCount=0;
    private int _ErrorCount=0;
    private int _warningCount=0;
  //? عملتها برايفت عشان ما بدي حدا يعدل عليها
    private List<LogMessage> _logs = new ArrayList<>();
    //* وهون عملتها هاي الميثود لاني بدي اليوزر يقدرأ يقرأ من هاي الليست فخليتها من نوع قراءة بس
    public List<LogMessage> getLogs() {
        return Collections.unmodifiableList(_logs);
    }
    //- =================================================
    private static MemoryLogger _instance = null ;//create instance with initial value null
    private MemoryLogger(){} // create constructor private
    //*Thread 1 , Thread 2
    public static MemoryLogger getInstance(){ // create static method to initialize instance
        if(_instance == null){ //* Thread 2 reach here and he found instance = null
            //* Thread 1 reach here
            //* so the Thread 1 will create instance and the Thread 2 will Create new instance
            //* and this is the problem because we return to the beginning
            _instance = new MemoryLogger();
        }
         return _instance;
    }
    //-- ================================================
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
