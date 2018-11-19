package love.is.blind.presentation.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import love.is.blind.application.service.NhkNowService;
import love.is.blind.presentation.dto.NhkNowResponse;

@RestController
public class NhkNowController {

  @Autowired
  private NhkNowService nhkNowService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping(path = "/nhk/now/{area:\\d{3}}/{service:[0-9a-z]{2}}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> get(@PathVariable("area") String area, @PathVariable("service") String service) {

    return ResponseEntity.ok(modelMapper.map(nhkNowService.get(area, service), NhkNowResponse.class));
  }
}
