package ch.fhnw;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.model.Information;

/**
 * Datenablage fuer timestamps
 * @author David Herzig
 */
public class TimeService {
    
    private List<Information> entries = new ArrayList<>();
    
    /**
     * Eintrag hinzufuegen
     * @param timestamp
     */
    public void addTSEntry(long timestamp) {
        Information obj = new Information();
        obj.setTimestamp(timestamp);
        entries.add(obj);
    }
    
    /**
     * Eintrag ausgeben
     * @return
     */
    public List<Information> getTSEntries() {
        return entries;
    }
}
