package update_feeds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Feed {

	public Channel channel;
	public Integer num_items;
	protected String feed_address;

	// FIXME constructor stub
	public Feed(String address)  {
		feed_address = address;
		channel = new Channel();
		channel.description = "foo";
		channel.name = "bar";
		num_items = 10;
	}

	public void update() throws MalformedURLException, SAXException, IOException {
		// TODO Auto-generated method stub
		// Read the response XML document
	    XMLReader parser = XMLReaderFactory.createXMLReader(
	    	        "org.apache.xerces.parsers.SAXParser"
	    );
		// There's a name conflict with java.net.ContentHandler
		// so we have to use the fully package qualified name.
		ContentHandler handler = new FeedHandler(this);
		parser.setContentHandler(handler);
		
		URL feed_url = new URL(feed_address);
		InputSource source = new InputSource(feed_url.openStream());
		parser.parse(source);
		System.out.println();		
	}

}
