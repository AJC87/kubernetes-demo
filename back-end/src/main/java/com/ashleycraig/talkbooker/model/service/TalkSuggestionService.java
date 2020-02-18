package com.ashleycraig.talkbooker.model.service;

import com.ashleycraig.talkbooker.model.entity.TalkSuggestion;
import com.ashleycraig.talkbooker.model.mapping.TalkSuggestionMapper;
import com.ashleycraig.talkbooker.model.repository.TalkSuggestionRepository;
import com.ashleycraig.talkbooker.view.TalkSuggestionViewModel;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TalkSuggestionService {

  private final TalkSuggestionRepository talkSuggestionRepository;
  private final TalkSuggestionMapper talkSuggestionMapper = TalkSuggestionMapper.INSTANCE;

  public Optional<TalkSuggestion> saveTalkSuggestion(final TalkSuggestionViewModel talkSuggestionViewModel) {

    Optional<TalkSuggestion> optionalTalkSuggestion = talkSuggestionRepository
        .findOneByFirstNameAndLastNameAndTopic(talkSuggestionViewModel.getFirstName(), talkSuggestionViewModel.getLastName(), talkSuggestionViewModel.getTopic());

    if (optionalTalkSuggestion.isPresent()) {
      return Optional.empty();
    }

    final TalkSuggestion talkSuggestion = talkSuggestionMapper.talkSuggestionViewModelToTalkSuggestion(talkSuggestionViewModel);

    return Optional.of(talkSuggestionRepository.save(talkSuggestion));
  }

  public List<TalkSuggestion> getTalkSuggestions() {
    return talkSuggestionRepository.findAll();
  }
}
