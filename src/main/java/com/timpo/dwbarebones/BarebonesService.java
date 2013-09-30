package com.timpo.dwbarebones;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.timpo.dwbarebones.conf.BarebonesConfiguration;
import com.timpo.dwbarebones.resources.BarebonesResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class BarebonesService extends Service<BarebonesConfiguration> {

  public static void main(String[] args) throws Exception {
    new BarebonesService().run(args);
  }

  @Override
  public void initialize(Bootstrap<BarebonesConfiguration> bootstrap) {
  }

  @Override
  public void run(BarebonesConfiguration config, Environment env) throws Exception {
    env.addResource(new BarebonesResource());

    if (config.testing != null && config.testing) {
      //turn on json pretty printing
      env.getObjectMapperFactory().enable(SerializationFeature.INDENT_OUTPUT);
    }
  }
}
