package com.ashleycraig.talkbooker.model.service;

import com.ashleycraig.talkbooker.model.entity.TalkSuggestion;
import com.ashleycraig.talkbooker.model.repository.TalkSuggestionRepository;
import com.ashleycraig.talkbooker.view.TalkSuggestionViewModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TalkSuggestionService {

    private TalkSuggestionRepository talkSuggestionRepository;

    public void saveTalkSuggestion(final TalkSuggestionViewModel talkSuggestionViewModel) {
        final TalkSuggestion talkSuggestion = new TalkSuggestion();
        talkSuggestion.setFirstName(talkSuggestionViewModel.getFirstName());
        talkSuggestion.setLastName(talkSuggestionViewModel.getLastName());
        talkSuggestion.setTopic(talkSuggestionViewModel.getTopic());

        talkSuggestionRepository.save(talkSuggestion);
    }
}
