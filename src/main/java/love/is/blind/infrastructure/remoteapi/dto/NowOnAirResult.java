package love.is.blind.infrastructure.remoteapi.dto;

import java.util.Map;

import lombok.Data;
import love.is.blind.domain.model.NowOnAir;

@Data
public class NowOnAirResult {

  private Map<String, NowOnAir> nowonair_list;
}
