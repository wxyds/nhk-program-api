package love.is.blind.infrastructure.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "nhk")
public class NhkApiProperty extends RemoteApiProperty {
}
