package org.seitz.bioinformatics;

import org.seitz.bioinformatics.DNA.InvalidNucleotideException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of SequenceValidator to validate DNA sequences
 */
public class DnaSequenceValidator implements SequenceValidator {

    /**
     * Throws exception if given DNA sequence contains invalid nucleotides
     *
     * @param dnaSequence                   the string representing the given DNA sequence
     * @throws InvalidNucleotideException   thrown in case DNA sequence contains invalid nucleotides
     */
    @Override
    public void checkForInvalidNucleotides(String dnaSequence) throws InvalidNucleotideException {
        Pattern pattern = Pattern.compile("[^ACGT]");
        Matcher matcher = pattern.matcher(dnaSequence);
        if (matcher.find()) {
            throw new InvalidNucleotideException();
        }
    }
}
