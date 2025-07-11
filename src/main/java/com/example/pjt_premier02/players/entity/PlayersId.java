package com.example.pjt_premier02.players.entity;

import java.io.Serializable;
import java.util.Objects;

public class PlayersId implements Serializable {
    private Integer playerNo;
    private Integer clubNo;

    // 기본 생성자 필수
    public PlayersId() {}

    public PlayersId(Integer playerNo, Integer clubNo) {
        this.playerNo = playerNo;
        this.clubNo = clubNo;
    }

    // equals & hashCode 반드시 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayersId)) return false;
        PlayersId that = (PlayersId) o;
        return Objects.equals(playerNo, that.playerNo) && Objects.equals(clubNo, that.clubNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerNo, clubNo);
    }
}