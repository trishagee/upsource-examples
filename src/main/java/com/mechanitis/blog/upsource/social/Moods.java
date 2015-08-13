package com.mechanitis.blog.upsource.social;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Moods {
    private static final Map<String, String> WORD_TO_MOOD = new HashMap<>();

    static {
        WORD_TO_MOOD.put("happy", "HAPPY");
        WORD_TO_MOOD.put("good", "HAPPY");
        WORD_TO_MOOD.put("great", "HAPPY");
        WORD_TO_MOOD.put("keen", "HAPPY");
        WORD_TO_MOOD.put("awesome", "HAPPY");
        WORD_TO_MOOD.put("marvelous", "HAPPY");
        WORD_TO_MOOD.put("yay", "HAPPY");
        WORD_TO_MOOD.put("pleased", "HAPPY");
        WORD_TO_MOOD.put("sad", "SAD");
        WORD_TO_MOOD.put("mad", "SAD");
        WORD_TO_MOOD.put("blargh", "SAD");
        WORD_TO_MOOD.put("boo", "SAD");
        WORD_TO_MOOD.put("terrible", "SAD");
        WORD_TO_MOOD.put("horrible", "SAD");
        WORD_TO_MOOD.put("bad", "SAD");
        WORD_TO_MOOD.put("awful", "SAD");
    }

    public static Optional<String> getMoodForWord(String word) {
        return Optional.ofNullable(WORD_TO_MOOD.get(word));
    }

    private Moods() {
    }
}
