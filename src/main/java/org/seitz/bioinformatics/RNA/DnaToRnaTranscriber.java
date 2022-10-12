package org.seitz.bioinformatics.RNA;

import org.seitz.bioinformatics.DNA.InvalidNucleotideException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Transcribes a DNA sequence to an RNA sequence
 */
public class DnaToRnaTranscriber {

    /**
     * Transcribes a DNA sequence to an RNA sequence.
     * Throws exceptions in case of invalid DNA sequence or a sequence longer than 1000 nucleotides
     *
     * @param dnaSequence                   the string representing the given DNA sequence
     * @return                              the string representing the transcribed RNA sequence
     * @throws SequenceTooLongException     thrown in case DNA sequence is longer than 1000 nucleotides
     * @throws InvalidNucleotideException   thrown in case DNA sequence contains invalid nucleotides
     */
    public String transcribeDnaToRna(String dnaSequence) throws SequenceTooLongException, InvalidNucleotideException {
        this.checkSequenceLength(dnaSequence);
        this.checkForInvalidNucleotides(dnaSequence);
        return dnaSequence.replace('T', 'U');
    }

    /**
     * Throws exception if given DNA sequence is longer than 1000 nucleotides
     *
     * @param dnaSequence                   the string representing the given DNA sequence
     * @throws SequenceTooLongException     thrown in case DNA sequence is longer than 1000 nucleotides
     */
    private void checkSequenceLength(String dnaSequence) throws SequenceTooLongException {
        if (dnaSequence.length() > 1000) {
            throw new SequenceTooLongException();
        }
    }

    /**
     * Throws exception if given DNA sequence contains invalid nucleotides
     *
     * @param input                         the string representing the given DNA sequence
     * @throws InvalidNucleotideException   thrown in case DNA sequence contains invalid nucleotides
     */
    private void checkForInvalidNucleotides(String input) throws InvalidNucleotideException {
        Pattern pattern = Pattern.compile("[^ACGT]");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new InvalidNucleotideException();
        }
    }
}
