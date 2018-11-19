package love.is.blind.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import love.is.blind.domain.model.Description;
import love.is.blind.domain.repository.ProgramInfoRepository;
import love.is.blind.infrastructure.remoteapi.client.ProgramInfoApiClient;

@Repository
public class ProgramInfoRepositoryImpl implements ProgramInfoRepository<Description> {

  @Autowired
  private ProgramInfoApiClient programInfoApiClient;

  @Override
  public Description get(String area, String service, String id) {

    return programInfoApiClient.get(area, service, id).getList().get(service).get(0);
  }
}
