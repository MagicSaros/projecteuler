package com.magicsaros.projecteuler.problem54.service;

import com.magicsaros.projecteuler.problem54.dto.ComparingResultDto;
import com.magicsaros.projecteuler.problem54.dto.PlayerCombinationDto;
import com.magicsaros.projecteuler.problem54.model.card.Card;
import com.magicsaros.projecteuler.problem54.model.combination.Combination;
import com.magicsaros.projecteuler.problem54.model.combination.CombinationComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerCombinationService {

  private final CombinationComparator combinationComparator;

  public ComparingResultDto comparePlayerCombinations(
      List<PlayerCombinationDto> playerCombinationDtos) {
    if (playerCombinationDtos.size() != 2) {
      throw new IllegalArgumentException("Wrong number of players");
    }

    Set<Card> cards1 = playerCombinationDtos.get(0)
        .getCardIndices()
        .stream()
        .map(Card::from)
        .collect(Collectors.toSet());

    Set<Card> cards2 = playerCombinationDtos.get(1)
        .getCardIndices()
        .stream()
        .map(Card::from)
        .collect(Collectors.toSet());

    int result = combinationComparator.compare(new Combination(cards1), new Combination(cards2));

    List<String> winnerIds = new LinkedList<>();
    if (result > 0) {
      winnerIds.add(playerCombinationDtos.get(0).getPlayerId());
    } else if (result < 0) {
      winnerIds.add(playerCombinationDtos.get(1).getPlayerId());
    } else {
      winnerIds.add(playerCombinationDtos.get(0).getPlayerId());
      winnerIds.add(playerCombinationDtos.get(1).getPlayerId());
    }

    ComparingResultDto comparingResultDto = new ComparingResultDto();
    comparingResultDto.setWinnersIds(winnerIds);
    return comparingResultDto;
  }
}
