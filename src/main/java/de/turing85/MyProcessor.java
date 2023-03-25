package de.turing85;

import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@ApplicationScoped
public class MyProcessor implements Processor {
  @Override
  public void process(Exchange exchange) {
    String relevantText = exchange.getProperty("relevantText", String.class);
    exchange.getIn().setBody(relevantText);
  }
}
