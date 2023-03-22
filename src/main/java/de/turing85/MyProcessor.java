package de.turing85;

import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;

@ApplicationScoped
public class MyProcessor implements Processor {
  @Override
  public void process(Exchange exchange) throws Exception {
    Document body = exchange.getIn().getBody(Document.class);
    String relevantText = XPathAPI.eval(body, "/body/relevant-text").toString();
    exchange.getIn().setBody(relevantText);
  }
}
