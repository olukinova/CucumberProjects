package Utils;


import org.apache.log4j.*;

public class Log {

    public static Logger log = Logger.getLogger(Log.class.getName());

// When the test starts I should print the logs
    // When my test case stops I Should print the log
    // If I want to print a message in between I should print hte logs

    public static void startTestCase(String testCaseName) {
        log.info("*********************");
        log.info("*********************");
        log.info("***********" + testCaseName + "***********");
    }

    public static void endTestCase(String testCaseName) {
        log.info("#####################");
        log.info("#####################");
        log.info("###########" + testCaseName + "###########");
    }

    public static void info(String message) {
        log.info(message);
    }

    public static void warning(String warning) {
        log.info(warning);
    }
}