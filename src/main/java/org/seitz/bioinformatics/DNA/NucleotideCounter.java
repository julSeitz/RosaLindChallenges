package org.seitz.bioinformatics.DNA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Counts the number of occurrence of each nucleotide in a valid given DNA sequence
 */
public class NucleotideCounter {

    /**
     * Counts the number of occurrence of each nucleotide in a valid given DNA sequence
     * Returns counts in an array with the order "A", "C", "G", "T"
     *
     * @param input                         the given DNA sequence as a string
     * @return                              the int array containing the number of occurrences
     * @throws InvalidNucleotideException   throws exception if input contains invalid nucleotide
     */
    public int[] count(String input) throws InvalidNucleotideException {
        int[] result = new int[]{0, 0, 0, 0};
        String[] nucleotides = new String[]{"A", "C", "G", "T"};

        this.checkForInvalidNucleotides(input);

        for (int i = 0; i < result.length; i++) {
            result[i] = this.getOccurrencesOfNucleotide(input, nucleotides[i]);
        }

        return result;
    }

    /**
     * Returns the number of times a given nucleotide occurs in given DNA sequence
     *
     * @param input         the given DNA sequence as a string
     * @param nucleotide    the given nucleotide to be counted
     * @return              the number of times the nucleotide occurred in the sequence
     */
    private int getOccurrencesOfNucleotide(String input, String nucleotide) {

        Pattern pattern = Pattern.compile(nucleotide);
        Matcher matcher = pattern.matcher(input);
        int counter = 0;
        while(matcher.find()) {
            counter++;
        }

        return counter;
    }


    /**
     * Checks in given DNA sequence contains an invalid nucleotide
     *
     * @param input                         the given DNA sequence as a string
     * @throws InvalidNucleotideException   throws exception if DNA sequence contains invalid nucleotide
     */
    private void checkForInvalidNucleotides(String input) throws InvalidNucleotideException {
        Pattern pattern = Pattern.compile("[^ACGT]");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new InvalidNucleotideException();
        }
    }
}
