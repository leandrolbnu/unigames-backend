package br.com.uni.games.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {

    @EmbeddedId
    private ScorePK id = new ScorePK();
    private Double score;

    public Score() {
    }

    public void setGame(Game game) {
        this.id.setGame(game);
    }

    public void setUser(User user) {
        this.id.setUser(user);
    }

    public ScorePK getId() {
        return id;
    }

    public void setId(ScorePK id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
