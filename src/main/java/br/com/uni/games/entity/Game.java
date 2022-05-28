package br.com.uni.games.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_game")
public class Game {

    @Id
    private Long id;
    private String title;
    private String image;
    private Double score;
    private Integer count;

    @OneToMany(mappedBy = "id.game")
    private Set<Score> scores = new HashSet<>();

    public Game() {}

    public Game(Long id, String title, String image, Double score, Integer count) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.score = score;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<Score> getScores() {
        return scores;
    }
}
