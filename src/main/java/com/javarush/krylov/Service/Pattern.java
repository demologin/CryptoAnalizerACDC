package com.javarush.krylov.Service;

//Судя по всему, недостаточно данных - слишком мало сочетаний, программа их видит не во всех текстах
public enum Pattern {
    EN("English", new String [] {"th", "he", "in", "er", "an", "re", "es", "on", "st", "nt", "en", "at", "ed", "no", "to", "the", "and", "ing", "ent", "ion", "her", "for", "tha", "nth", "int", "ere", "tio", "ter", "est", "ers"}),
    FR("French", new String [] {"es", "le", "de", "en", "on", "nt", "re", "an", "la", "er", "te", "el", "se", "ti", "ur", "ent", "les", "ion", "des", "ede", "que", "est", "tio", "ant", "par", "men", "del", "ela", "sde", "lle"}),
    ES("Spanish", new String [] {"de", "es", "en", "el", "la", "os", "on", "as", "er", "ra", "ad", "ar", "re", "al", "an", "del", "que", "ent", "ion", "ela", "con", "sde", "ade", "cio", "nte", "est", "los", "ode", "ado", "res"}),
    DE("German", new String [] {"er", "en", "ch", "de", "ei", "te", "in", "nd", "ie", "ge", "st", "ne", "be", "es", "un", "der", "ein", "sch", "ich", "nde", "die", "che", "den", "ten", "und", "ine", "ter", "ger", "end", "ers"}),
    RU("Russian", new String [] {"ст", "ен", "ов", "но", "ни", "на", "ра", "ко", "то", "ро", "ан", "ос", "по", "го", "ер", "ени", "ост", "ого", "ств", "ско", "ста", "ани", "про", "ест", "тор", "льн", "ова", "ния", "ние", "при"})
    ;
    private final String label;
    private final String[] description;

    Pattern(String label, String[] description) {
        this.label = label;
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public String[] getDescription() {
        return description;
    }
}
