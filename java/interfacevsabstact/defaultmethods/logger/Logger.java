
interface Logger {
    void log(String message);

    default void logError(String message) {
        log("ERROR: " + message);
    }
}