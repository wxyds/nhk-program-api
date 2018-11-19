package love.is.blind.domain.repository;

public interface ProgramInfoRepository<T> extends NhkNowRepository {

  public T get(String area, String service, String id);
}
