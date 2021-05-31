package com.magicsaros.projecteuler.problem54.api;

import com.magicsaros.projecteuler.problem54.dto.ComparingResultDto;
import com.magicsaros.projecteuler.problem54.dto.PlayerCombinationDto;
import com.magicsaros.projecteuler.problem54.service.PlayerCombinationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combinations")
@RequiredArgsConstructor
public class PlayerCombinationController {

  private final PlayerCombinationService playerCombinationService;

  @PostMapping
  public ComparingResultDto compareCombinations(
      @RequestBody List<PlayerCombinationDto> playerCombinationDtos) {
    return playerCombinationService.comparePlayerCombinations(playerCombinationDtos);
  }
}
