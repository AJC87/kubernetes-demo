package com.ashleycraig.talkbooker.controller;

import com.ashleycraig.talkbooker.model.entity.TalkSuggestion;
import com.ashleycraig.talkbooker.model.mapping.TalkSuggestionMapper;
import com.ashleycraig.talkbooker.model.service.TalkSuggestionService;
import com.ashleycraig.talkbooker.view.TalkSuggestionViewModel;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@Validated
@RequestMapping("/")
public class TalkSuggestionController {

  private final TalkSuggestionService talkSuggestionService;
  private final TalkSuggestionMapper talkSuggestionMapper = TalkSuggestionMapper.INSTANCE;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TalkSuggestionViewModel> saveTalkSuggestion(@RequestBody @Valid final TalkSuggestionViewModel talkSuggestionViewModel) {

    System.out.println("Request body: " + talkSuggestionViewModel.toString());

    final Optional<TalkSuggestion> optionalTalkSuggestion = talkSuggestionService.saveTalkSuggestion(talkSuggestionViewModel);

    return optionalTalkSuggestion.map(talkSuggestion -> ResponseEntity.ok(talkSuggestionMapper.talkSuggestionToTalkSuggestionViewModel(talkSuggestion)))
        .orElseGet(() -> ResponseEntity.noContent().build());
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TalkSuggestionViewModel>> getTalkSuggestions() {

    final List<TalkSuggestion> talkSuggestions = talkSuggestionService.getTalkSuggestions();

    final List<TalkSuggestionViewModel> talkSuggestionViewModels = talkSuggestions.stream().map(talkSuggestionMapper::talkSuggestionToTalkSuggestionViewModel).collect(Collectors.toList());

    return ResponseEntity.ok(talkSuggestionViewModels);
  }
}
