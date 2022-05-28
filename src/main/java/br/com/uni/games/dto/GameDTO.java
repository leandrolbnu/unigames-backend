package br.com.uni.games.dto;

import br.com.uni.games.entity.Game;

public class GameDTO {

    private Long id;
    private String title;
    private String image;
    private Double score;
    private Integer count;

    public GameDTO() {
    }

    public GameDTO(Long id, String title, String image, Double score, Integer count) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.score = score;
        this.count = count;
    }

    public GameDTO(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.image = game.getImage();
        this.score = game.getScore();
        this.count = game.getCount();
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
}
