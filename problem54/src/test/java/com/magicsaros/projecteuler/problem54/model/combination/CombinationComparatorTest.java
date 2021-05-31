package com.magicsaros.projecteuler.problem54.model.combination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.magicsaros.projecteuler.problem54.model.card.Card;
import com.magicsaros.projecteuler.problem54.model.card.Rank;
import com.magicsaros.projecteuler.problem54.model.card.Suite;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class CombinationComparatorTest {

  private final CombinationComparator combinationComparator = new CombinationComparator();

  @Test
  public void compareDifferentCombinations() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.NINE, Suite.CLUBS),
        new Card(Rank.NINE, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TEN, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination1, combination2) > 0);
  }

  @Test
  public void compareEqualCombinationsDifferentHighCards() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.FIVE, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination1, combination2) > 0);
  }

  @Test
  public void compareEqualCombinationsAndHighCards() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    assertEquals(combinationComparator.compare(combination1, combination2), 0);
  }

  @Test
  public void compareOnePair() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TWO, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination1, combination2) > 0);
  }

  @Test
  public void compareTwoPairs() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.NINE, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.TWO, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination1, combination2) > 0);
  }

  @Test
  public void compareThreeOfAKind() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TEN, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.TWO, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination1, combination2) > 0);
  }

  @Test
  public void compareFullHouse() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TEN, Suite.CLUBS),
        new Card(Rank.NINE, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.TWO, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.NINE, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination1, combination2) > 0);

    Combination combination3 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.NINE, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.TEN, Suite.CLUBS),
        new Card(Rank.NINE, Suite.SPADES)
    ));

    Combination combination4 = new Combination(Set.of(
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.TWO, Suite.HEARTS),
        new Card(Rank.NINE, Suite.DIAMONDS),
        new Card(Rank.NINE, Suite.CLUBS),
        new Card(Rank.NINE, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination3, combination4) > 0);
  }

  @Test
  public void compareFourOfAKind() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.HEARTS),
        new Card(Rank.TEN, Suite.DIAMONDS),
        new Card(Rank.TEN, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.TWO, Suite.HEARTS),
        new Card(Rank.TWO, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.KING, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination1, combination2) > 0);
  }

  @Test
  public void compareStraight() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.QUEEN, Suite.SPADES),
        new Card(Rank.JACK, Suite.HEARTS),
        new Card(Rank.TEN, Suite.DIAMONDS),
        new Card(Rank.NINE, Suite.CLUBS),
        new Card(Rank.EIGHT, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.NINE, Suite.HEARTS),
        new Card(Rank.EIGHT, Suite.DIAMONDS),
        new Card(Rank.SEVEN, Suite.CLUBS),
        new Card(Rank.SIX, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination1, combination2) > 0);

    Combination combination3 = new Combination(Set.of(
        new Card(Rank.SIX, Suite.SPADES),
        new Card(Rank.FIVE, Suite.HEARTS),
        new Card(Rank.FOUR, Suite.DIAMONDS),
        new Card(Rank.THREE, Suite.CLUBS),
        new Card(Rank.TWO, Suite.SPADES)
    ));

    Combination combination4 = new Combination(Set.of(
        new Card(Rank.FIVE, Suite.SPADES),
        new Card(Rank.FOUR, Suite.HEARTS),
        new Card(Rank.THREE, Suite.DIAMONDS),
        new Card(Rank.TWO, Suite.CLUBS),
        new Card(Rank.ACE, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination3, combination4) > 0);
  }

  @Test
  public void compareFlush() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.QUEEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.NINE, Suite.SPADES),
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.KING, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.JACK, Suite.SPADES),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.NINE, Suite.SPADES),
        new Card(Rank.TWO, Suite.SPADES),
        new Card(Rank.KING, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination1, combination2) > 0);
  }

  @Test
  public void compareStraightFlush() {
    Combination combination1 = new Combination(Set.of(
        new Card(Rank.QUEEN, Suite.SPADES),
        new Card(Rank.TEN, Suite.SPADES),
        new Card(Rank.NINE, Suite.SPADES),
        new Card(Rank.JACK, Suite.SPADES),
        new Card(Rank.KING, Suite.SPADES)
    ));

    Combination combination2 = new Combination(Set.of(
        new Card(Rank.SIX, Suite.SPADES),
        new Card(Rank.THREE, Suite.SPADES),
        new Card(Rank.SEVEN, Suite.SPADES),
        new Card(Rank.FOUR, Suite.SPADES),
        new Card(Rank.FIVE, Suite.SPADES)
    ));

    assertTrue(combinationComparator.compare(combination1, combination2) > 0);
  }
}
