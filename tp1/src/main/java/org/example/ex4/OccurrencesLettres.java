package org.example.ex4;

public class OccurrencesLettres {
    private final String text;

    public OccurrencesLettres(String text) {
        this.text = text.toLowerCase();
    }

    public void calc(){
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int[] nb_occurrences = new int[26];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (alphabets.contains(String.valueOf(c))) {
                nb_occurrences[alphabets.indexOf(String.valueOf(c))]++;
            }
        }

        for (int i = 0; i < nb_occurrences.length; i++) {
            if (nb_occurrences[i] > 0) {
                System.out.printf("%c : %d%n", alphabets.charAt(i) , nb_occurrences[i]);
            }
        }
    }
}
