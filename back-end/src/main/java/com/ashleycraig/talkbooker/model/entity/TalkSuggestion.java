package com.ashleycraig.talkbooker.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TalkSuggestion {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String topic;
}
