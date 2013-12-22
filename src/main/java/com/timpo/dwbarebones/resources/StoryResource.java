package com.timpo.dwbarebones.resources;

import java.util.Arrays;
import java.util.List;

import com.timpo.dwbarebones.models.Story;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;

@Path("/")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML})
public class StoryResource {

  //public Response index(@QueryParam("name") Optional<String> name) {
  
  @GET
  @Timed
  public List<Story> index(@QueryParam("name") Optional<String> name) {
    CacheControl cache = new CacheControl();
    cache.setMaxAge(600);
    //return Response.ok().cacheControl(cache).build();
    return Arrays.asList(new Story("R v Grillo and Grillo",
                "http://en.wikipedia.org/wiki/R_v_Grillo_and_Grillo"));
  }
}
