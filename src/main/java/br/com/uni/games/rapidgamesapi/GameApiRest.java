package br.com.uni.games.rapidgamesapi;

import br.com.uni.games.entity.Game;
import br.com.uni.games.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class GameApiRest {

    @Autowired
    private GameRepository repository;

    /*
     * Chamada para API FreeToPlayGames para popular o banco de dados. 
     */
    @GetMapping("/games")
    public ResponseEntity<?> getGames() {
        String url = "https://free-to-play-games-database.p.rapidapi.com/api/games";

        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "free-to-play-games-database.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "591d9c43e1msh92def5cfaf025a2p1eec64jsndaa0fedca8a9");
        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<GameApi>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<GameApi>>() {
                });

        List<Game> collect = responseEntity.getBody().stream().map((GameApi item) -> {
            Optional<Game> repoGame = repository.findById(item.getId()).stream().findFirst();
            if (repoGame.isEmpty()) {
                return new Game(item.getId(), item.getTitle(), item.getThumbnail(), 0.0, 0);
            } else {
                return repoGame.get();
            }
        }).collect(Collectors.toList());

        repository.saveAll(collect);

        return ResponseEntity.ok(collect);
    }
}
