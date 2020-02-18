package com.ashleycraig.talkbooker.model.controller;

import com.ashleycraig.talkbooker.model.service.TalkSuggestionService;
import com.ashleycraig.talkbooker.view.TalkSuggestionViewModel;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TalkSuggestionViewModel> saveTalkSuggestion(@RequestBody @Valid final TalkSuggestionViewModel talkSuggestionViewModel) {

    System.out.println("body: " + talkSuggestionViewModel.toString());
    talkSuggestionService.saveTalkSuggestion(talkSuggestionViewModel);
    return ResponseEntity.ok(null);
  }
}
