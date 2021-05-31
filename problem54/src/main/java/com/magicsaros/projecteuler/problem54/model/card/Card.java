package com.magicsaros.projecteuler.problem54.model.card;

import lombok.Data;

@Data
public final class Card implements Comparable<Card> {

  private final Rank rank;
  private final Suite suite;

  public String getIndex() {
    return String.format("%s%s", rank.getIndex(), suite.getIndex());
  }

  @Override
  public int compareTo(Card card) {
    return rank.compareTo(card.rank);
  }

  public static Card from(String index) {
    if (index.length() != 2) {
      throw new IllegalArgumentException("Card index is invalid");
    }

    Rank rank = Rank.findByIndex(index.split("")[0]);
    Suite suite = Suite.findByIndex(index.split("")[1]);

    return new Card(rank, suite);
  }
}
