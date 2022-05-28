package br.com.uni.games.repository;

import br.com.uni.games.entity.Score;
import br.com.uni.games.entity.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
