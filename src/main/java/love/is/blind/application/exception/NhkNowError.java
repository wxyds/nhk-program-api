package love.is.blind.application.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum NhkNowError {

  RESOURCE_NOT_FOUND("Not found anything matching the request URI."),

  NHK_NOW_ERROR("Internal error occurred.");

  @Getter
  private String message;
}
