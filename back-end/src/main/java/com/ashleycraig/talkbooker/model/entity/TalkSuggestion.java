package com.ashleycraig.talkbooker.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "talk_suggestions")
public class TalkSuggestion {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String topic;
}
