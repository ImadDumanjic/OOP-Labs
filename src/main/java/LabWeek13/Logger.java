package LabWeek13;

public class Logger{
    private static Logger instance;

    private Logger(){}

    public static Logger getInstance(){
        if(instance == null){
            synchronized(Logger.class){
                if(instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    public void logInfo(String message) {
        System.out.println("INFO: " + message);
    }

    public void logWarning(String message) {
        System.out.println("WARNING: " + message);
    }

    public void logError(String message) {
        System.err.println("ERROR: " + message);
    }
}

class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Application started");

        logger.logInfo("User logged in successfully");

        logger.logWarning("Disk space is running low");

        logger.logError("An unexpected error occurred while processing data");

        Logger anotherLogger = Logger.getInstance();
        if (logger == anotherLogger) {
            logger.log("The same Logger instance is being used");
        }
    }
}
