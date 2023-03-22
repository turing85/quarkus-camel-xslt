package de.turing85;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.platformHttp;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.HttpMethod;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class Route extends RouteBuilder {
  private final MyProcessor myProcessor;

  public Route(MyProcessor myProcessor) {
    this.myProcessor = myProcessor;
  }

  @Override
  public void configure() {
    from(platformHttp("/hello").httpMethodRestrict(HttpMethod.POST))
        .process(myProcessor);
  }
}
