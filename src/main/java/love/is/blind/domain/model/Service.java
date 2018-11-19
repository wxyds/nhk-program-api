package love.is.blind.domain.model;

import lombok.Data;

@Data
public class Service {

  private String id;

  private String name;

  private Logo logo_s;

  private Logo logo_m;

  private Logo logo_l;
}
