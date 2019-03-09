package ch.fhnw.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebPageTest {

	@Test
	public void testPage() throws Exception {
		final WebClient client = new WebClient();
		final HtmlPage page = (HtmlPage)client.getPage("https://web.ics.purdue.edu/~gchopra/class/public/pages/webdesign/05_simple.html");
		assertEquals("A very simple webpage", page.getTitleText());
	}
	
}
