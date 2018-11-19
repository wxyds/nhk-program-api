package love.is.blind.infrastructure.remoteapi.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import love.is.blind.application.exception.NhkNowError;
import love.is.blind.application.exception.NhkNowException;
import love.is.blind.infrastructure.property.NhkApiProperty;
import love.is.blind.infrastructure.remoteapi.dto.NowOnAirResult;

@Component
@Slf4j
public class NowOnAirApiClient {

  private static final String PATH = "/now/{area}/{service}.json";

  private final RestTemplate restTemplate = new RestTemplate();

  @Autowired
  private NhkApiProperty nhkApiProperty;

  public NowOnAirResult get(String area, String service) {

    Map<String, String> uriParams = new HashMap<String, String>();
    uriParams.put("area", area);
    uriParams.put("service", service);

    URI uri = UriComponentsBuilder.fromUriString(nhkApiProperty.getBaseUri() + PATH)
        .queryParams(nhkApiProperty.getRequestParams()).buildAndExpand(uriParams).toUri();

    try {
      return restTemplate.getForObject(uri, NowOnAirResult.class);
    } catch (RestClientResponseException e) {

      if (getNotFoundStatusList().contains(e.getRawStatusCode())) {
        throw new NhkNowException(NhkNowError.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
      }

      log.warn(e.getResponseBodyAsString());
      throw new NhkNowException(NhkNowError.NHK_NOW_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  private List<Integer> getNotFoundStatusList() {

    List<Integer> list = new ArrayList<Integer>();
    list.add(HttpServletResponse.SC_BAD_REQUEST);
    list.add(HttpServletResponse.SC_NOT_FOUND);
    return list;
  }
}
