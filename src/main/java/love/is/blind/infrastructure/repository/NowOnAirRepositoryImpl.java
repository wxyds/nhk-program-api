package love.is.blind.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import love.is.blind.domain.model.NowOnAir;
import love.is.blind.domain.repository.NowOnAirRepository;
import love.is.blind.infrastructure.remoteapi.client.NowOnAirApiClient;

@Repository
public class NowOnAirRepositoryImpl implements NowOnAirRepository<NowOnAir> {

  @Autowired
  private NowOnAirApiClient nowOnAirApiClient;

  @Override
  public NowOnAir get(String area, String service) {

    return nowOnAirApiClient.get(area, service).getNowonair_list().get(service);
  }
}
