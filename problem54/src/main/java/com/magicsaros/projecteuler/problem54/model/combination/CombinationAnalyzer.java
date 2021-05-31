package com.magicsaros.projecteuler.problem54.model.combination;

import static java.util.Objects.isNull;

import com.magicsaros.projecteuler.problem54.model.card.Card;
import com.magicsaros.projecteuler.problem54.model.card.Rank;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.stream.Collectors;

class CombinationAnalyzer {

  private CombinationAnalyzer() {
    throw new AssertionError("Cannot be instantiated");
  }

  static CombinationAnalysis analyze(Combination combination) {
    if (isNull(combination.getCards()) || combination.getCards().size() != 5) {
      throw new IllegalArgumentException("Cards are not valid");
    }

    Card[] cards = combination.getCards()
        .stream()
        .map(Objects::requireNonNull)
        .sorted(Comparator.reverseOrder())
        .toArray(Card[]::new);

    int equalRanksCombinationTypeCode = 0;
    int straightConnections = 0;
    int flushConnections = 0;

    LinkedHashMap<Rank, Integer> ranksCount = Arrays.stream(cards)
        .collect(Collectors
            .toMap(Card::getRank, card -> 1, (count1, count2) -> ++count1, LinkedHashMap::new));

    for (int i = 0; i < 4; i++) {
      Card current = cards[i];
      Card next = cards[i + 1];

      if (current.getRank() == next.getRank()) {
        equalRanksCombinationTypeCode += (1 << i);
      }

      if (current.getRank().ordinal() - next.getRank().ordinal() == 1) {
        straightConnections++;
      }

      if (current.getSuite() == next.getSuite()) {
        flushConnections++;
      }
    }

    if (equalRanksCombinationTypeCode != 0) {
      CombinationType type = getCombinationTypeOfEqualRanks(equalRanksCombinationTypeCode);
      return new CombinationAnalysis(type, ranksCount);
    }

    boolean isStraight = straightConnections == 4
        // special case for A2345
        || straightConnections == 3
        && cards[0].getRank() == Rank.ACE
        && cards[4].getRank() == Rank.TWO;
    boolean isFlush = flushConnections == 4;

    CombinationType type = CombinationType.HIGH_CARD;
    if (isStraight) {
      if (!isFlush) {
        type = CombinationType.STRAIGHT;
      } else {
        type = CombinationType.STRAIGHT_FLUSH;
      }
    } else if (isFlush) {
      type = CombinationType.FLUSH;
    }

    return new CombinationAnalysis(type, ranksCount);
  }

  private static CombinationType getCombinationTypeOfEqualRanks(int code) {
    switch (code) {
      case 1: // 0001
      case 2: // 0010
      case 4: // 0100
      case 8: // 1000
        return CombinationType.ONE_PAIR;
      case 5: // 0101
      case 9: // 1001
      case 10: // 1010
        return CombinationType.TWO_PAIRS;
      case 3: // 0011
      case 6: // 0110
      case 12: // 1100
        return CombinationType.THREE_OF_A_KIND;
      case 11: // 1011
      case 13: // 1101
        return CombinationType.FULL_HOUSE;
      case 7: // 0111
      case 14: // 1110
        return CombinationType.FOUR_OF_A_KIND;
    }

    throw new IllegalArgumentException(
        String.format("Combination type code [%s] is not valid", code));
  }
}
