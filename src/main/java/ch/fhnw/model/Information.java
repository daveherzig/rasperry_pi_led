package ch.fhnw.model;

/**
 * Daten, welche vom Anwender eingegeben werden.
 * @author David Herzig
 */
public class Information {
    private long timestamp;
    
    /**
     * Setter Methode um timestamp zu setzen.
     * @param timestamp
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
     * Getter Methode um timestamp auszugeben.
     * @return
     */
    public long getTimestamp() {
        return this.timestamp;
    }
}
