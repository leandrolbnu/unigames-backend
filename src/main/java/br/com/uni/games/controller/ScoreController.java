package br.com.uni.games.controller;

import br.com.uni.games.dto.GameDTO;
import br.com.uni.games.dto.ScoreDTO;
import br.com.uni.games.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
    @Autowired
    private ScoreService service;

    @PutMapping
    public GameDTO saveScore(@RequestBody ScoreDTO dto) {
        GameDTO gameDTO = service.saveScore(dto);
        return gameDTO;
    }
}
