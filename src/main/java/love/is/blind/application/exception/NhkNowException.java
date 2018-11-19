package love.is.blind.application.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class NhkNowException extends RuntimeException {

  @Getter
  private NhkNowError error;

  @Getter
  private HttpStatus status;

  public NhkNowException(NhkNowError error, HttpStatus status) {

    super(error.getMessage());
    this.error = error;
    this.status = status;
  }
}
