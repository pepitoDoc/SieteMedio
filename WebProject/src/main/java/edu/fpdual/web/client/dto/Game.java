package edu.fpdual.web.client.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement
public class Game {

    private String player1;
    private String player2;
    private String player3;
    private String dealer;
    private float player1score;
    private float player2score;
    private float player3score;
    private float dealerScore;
    private float player1bet;
    private float player2bet;
    private float player3bet;
    private String timestamp;

}
