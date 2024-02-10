package sudo.holidays.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Mono;
import sudo.holidays.dto.SocketDTO;

import java.net.URI;
import java.time.Duration;

@Service
public class SocketService {

    public void comunicarChegada(SocketDTO info) {

        WebSocketClient client = new ReactorNettyWebSocketClient();

        client.execute(
                URI.create("ws://localhost:8080/socketMapTest"),
                session -> session.send(
                        Mono.just(session.textMessage("A mensagem Chegou. " +
                                "\n socketid: " + info.id() +
                                "\n socketname: " + info.name())))
                                .thenMany(session.receive()
                                        .map(WebSocketMessage::getPayloadAsText)
                                        .log())
                                .then())
                        .block(Duration.ofSeconds(10L));
    }
}
