package org.seitz.bioinformatics.RNA;


import org.junit.jupiter.api.Test;
import org.seitz.bioinformatics.DNA.InvalidNucleotideException;
import org.seitz.bioinformatics.DnaSequenceValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DnaToRnaTranscriberTest {

    private final DnaToRnaTranscriber transcriber;

    public DnaToRnaTranscriberTest() {
        this.transcriber = new DnaToRnaTranscriber(new DnaSequenceValidator());
    }

    @Test
    public void transcribesDnaToRnaCorrectly() throws SequenceTooLongException, InvalidNucleotideException {
        assertEquals("GAUGGAACUUGACUACGUAAAUU", this.transcriber.transcribeDnaToRna("GATGGAACTTGACTACGTAAATT"));
    }

    @Test
    public void doesNotAcceptTooLongSequences() {
        assertThrows(SequenceTooLongException.class,
                () -> this.transcriber.transcribeDnaToRna("GTGTGGCTAGATCTTAGCTTTCGTCACTAGAGGGCCCACGCTTAGTTTTTATGATCCATTGATCTCCTAGACGCTGCAAGATTTGCAACCAGGCAGACTTAGCGGTAGGTCCTAGTGCAGCGGGACTTTTTTTCTATAGTCGTTGAGAGGAGGAGTCGTCAGACCAGATACCTTTGATGTCCTGATTGGAAGGACCGTTGGCCCCCGACCCTTAGACAGTGTACTCAGTTCTATAAACGAGCTATTAGATATGAGATCCGTAGATTGAAAAGGGTGACGGAATTCGCCCGGACGCAAAAGACGGACAGCTAGGTATCCTGAGCACGGTTGCGCGTCCGAATCAAGCTCCTCTTTACAGGCCCCGGTTTCTGTTGGTCGTAGAGCGCAGAACGGATTGGGGGGATGTACGACAATATCTCTTAGTCACCTTTGGGTCACGGTCTGCTACCTTACAGGAATTCAGACCGTCCTTTAATTTCCCTTGCATATATGTTGCGTTTCTTCGACCTTCTAACCGCACCCTTAGGACGAAGACAGATACGTTCTTACCCATACTCCACCGTTGGCAGCGGGATCGCATGTCCCACGTGAAACATTGCTAAACCCTCAGGCCTCTGAGCGACAAAAGCTTTAAAGGGAAATTCGCGCCCATAACTTGGTCCGAATACGGGTTCTAGCATCGTTCGTCTGAGTTTGTTCTATATAAAACGGGCGCAATGTCTGCTTTGATCAACCTCCAATACCTCGTATGATTGTGCACCCGCCGGTGACCACTCAATGATGTGGGGTCCCCGTTGCAACTACGAGGATTTATTGAGACCGACCTACGTTCGGCATTGTGGGCAGAGTGAAGTATTGGCAAACGTTAAGTGCCGAACTAGATCTGACCTAACGGTAAGAGAGTTTCATAATACGTCCAGCCGCATGCGCAGGGTACATTTGGACAGTATTGAATGGACTCTGATCAACCTTCACACCGATCTAGAAACGAGTGCGTAGAT"));
    }

    @Test
    public void onlyAcceptsValidDnaSequence() {
        assertThrows(InvalidNucleotideException.class,
                () -> this.transcriber.transcribeDnaToRna("AGCTH"));
    }
}
