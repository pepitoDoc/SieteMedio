package edu.fpdual.api.dao;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class Player {
    private String nickname;
    private String password;

    public Player(ResultSet result) {
        try {
            this.nickname = result.getString("nickname");
            this.password = result.getString("password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
