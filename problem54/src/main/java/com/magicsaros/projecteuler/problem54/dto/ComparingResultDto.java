package com.magicsaros.projecteuler.problem54.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class ComparingResultDto {

  @JsonProperty("winner_ids")
  public List<String> winnersIds;
}
