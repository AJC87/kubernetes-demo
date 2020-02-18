package com.ashleycraig.talkbooker.model.repository;

import com.ashleycraig.talkbooker.model.entity.TalkSuggestion;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkSuggestionRepository extends MongoRepository<TalkSuggestion, String> {

  Optional<TalkSuggestion> findOneByFirstNameAndLastNameAndTopic(final String firstName, final String lastName, final String topic);
}
