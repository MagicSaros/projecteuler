package com.magicsaros.projecteuler.problem54.model.combination;

import com.magicsaros.projecteuler.problem54.model.card.Rank;
import java.util.LinkedHashMap;
import lombok.Data;

@Data
final class CombinationAnalysis {

  private final CombinationType combinationType;
  private final LinkedHashMap<Rank, Integer> ranksCount;
}
