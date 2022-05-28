package br.com.uni.games.service;

import br.com.uni.games.dto.GameDTO;
import br.com.uni.games.entity.Game;
import br.com.uni.games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public Page<GameDTO> findAll(Pageable pageable) {
        Page<Game> result = repository.findAll(pageable);
        Page<GameDTO> page = result.map(x -> new GameDTO(x));
        return page;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = repository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }
}
