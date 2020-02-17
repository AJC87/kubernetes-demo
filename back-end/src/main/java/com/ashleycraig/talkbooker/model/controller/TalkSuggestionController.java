package com.ashleycraig.talkbooker.model.controller;

import com.ashleycraig.talkbooker.model.service.TalkSuggestionService;
import com.ashleycraig.talkbooker.view.TalkSuggestionViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/")
public class TalkSuggestionController {

  private TalkSuggestionService talkSuggestionService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TalkSuggestionViewModel> saveTalkSuggestion(@PathVariable final TalkSuggestionViewModel talkSuggestionViewModel) {

    return ResponseEntity.ok(null);
  }
}
