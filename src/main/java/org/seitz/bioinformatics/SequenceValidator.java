package org.seitz.bioinformatics;

import org.seitz.bioinformatics.DNA.InvalidNucleotideException;

/**
 * Interface defining a sequence validator
 */
public interface SequenceValidator {
    void checkForInvalidNucleotides(String nucleotideSequence) throws InvalidNucleotideException;
}
