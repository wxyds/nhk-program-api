package love.is.blind.presentation.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import love.is.blind.application.exception.ApiError;
import love.is.blind.application.exception.NhkNowError;

@RestController
public class NhkNowErrorController implements ErrorController {

  @RequestMapping("/error")
  public ResponseEntity<ApiError> handleError() {
    return new ResponseEntity<ApiError>(new ApiError(NhkNowError.RESOURCE_NOT_FOUND), HttpStatus.NOT_FOUND);
  }

  @Override
  public String getErrorPath() {
    return "/error";
  }
}
