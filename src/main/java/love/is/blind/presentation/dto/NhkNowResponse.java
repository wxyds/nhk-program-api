package love.is.blind.presentation.dto;

import java.util.List;

import lombok.Data;
import love.is.blind.domain.model.Area;
import love.is.blind.domain.model.Extra;
import love.is.blind.domain.model.Logo;
import love.is.blind.domain.model.Service;

@Data
public class NhkNowResponse {

  private String id;

  private String event_id;

  private String start_time;

  private String end_time;

  private Area area;

  private Service service;

  private String title;

  private String subtitle;

  private String content;

  private String act;

  private List<String> genres;

  private Logo program_logo;

  private String program_url;

  private String episode_url;

  private List<String> hashtags;

  private Extra extras;
}
