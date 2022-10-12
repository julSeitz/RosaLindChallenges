package org.seitz.bioinformatics.REVC;

import org.seitz.bioinformatics.DNA.InvalidNucleotideException;
import org.seitz.bioinformatics.DnaSequenceValidator;
import org.seitz.bioinformatics.RNA.SequenceTooLongException;

/**
 * Generates the reverse complement of a given DNA sequence
 */
public class ReverseComplementer {

    /**
     * DNA sequence validator
     */
    private final DnaSequenceValidator validator;

    /**
     * Constructor taking DNA sequence validator
     *
     * @param validator         the DNA sequence validator
     */
    public ReverseComplementer(DnaSequenceValidator validator) {
        this.validator = validator;
    }

    /**
     * Returns the reverse complement of a given sequence of DNA
     *
     * @param dnaSequence                   the string representing the DNA sequence
     * @return                              the reverse complement of the DNA sequence
     * @throws SequenceTooLongException     thrown if given DNA sequence is longer than 1000 nucleotides
     * @throws InvalidNucleotideException   thrown if given DNA sequence contains invalid nucleotides
     */
    public String getReverseComplement(String dnaSequence) throws SequenceTooLongException, InvalidNucleotideException {

        if (dnaSequence.length() > 1000) {
            throw new SequenceTooLongException();
        }
        this.validator.checkForInvalidNucleotides(dnaSequence);
        return this.generateReverseComplement(dnaSequence);
    }

    /**
     * Generate and return reverse complement of given DNA sequence
     *
     * @param dnaSequence   the string representing the DNA sequence
     * @return              the reverse complement of the DNA sequence
     */
    private String generateReverseComplement(String dnaSequence) {

        StringBuilder reverseComplement = new StringBuilder();
        String reversedDnaSequence = new StringBuilder(dnaSequence).reverse().toString();

        for (int i = 0; i < dnaSequence.length(); i++) {
            switch (reversedDnaSequence.charAt(i)) {
                case 'A' -> reverseComplement.append("T");
                case 'T' -> reverseComplement.append("A");
                case 'G' -> reverseComplement.append("C");
                case 'C' -> reverseComplement.append("G");
            }
        }
        return reverseComplement.toString();
    }
}
