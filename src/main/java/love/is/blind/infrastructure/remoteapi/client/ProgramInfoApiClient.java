package love.is.blind.infrastructure.remoteapi.client;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import love.is.blind.infrastructure.property.NhkApiProperty;
import love.is.blind.infrastructure.remoteapi.dto.ProgramInfoResult;

@Component
public class ProgramInfoApiClient {

  private static final String PATH = "/info/{area}/{service}/{id}.json";

  private final RestTemplate restTemplate = new RestTemplate();

  @Autowired
  private NhkApiProperty nhkApiProperty;

  public ProgramInfoResult get(String area, String service, String id) {

    Map<String, String> uriParams = new HashMap<String, String>();
    uriParams.put("area", area);
    uriParams.put("service", service);
    uriParams.put("id", id);

    URI uri = UriComponentsBuilder.fromUriString(nhkApiProperty.getBaseUri() + PATH)
        .queryParams(nhkApiProperty.getRequestParams()).buildAndExpand(uriParams).toUri();

    return restTemplate.getForObject(uri, ProgramInfoResult.class);
  }
}
