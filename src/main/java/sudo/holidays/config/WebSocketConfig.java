package sudo.holidays.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import sudo.holidays.handler.SocketHandler;

import java.util.Map;

@Configuration
public class WebSocketConfig {

    @Autowired
    private SocketHandler socketHandler;

    @Bean
    public HandlerMapping handlerMapSocket() {
        Map<String, SocketHandler> handlerMap = Map.of("/socketMapTest", socketHandler);
        return new SimpleUrlHandlerMapping(handlerMap, 1);
    }
}
