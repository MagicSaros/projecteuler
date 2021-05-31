package com.magicsaros.projecteuler.problem54.model.combination;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.magicsaros.projecteuler.problem54.model.card.Card;
import com.magicsaros.projecteuler.problem54.model.card.Rank;
import com.magicsaros.projecteuler.problem54.model.card.Suite;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class CombinationAnalyzerTest {

  @Test
  public void recognizeHighCard() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.FOUR, Suite.SPADES),
        new Card(Rank.NINE, Suite.HEARTS),
        new Card(Rank.ACE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.JACK, Suite.CLUBS)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.FOUR, Suite.SPADES),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.FIVE, Suite.HEARTS),
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.JACK, Suite.SPADES)
    ));

    CombinationAnalysis analysis1 = new CombinationAnalysis(CombinationType.HIGH_CARD,
        new LinkedHashMap<>(
            Map.of(Rank.ACE, 1, Rank.JACK, 1, Rank.NINE, 1, Rank.FOUR, 1, Rank.TWO, 1)));

    CombinationAnalysis analysis2 = new CombinationAnalysis(CombinationType.HIGH_CARD,
        new LinkedHashMap<>(
            Map.of(Rank.JACK, 1, Rank.FIVE, 1, Rank.FOUR, 1, Rank.THREE, 1, Rank.TWO, 1)));

    assertEquals(analysis1, CombinationAnalyzer.analyze(combination1));
    assertEquals(analysis2, CombinationAnalyzer.analyze(combination2));
  }

  @Test
  public void recognizeOnePair() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.ACE, Suite.SPADES),
        new Card(Rank.TWO, Suite.HEARTS),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.THREE, Suite.CLUBS),
        new Card(Rank.QUEEN, Suite.DIAMONDS)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.ACE, Suite.SPADES),
        new Card(Rank.TWO, Suite.HEARTS),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.ACE, Suite.CLUBS),
        new Card(Rank.QUEEN, Suite.DIAMONDS)
    ));

    CombinationAnalysis analysis1 = new CombinationAnalysis(CombinationType.ONE_PAIR,
        new LinkedHashMap<>(Map.of(Rank.ACE, 1, Rank.QUEEN, 1, Rank.THREE, 2, Rank.TWO, 1)));

    CombinationAnalysis analysis2 = new CombinationAnalysis(CombinationType.ONE_PAIR,
        new LinkedHashMap<>(Map.of(Rank.ACE, 2, Rank.QUEEN, 1, Rank.THREE, 1, Rank.TWO, 1)));

    assertEquals(analysis1, CombinationAnalyzer.analyze(combination1));
    assertEquals(analysis2, CombinationAnalyzer.analyze(combination2));
  }

  @Test
  public void recognizeTwoPairs() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.QUEEN, Suite.SPADES),
        new Card(Rank.TWO, Suite.HEARTS),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.THREE, Suite.CLUBS),
        new Card(Rank.QUEEN, Suite.DIAMONDS)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.QUEEN, Suite.SPADES),
        new Card(Rank.TWO, Suite.HEARTS),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.QUEEN, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS)
    ));

    CombinationAnalysis analysis1 = new CombinationAnalysis(CombinationType.TWO_PAIRS,
        new LinkedHashMap<>(Map.of(Rank.QUEEN, 2, Rank.THREE, 2, Rank.TWO, 1)));

    CombinationAnalysis analysis2 = new CombinationAnalysis(CombinationType.TWO_PAIRS,
        new LinkedHashMap<>(Map.of(Rank.QUEEN, 2, Rank.THREE, 1, Rank.TWO, 2)));

    assertEquals(analysis1, CombinationAnalyzer.analyze(combination1));
    assertEquals(analysis2, CombinationAnalyzer.analyze(combination2));
  }

  @Test
  public void recognizeThreeOfAKind() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.QUEEN, Suite.SPADES),
        new Card(Rank.THREE, Suite.HEARTS),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.THREE, Suite.CLUBS),
        new Card(Rank.JACK, Suite.DIAMONDS)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.JACK, Suite.HEARTS),
        new Card(Rank.QUEEN, Suite.SPADES),
        new Card(Rank.JACK, Suite.SPADES),
        new Card(Rank.TEN, Suite.DIAMONDS),
        new Card(Rank.JACK, Suite.CLUBS)
    ));

    CombinationAnalysis analysis1 = new CombinationAnalysis(CombinationType.THREE_OF_A_KIND,
        new LinkedHashMap<>(Map.of(Rank.QUEEN, 1, Rank.JACK, 1, Rank.THREE, 3)));

    CombinationAnalysis analysis2 = new CombinationAnalysis(CombinationType.THREE_OF_A_KIND,
        new LinkedHashMap<>(Map.of(Rank.QUEEN, 1, Rank.JACK, 3, Rank.TEN, 1)));

    assertEquals(analysis1, CombinationAnalyzer.analyze(combination1));
    assertEquals(analysis2, CombinationAnalyzer.analyze(combination2));
  }

  @Test
  public void recognizeStraight() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.FOUR, Suite.SPADES),
        new Card(Rank.THREE, Suite.HEARTS),
        new Card(Rank.FIVE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.SIX, Suite.CLUBS)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.FOUR, Suite.SPADES),
        new Card(Rank.THREE, Suite.HEARTS),
        new Card(Rank.FIVE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.ACE, Suite.CLUBS)
    ));

    CombinationAnalysis analysis1 = new CombinationAnalysis(CombinationType.STRAIGHT,
        new LinkedHashMap<>(
            Map.of(Rank.SIX, 1, Rank.FIVE, 1, Rank.FOUR, 1, Rank.THREE, 1, Rank.TWO, 1)));

    CombinationAnalysis analysis2 = new CombinationAnalysis(CombinationType.STRAIGHT,
        new LinkedHashMap<>(
            Map.of(Rank.ACE, 1, Rank.FIVE, 1, Rank.FOUR, 1, Rank.THREE, 1, Rank.TWO, 1)));

    assertEquals(analysis1, CombinationAnalyzer.analyze(combination1));
    assertEquals(analysis2, CombinationAnalyzer.analyze(combination2));
  }

  @Test
  public void recognizeFlush() {
    Combination combination = new Combination(Set.of(
        new Card(Rank.FOUR, Suite.SPADES),
        new Card(Rank.JACK, Suite.SPADES),
        new Card(Rank.SEVEN, Suite.SPADES),
        new Card(Rank.NINE, Suite.SPADES),
        new Card(Rank.SIX, Suite.SPADES)
    ));

    CombinationAnalysis analysis = new CombinationAnalysis(CombinationType.FLUSH,
        new LinkedHashMap<>(
            Map.of(Rank.JACK, 1, Rank.NINE, 1, Rank.SEVEN, 1, Rank.SIX, 1, Rank.FOUR, 1)));

    assertEquals(analysis, CombinationAnalyzer.analyze(combination));
  }

  @Test
  public void recognizeFullHouse() {
    Combination combination = new Combination(Set.of(
        new Card(Rank.QUEEN, Suite.SPADES),
        new Card(Rank.THREE, Suite.HEARTS),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.QUEEN, Suite.DIAMONDS),
        new Card(Rank.THREE, Suite.CLUBS)
    ));

    CombinationAnalysis analysis = new CombinationAnalysis(CombinationType.FULL_HOUSE,
        new LinkedHashMap<>(Map.of(Rank.QUEEN, 2, Rank.THREE, 3)));

    assertEquals(analysis, CombinationAnalyzer.analyze(combination));
  }

  @Test
  public void recognizeFourOfAKind() {
    Combination combination = new Combination(Set.of(
        new Card(Rank.THREE, Suite.HEARTS),
        new Card(Rank.QUEEN, Suite.SPADES),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.THREE, Suite.DIAMONDS),
        new Card(Rank.THREE, Suite.CLUBS)
    ));

    CombinationAnalysis analysis = new CombinationAnalysis(CombinationType.FOUR_OF_A_KIND,
        new LinkedHashMap<>(Map.of(Rank.QUEEN, 1, Rank.THREE, 4)));

    assertEquals(analysis, CombinationAnalyzer.analyze(combination));
  }

  @Test
  public void recognizeStraightFlush() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.FOUR, Suite.SPADES),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.FIVE, Suite.SPADES),
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.SIX, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.FOUR, Suite.SPADES),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.FIVE, Suite.SPADES),
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.ACE, Suite.SPADES)
    ));

    CombinationAnalysis analysis1 = new CombinationAnalysis(CombinationType.STRAIGHT_FLUSH,
        new LinkedHashMap<>(
            Map.of(Rank.SIX, 1, Rank.FIVE, 1, Rank.FOUR, 1, Rank.THREE, 1, Rank.TWO, 1)));

    CombinationAnalysis analysis2 = new CombinationAnalysis(CombinationType.STRAIGHT_FLUSH,
        new LinkedHashMap<>(
            Map.of(Rank.ACE, 1, Rank.FIVE, 1, Rank.FOUR, 1, Rank.THREE, 1, Rank.TWO, 1)));

    assertEquals(analysis1, CombinationAnalyzer.analyze(combination1));
    assertEquals(analysis2, CombinationAnalyzer.analyze(combination2));
  }
}
