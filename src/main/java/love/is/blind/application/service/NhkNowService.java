package love.is.blind.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import love.is.blind.domain.model.Description;
import love.is.blind.domain.model.NowOnAir;
import love.is.blind.domain.repository.NowOnAirRepository;
import love.is.blind.domain.repository.ProgramInfoRepository;

@Service
public class NhkNowService {

  @Autowired
  private NowOnAirRepository<NowOnAir> NowOnAirRepositoryImpl;

  @Autowired
  private ProgramInfoRepository<Description> ProgramInfoRepositoryImpl;

  public Description get(String area, String service) {

    String nowId = NowOnAirRepositoryImpl.get(area, service).getPresent().getId();

    return ProgramInfoRepositoryImpl.get(area, service, nowId);
  }
}
