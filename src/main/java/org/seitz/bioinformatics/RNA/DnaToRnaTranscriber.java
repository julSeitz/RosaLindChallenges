package org.seitz.bioinformatics.RNA;

import org.seitz.bioinformatics.DNA.InvalidNucleotideException;
import org.seitz.bioinformatics.DnaSequenceValidator;

/**
 * Transcribes a DNA sequence to an RNA sequence
 */
public class DnaToRnaTranscriber {

    /**
     * DNA sequence validator
     */
    private final DnaSequenceValidator dnaSequenceValidator;

    /**
     * Constructor taking the DNA sequence validator
     *
     * @param dnaSequenceValidator      DNA sequence validator
     */
    public DnaToRnaTranscriber(DnaSequenceValidator dnaSequenceValidator) {
        this.dnaSequenceValidator = dnaSequenceValidator;
    }

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
        this.dnaSequenceValidator.checkForInvalidNucleotides(dnaSequence);
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
}
