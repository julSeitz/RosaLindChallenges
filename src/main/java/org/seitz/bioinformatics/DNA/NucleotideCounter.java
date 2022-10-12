package org.seitz.bioinformatics.DNA;

import org.seitz.bioinformatics.DnaSequenceValidator;
import org.seitz.bioinformatics.RnaSequenceValidator;
import org.seitz.bioinformatics.SequenceValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Counts the number of occurrence of each nucleotide in a valid given DNA sequence
 */
public class NucleotideCounter {

    /**
     * Array of validators for different types of nucleotide sequences
     */
    private final SequenceValidator[] validators;

    /**
     * Constructor taking required nucleotide sequence validators
     *
     * @param dnaValidator      the DNA sequence validator
     * @param rnaValidator      the RNA sequence validator
     */
    public NucleotideCounter(DnaSequenceValidator dnaValidator, RnaSequenceValidator rnaValidator) {
        this.validators = new SequenceValidator[] {
                dnaValidator,
                rnaValidator
        };
    }

    /**
     * Counts the number of occurrence of each nucleotide in a valid given nucleotide sequence
     * Returns number of occurrences in an array with the order "A", "C", "G", "T" for DNA
     * and "A", "C", "G", "U" for RNA
     *
     * @param nucleotideSequence            the string representing the nucleotide sequence
     * @return                              the int array containing the number of occurrences for each nucleotide
     * @throws InvalidNucleotideException   throws exception if nucleotide sequence contains an invalid nucleotide
     */
    public int[] count(String nucleotideSequence, String typeOfSequence) throws InvalidNucleotideException, IllegalArgumentException {
        int[] result = new int[]{0, 0, 0, 0};

        String[] nucleotides;
        int currentValidator;
        if (typeOfSequence.equals("DNA")) {
            currentValidator = 0;
            nucleotides = new String[]{"A", "C", "G", "T"};
        } else if(typeOfSequence.equals("RNA")){
            currentValidator = 1;
            nucleotides = new String[]{"A", "C", "G", "U"};
        } else {
            throw new IllegalArgumentException();
        }

        this.validators[currentValidator].checkForInvalidNucleotides(nucleotideSequence);

        for (int i = 0; i < result.length; i++) {
            result[i] = this.getOccurrencesOfNucleotide(nucleotideSequence, nucleotides[i]);
        }

        return result;
    }

    /**
     * Returns the number of times a given nucleotide occurs in given nucleotide sequence
     *
     * @param nucleotideSequence   the string representing the nucleotide sequence
     * @param nucleotide           the given nucleotide to be counted
     * @return                     the number of times the nucleotide occurred in the sequence
     */
    private int getOccurrencesOfNucleotide(String nucleotideSequence, String nucleotide) {

        Pattern pattern = Pattern.compile(nucleotide);
        Matcher matcher = pattern.matcher(nucleotideSequence);
        int counter = 0;
        while(matcher.find()) {
            counter++;
        }

        return counter;
    }


}
