package update_feeds;

import java.io.IOException;
import java.net.MalformedURLException;

import org.xml.sax.SAXException;

public class Updater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String test_uri = "http://feeds.feedburner.com/PoliticalWire";
		Feed test_feed = new Feed(test_uri);
		try {
			test_feed.update();
			System.out.println("Channel Name: "+test_feed.channel.name);
			System.out.println("Description: "+test_feed.channel.description);
			System.out.println("Number of items: " + test_feed.num_items);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
