package org.seitz.bioinformatics.DNA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Counts the number of occurrence of each nucleotide in a valid given DNA sequence
 */
public class NucleotideCounter {

    /**
     * Counts the number of occurrence of each nucleotide in a valid given DNA sequence
     * Returns number of occurrences in an array with the order "A", "C", "G", "T"
     *
     * @param dnaSequence                   the string representing the DNA sequence
     * @return                              the int array containing the number of occurrences for each nucleotide
     * @throws InvalidNucleotideException   throws exception if dnaSequence contains invalid nucleotide
     */
    public int[] count(String dnaSequence) throws InvalidNucleotideException {
        int[] result = new int[]{0, 0, 0, 0};
        String[] nucleotides = new String[]{"A", "C", "G", "T"};

        this.checkForInvalidNucleotides(dnaSequence);

        for (int i = 0; i < result.length; i++) {
            result[i] = this.getOccurrencesOfNucleotide(dnaSequence, nucleotides[i]);
        }

        return result;
    }

    /**
     * Returns the number of times a given nucleotide occurs in given DNA sequence
     *
     * @param dnaSequence   the string representing the DNA sequence
     * @param nucleotide    the given nucleotide to be counted
     * @return              the number of times the nucleotide occurred in the sequence
     */
    private int getOccurrencesOfNucleotide(String dnaSequence, String nucleotide) {

        Pattern pattern = Pattern.compile(nucleotide);
        Matcher matcher = pattern.matcher(dnaSequence);
        int counter = 0;
        while(matcher.find()) {
            counter++;
        }

        return counter;
    }


    /**
     * Checks in given DNA sequence contains an invalid nucleotide
     *
     * @param dnaSequence                   the string representing the DNA sequence
     * @throws InvalidNucleotideException   throws exception if DNA sequence contains invalid nucleotide
     */
    private void checkForInvalidNucleotides(String dnaSequence) throws InvalidNucleotideException {
        Pattern pattern = Pattern.compile("[^ACGT]");
        Matcher matcher = pattern.matcher(dnaSequence);
        if (matcher.find()) {
            throw new InvalidNucleotideException();
        }
    }
}
