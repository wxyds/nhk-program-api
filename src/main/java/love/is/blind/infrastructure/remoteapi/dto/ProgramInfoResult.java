package love.is.blind.infrastructure.remoteapi.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;
import love.is.blind.domain.model.Description;

@Data
public class ProgramInfoResult {

  private Map<String, List<Description>> list;
}
