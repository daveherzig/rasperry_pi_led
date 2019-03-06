package ch.fhnw;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.model.Information;

/**
 * @author David Herzig
 */
public class TimeService {
    
    private List<Information> entries = new ArrayList<>();
    
    public void addTSEntry(long timestamp) {
        Information obj = new Information();
        obj.setTimestamp(timestamp);
        entries.add(obj);
    }
    
    public List<Information> getTSEntries() {
        return entries;
    }
}
