package love.is.blind.domain.model;

import java.util.List;

import lombok.Data;

@Data
public class Program {

  private String id;

  private String event_id;

  private String start_time;

  private String end_time;

  private Area area;

  private Service service;

  private String title;

  private String subtitle;

  private List<String> genres;
}
