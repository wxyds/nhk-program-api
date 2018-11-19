package love.is.blind.domain.model;

import lombok.Data;

@Data
public class NowOnAir {

  private Program previous;

  private Program present;

  private Program following;
}
