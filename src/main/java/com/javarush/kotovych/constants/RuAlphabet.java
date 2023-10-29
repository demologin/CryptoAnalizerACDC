package com.javarush.kotovych.constants;

import com.javarush.kotovych.containers.Alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuAlphabet implements Alphabet {
    private static final List<String> words = new ArrayList<>(Arrays.asList("это", "она", "так", "же", "по", "но", "мне", "бы", "быть",
            "все", "за", "сказать", "они", "мы", "один", "который", "привет",
            "только", "еще", "себя", "когда", "уже", "для", "вот", "нет", "да",
            "со", "ты", "если", "или", "там", "где", "ну", "потом", "время",
            "при", "даже", "раз", "ни", "чтобы", "без", "может", "больше",
            "теперь", "кто", "одно", "про", "вдруг", "ли", "тут", "почему",
            "потому", "здесь", "сейчас", "какой", "год", "тоже", "всегда",
            "надо", "много", "другой", "тогда", "хорошо", "свой", "нельзя",
            "перед", "через", "под", "лучше", "тоже", "два", "пока", "между",
            "потому", "ничто", "как-то", "сегодня", "всю", "конечно", "вдоль",
            "нужно", "просто", "очень", "сам", "вместе", "после", "над", "иметь",
            "голова", "кто-то", "такой", "сделать", "день", "более", "над", "где",
            "всегда", "почему", "потому", "здесь", "сейчас", "какой", "год", "тоже",
            "всегда", "надо", "много", "другой", "тогда", "хорошо", "свой", "нельзя",
            "перед", "через", "под", "лучше", "тоже", "два", "пока", "между", "потому",
            "ничто", "как-то", "сегодня", "всю", "конечно", "вдоль", "нужно", "просто",
            "очень", "сам", "вместе", "после", "над", "иметь", "голова", "кто-то", "стать",
            "вопрос", "рука", "жизнь", "рядом", "три", "новый", "чем", "работа", "место",
            "сторона", "пять", "место", "пока", "иметь", "главное", "дело", "важно", "друг",
            "русский", "стоять", "прийти", "никто", "смотреть", "назад", "понять", "несколько",
            "вы", "сразу", "голос", "прошлый", "смочь", "пойти", "близко", "чуть", "пока",
            "трудно", "мать", "остаться", "москва", "должен", "голос", "глаз", "год", "вокруг",
            "вечер", "зачем", "собой", "много", "что-то", "зачем", "пора", "молчать", "месяц",
            "делать", "черный", "город", "мысль", "туда", "сразу", "ждать", "против", "черный",
            "сила", "лицо", "месяц", "ночь", "народ", "вперед", "свет", "письмо", "конец", "утро",
            "вместе", "порой", "нигде", "тепло", "сын", "имя", "сестра", "жена", "муж", "путь",
            "час", "видеть", "важно", "слово", "помнить", "улица", "школа", "дверь", "правда",
            "встреча", "душа", "красный", "смех", "жить", "деньги", "любовь", "смысл", "начать",
            "человек", "работать", "второй", "мысли", "знаю", "каждый", "ответ", "последний", "первый",
            "грусть", "воздух", "говорить", "нельзя", "каждый", "человек", "работать", "второй"));

    private final String RU_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final String NUMBERS = "0123456789";
    private final String SYMBOLS = "\n`~!@#$%^&*(){}[]<>;:'\\|?., -_+\"";
    private final String SYMBOL_CHARS = (NUMBERS + SYMBOLS);
    private final char[] CHARS = (RU_ALPHABET + SYMBOL_CHARS).toCharArray();

    @Override
    public char[] getChars() {
        return CHARS;
    }

    @Override
    public List<String> getWords() {
        return words;
    }

    public RuAlphabet(){
        Arrays.sort(CHARS);
    }
}
