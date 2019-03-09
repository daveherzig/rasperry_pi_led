package ch.fhnw;

import ch.fhnw.model.Information;
import ch.fhnw.util.BGThread;
import ch.fhnw.util.TSUtil;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author David Herzig
 */

@WebServlet(
        name = "addtimestampservlet",
        		urlPatterns = {"/AddTimestamp", "/startApp"}
)
public class AddTimestampServlet extends HttpServlet {
    
	private static final Logger LOG = LogManager.getLogger(AddTimestampServlet.class);
	
    private TimeService tService = new TimeService();
    private BGThread bgThread = new BGThread(tService);
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	LOG.info("Retrieved call from: " + req.getRemoteAddr());
    	
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        String hour = req.getParameter("hour");
        String minute = req.getParameter("minute");
        String second = req.getParameter("second");
        
        if (year != null && year.trim().isEmpty()) {
        	LOG.warn("Wrong Date proived");
        	
        	return;
        }
        
        LOG.info("Time added: " + year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
        
        long ts = TSUtil.getTimeStamp(year, month, day, hour, minute, second);
        if (ts != -1) {
        	tService.addTSEntry(ts);
        	
        	if (!bgThread.isAlive()) {
        		System.out.println("starting thread...");
        		bgThread.start();
        	}
        }
        
        List<Information> allTimestamps = tService.getTSEntries();

        req.setAttribute("timestamps", allTimestamps);
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);
    }
}
