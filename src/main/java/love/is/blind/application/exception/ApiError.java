package love.is.blind.application.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiError implements Serializable {

  private NhkNowError error;
}
