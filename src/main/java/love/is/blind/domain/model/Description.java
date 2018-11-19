package love.is.blind.domain.model;

import java.util.List;

import lombok.Data;

@Data
public class Description {

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
