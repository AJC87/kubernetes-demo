package com.ashleycraig.talkbooker.model.mapping;

import com.ashleycraig.talkbooker.model.entity.TalkSuggestion;
import com.ashleycraig.talkbooker.view.TalkSuggestionViewModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TalkSuggestionMapper {

  TalkSuggestionMapper INSTANCE = Mappers.getMapper( TalkSuggestionMapper.class );

  TalkSuggestionViewModel talkSuggestionToTalkSuggestionViewModel(final TalkSuggestion talkSuggestion);
  TalkSuggestion talkSuggestionViewModelToTalkSuggestion(final TalkSuggestionViewModel talkSuggestionViewModel);
}
