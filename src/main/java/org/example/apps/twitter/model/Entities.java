package org.example.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entities {
    private List<Hashtag> hashtags;
    private List<UserMention> user_mentions;

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public List<UserMention> getUser_mentions() {
        return user_mentions;
    }

    public void setUser_mentions(List<UserMention> user_mentions) {
        this.user_mentions = user_mentions;
    }
}
