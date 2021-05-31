package com.magicsaros.projecteuler.problem54.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class PlayerCombinationDto {

  @JsonProperty("player_id")
  private String playerId;

  @JsonProperty("card_indices")
  private List<String> cardIndices;
}
