package com.ashleycraig.talkbooker.model.repository;

import com.ashleycraig.talkbooker.model.entity.TalkSuggestion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TalkSuggestionRepository extends MongoRepository<TalkSuggestion, String> {
}
