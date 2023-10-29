package com.javarush.kotovych.constants;

import com.javarush.kotovych.containers.Alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnAlphabet implements Alphabet {
    private final List<String> words = new ArrayList<>(Arrays.asList("hello", "the", "and", "of", "to", "in",
             "that", "was",  "for", "you", "with",
            "his", "they", "are", "at", "be", "this", "have", "from", "one",
            "had", "by", "word", "but", "not", "what", "all", "were", "we",
            "when", "your", "can", "said", "there", "use", "an", "each",
            "which", "she", "how", "their", "would", "make", "like",
            "him", "into", "time", "has", "look", "two", "more", "write",
             "see", "number", "way", "could", "people", "my",
            "than", "first", "water", "been", "call", "who", "oil", "its",
            "now", "find", "long", "down", "day", "did", "get", "come",
            "made", "may", "part", "over", "new", "sound", "take", "only",
            "little", "work", "know", "place", "years", "live", "me", "back",
            "give", "most", "very", "after", "thing", "our", "just", "name",
            "good", "sentence", "man", "think", "say", "great", "where", "help",
            "through", "much", "before", "line", "right", "too", "mean",
            "old", "any", "same", "tell", "boy", "follow", "came", "want", "show",
            "also", "around", "form", "three", "small", "set", "put", "end", "does",
            "another", "well", "large", "must", "big", "even", "such", "because",
            "turn", "here", "why", "asked", "went", "men", "read", "need", "land",
            "different", "home", "us", "move", "try", "kind", "hand", "picture",
            "again", "change", "off", "play", "spell", "air", "away", "animal",
            "house", "point", "page", "letter", "mother", "answer", "found",
            "study", "still", "learn", "should", "America", "world", "high", "every",
            "near", "add", "food", "between", "own", "below", "country", "plant",
            "last", "school", "father", "keep", "tree", "never", "start", "city",
            "earth", "eye", "light", "thought", "head", "under", "story", "saw",
            "left", "don't", "few", "while", "along", "might", "close", "something",
            "seem", "next", "hard", "open", "example", "begin", "life", "always",
            "those", "both", "paper", "together", "got", "group", "often", "run",
            "important", "until", "children", "side", "feet", "car", "mile", "night",
            "walk", "white", "sea", "began", "grow", "took", "river", "four", "carry",
            "state", "once", "book", "hear", "stop", "without", "second", "later",
            "miss", "idea", "enough", "eat", "face", "watch", "far", "Indian",
            "real", "almost", "let", "above", "girl", "sometimes", "mountains",
            "cut", "young", "talk", "soon", "list", "song", "being", "leave",
            "family", "it's"));
    private final String EN_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String SYMBOLS = "\n`~!@#$%^&*(){}[]<>;:'\\|?., -_+\"";
    private final String SYMBOL_CHARS = (NUMBERS + SYMBOLS);
    private final char[] CHARS = (EN_ALPHABET + SYMBOL_CHARS).toCharArray();

    @Override
    public char[] getChars() {
        return CHARS;
    }

    @Override
    public List<String> getWords() {
        return words;
    }

    public EnAlphabet(){
        Arrays.sort(CHARS);
    }
}
