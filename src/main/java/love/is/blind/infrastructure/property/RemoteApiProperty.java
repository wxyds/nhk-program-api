package love.is.blind.infrastructure.property;

import org.springframework.util.MultiValueMap;

import lombok.Data;

@Data
public abstract class RemoteApiProperty {

  private String baseUri;

  private MultiValueMap<String, String> requestParams;
}
