package br.com.uni.games.service;

import br.com.uni.games.dto.GameDTO;
import br.com.uni.games.dto.ScoreDTO;
import br.com.uni.games.entity.Game;
import br.com.uni.games.entity.Score;
import br.com.uni.games.entity.User;
import br.com.uni.games.repository.GameRepository;
import br.com.uni.games.repository.ScoreRepository;
import br.com.uni.games.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public GameDTO saveScore(ScoreDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Game game = gameRepository.findById(dto.getGameId()).get();

        Score score = new Score();
        score.setGame(game);
        score.setUser(user);
        score.setScore(dto.getScore());
        score = scoreRepository.saveAndFlush(score);

        Double sum = 0.0;
        for (Score s : game.getScores()) {
            sum = sum + s.getScore();
        }

        Double avg = sum / game.getScores().size();

        game.setScore(avg);
        game.setCount(game.getScores().size());
        game = gameRepository.save(game);

        return new GameDTO(game);
    }
}
