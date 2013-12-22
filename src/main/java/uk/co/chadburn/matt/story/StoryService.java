package uk.co.chadburn.matt.story;

import com.fasterxml.jackson.databind.SerializationFeature;
import uk.co.chadburn.matt.story.conf.StoryConfiguration;
import uk.co.chadburn.matt.story.resources.StoryResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import java.util.Map;
import javax.ws.rs.core.MediaType;

public class StoryService extends Service<StoryConfiguration> {

  public static void main(String[] args) throws Exception {
    new StoryService().run(args);
  }

  @Override
  public void initialize(Bootstrap<StoryConfiguration> bootstrap) {
  }

  @Override
  public void run(StoryConfiguration config, Environment env) throws Exception {
    Map<String, MediaType> mediaTypeMap = env.getJerseyResourceConfig().getMediaTypeMappings();
    mediaTypeMap.put("json", MediaType.APPLICATION_JSON_TYPE);
    mediaTypeMap.put("xml", MediaType.APPLICATION_XML_TYPE);

/*    String responseEntity = ClientBuilder.newClient()
            .target("http://content.guardianapis.com").path("search")
                        .request().get(String.class);
*/
    if (config.testing != null && config.testing) {
      //turn on json pretty printing
      env.getObjectMapperFactory().enable(SerializationFeature.INDENT_OUTPUT);
    }

    env.addResource(new StoryResource());
  }
}
