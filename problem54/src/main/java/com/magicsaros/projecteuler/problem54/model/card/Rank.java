package com.magicsaros.projecteuler.problem54.model.card;

import static java.util.Objects.isNull;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Rank implements Comparable<Rank> {

  TWO("2"),
  THREE("3"),
  FOUR("4"),
  FIVE("5"),
  SIX("6"),
  SEVEN("7"),
  EIGHT("8"),
  NINE("9"),
  TEN("T"),
  JACK("J"),
  QUEEN("Q"),
  KING("K"),
  ACE("A");

  private final String index;

  private static final Map<String, Rank> INDICES_MAP = Arrays.stream(Rank.values())
      .collect(Collectors.toMap(Rank::getIndex, t -> t));

  public static Rank findByIndex(String index) {
    Rank rank = INDICES_MAP.get(index);
    if (isNull(rank)) {
      throw new IllegalArgumentException("Invalid rank index");
    }

    return rank;
  }
}
