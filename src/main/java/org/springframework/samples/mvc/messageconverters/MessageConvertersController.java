package org.springframework.samples.mvc.messageconverters;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.rss.Channel;

@Controller
@RequestMapping("messageconverters/*")
public class MessageConvertersController {

	// StringHttpMessageConverter 

	@RequestMapping(value="/string", method=RequestMethod.POST)
	public @ResponseBody String readString(@RequestBody String string) {
		return "Read string '" + string + "'";
	}
	
	@RequestMapping(value="/string", method=RequestMethod.GET)
	public @ResponseBody String writeString() {
		return "Wrote a string";
	}

	// FormHttpMessageConverter (note: not recommended for reading browser form posts.  Use standard JavaBean form binding instead. see 'form' showcase/package).
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public @ResponseBody String readForm(@RequestBody MultiValueMap<String, String> form) {
		return "Read form map " + form;
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public @ResponseBody MultiValueMap<String, String> writeForm() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("foo", "bar");
		map.add("fruit", "apple");
		return map;
	}

	// Jaxb2RootElementHttpMessageConverter (requires JAXB2 on the classpath - useful for serving clients that expect to work with XML)
	
	@RequestMapping(value="/xml", method=RequestMethod.POST)
	public @ResponseBody String readXml(@RequestBody JavaBean bean) {
		return "Read from XML " + bean;
	}
	
	@RequestMapping(value="/xml", method=RequestMethod.GET)
	public @ResponseBody JavaBean writeXml() {
		return new JavaBean();
	}

	// MappingJacksonHttpMessageConverter (requires Jackson on the classpath - particularly useful for serving JavaScript clients that expect to work with JSON)
	
	@RequestMapping(value="/json", method=RequestMethod.POST)
	public @ResponseBody String readJson(@RequestBody JavaBean bean) {
		return "Read from JSON " + bean;
	}
	
	@RequestMapping(value="/json", method=RequestMethod.GET)
	public @ResponseBody JavaBean writeJson() {
		return new JavaBean();
	}

	// AtomFeedHttpMessageConverter (requires Rome on the classpath - useful for serving Atom feeds)
	
	@RequestMapping(value="/atom", method=RequestMethod.POST)
	public @ResponseBody String readFeed(@RequestBody Feed feed) {
		return "Read " + feed.getTitle();
	}
	
	@RequestMapping(value="/atom", method=RequestMethod.GET)
	public @ResponseBody Feed writeFeed() {
		Feed feed = new Feed();
		feed.setFeedType("atom_1.0");
		feed.setTitle("My Atom feed");
		return feed;
	}

	// RssChannelHttpMessageConverter (requires Rome on the classpath - useful for serving RSS feeds)
	
	@RequestMapping(value="/rss", method=RequestMethod.POST)
	public @ResponseBody String readChannel(@RequestBody Channel channel) {
		return "Read " + channel.getTitle();
	}
	
	@RequestMapping(value="/rss", method=RequestMethod.GET)
	public @ResponseBody Channel writeChannel() {
		Channel channel = new Channel();
		channel.setFeedType("rss_2.0");
		channel.setTitle("My RSS feed");
		channel.setDescription("Description");
		channel.setLink("http://localhost:8080/mvc-showcase/rss");
		return channel;
	}

}