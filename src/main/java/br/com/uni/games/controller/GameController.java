package br.com.uni.games.controller;

import br.com.uni.games.dto.GameDTO;
import br.com.uni.games.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class GameController {
    @Autowired
    private GameService service;

    @GetMapping
    public Page<GameDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
