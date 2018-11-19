package love.is.blind.domain.repository;

public interface NowOnAirRepository<T> extends NhkNowRepository {

  public T get(String area, String service);
}
