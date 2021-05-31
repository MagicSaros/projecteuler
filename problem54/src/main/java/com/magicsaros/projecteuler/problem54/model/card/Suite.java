package com.magicsaros.projecteuler.problem54.model.card;

import static java.util.Objects.isNull;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Suite {

  SPADES("S"),
  CLUBS("C"),
  HEARTS("H"),
  DIAMONDS("D");

  private final String index;

  private static final Map<String, Suite> INDICES_MAP = Arrays.stream(Suite.values())
      .collect(Collectors.toMap(Suite::getIndex, t -> t));

  public static Suite findByIndex(String index) {
    Suite suite = INDICES_MAP.get(index);
    if (isNull(suite)) {
      throw new IllegalArgumentException("Invalid suite index");
    }

    return suite;
  }
}
