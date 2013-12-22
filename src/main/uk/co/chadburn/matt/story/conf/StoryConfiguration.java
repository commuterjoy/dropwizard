package uk.co.chadburn.matt.story.conf;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class StoryConfiguration extends Configuration {

  @JsonProperty
  public Boolean testing;
}
