package org.seitz.bioinformatics;

import org.seitz.bioinformatics.DNA.InvalidNucleotideException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of SequenceValidator to validate RNA sequences
 */
public class RnaSequenceValidator implements SequenceValidator {

    /**
     * Throws exception if given RNA sequence contains invalid nucleotides
     *
     * @param rnaSequence                   the string representing the given RNA sequence
     * @throws InvalidNucleotideException   thrown in case DNA sequence contains invalid nucleotides
     */
    @Override
    public void checkForInvalidNucleotides(String rnaSequence) throws InvalidNucleotideException {
        Pattern pattern = Pattern.compile("[^ACGU]");
        Matcher matcher = pattern.matcher(rnaSequence);
        if (matcher.find()) {
            throw new InvalidNucleotideException();
        }
    }
}
