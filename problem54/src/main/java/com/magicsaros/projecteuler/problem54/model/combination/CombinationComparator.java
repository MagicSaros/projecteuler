package com.magicsaros.projecteuler.problem54.model.combination;

import com.magicsaros.projecteuler.problem54.model.card.Rank;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.function.ToIntFunction;
import org.springframework.stereotype.Component;

@Component
public class CombinationComparator implements Comparator<Combination> {

  @Override
  public int compare(Combination combination1, Combination combination2) {
    CombinationAnalysis analysis1 = CombinationAnalyzer.analyze(combination1);
    CombinationAnalysis analysis2 = CombinationAnalyzer.analyze(combination2);

    int result = analysis1.getCombinationType().compareTo(analysis2.getCombinationType());
    if (result != 0) {
      return result;
    }

    return compareEqualCombinationTypes(analysis1, analysis2);
  }

  private int compareEqualCombinationTypes(CombinationAnalysis analysis1,
      CombinationAnalysis analysis2) {
    Rank[] ranks1 = analysis1.getRanksCount().keySet().toArray(Rank[]::new);
    Rank[] ranks2 = analysis2.getRanksCount().keySet().toArray(Rank[]::new);

    switch (analysis1.getCombinationType()) {
      case STRAIGHT:
      case STRAIGHT_FLUSH:
        return compareStraight(ranks1, ranks2);
      case ONE_PAIR:
      case TWO_PAIRS:
      case THREE_OF_A_KIND:
      case FULL_HOUSE:
      case FOUR_OF_A_KIND:
        return compareEqualRanksCombinations(analysis1.getRanksCount(), analysis2.getRanksCount());
      case HIGH_CARD:
      case FLUSH:
        return compareHighCard(ranks1, ranks2);
    }

    throw new IllegalArgumentException("Impossible combination");
  }

  private int compareStraight(Rank[] ranks1, Rank[] ranks2) {
    if (ranks1[0] == Rank.ACE && ranks1[4] == Rank.TWO
        && ranks2[0] == Rank.ACE && ranks2[4] == Rank.TWO) {
      return 0;
    }
    if (ranks1[0] == Rank.ACE && ranks1[4] == Rank.TWO) {
      return -1;
    }
    if (ranks2[0] == Rank.ACE && ranks2[4] == Rank.TWO) {
      return 1;
    }
    return ranks1[1].compareTo(ranks2[1]);
  }

  private int compareEqualRanksCombinations(LinkedHashMap<Rank, Integer> ranksCount1,
      LinkedHashMap<Rank, Integer> ranksCount2) {
    Rank[] comparisonOrder1 = getComparisonOrder(ranksCount1);
    Rank[] comparisonOrder2 = getComparisonOrder(ranksCount2);

    return compareHighCard(comparisonOrder1, comparisonOrder2);
  }

  private int compareHighCard(Rank[] ranks1, Rank[] ranks2) {
    for (int i = 0; i < ranks1.length; i++) {
      int result = ranks1[i].compareTo(ranks2[i]);
      if (result != 0) {
        return result;
      }
    }

    return 0;
  }

  private Rank[] getComparisonOrder(LinkedHashMap<Rank, Integer> ranksCount) {
    return ranksCount.entrySet()
        .stream()
        .sorted(Comparator.comparingInt((ToIntFunction<Entry<Rank, Integer>>) Entry::getValue)
            .thenComparing(Entry::getKey)
            .reversed())
        .map(Entry::getKey)
        .toArray(Rank[]::new);
  }
}
