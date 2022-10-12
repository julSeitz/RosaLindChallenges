package org.seitz.bioinformatics;

import org.seitz.bioinformatics.DNA.InvalidNucleotideException;
import org.seitz.bioinformatics.RNA.DnaToRnaTranscriber;
import org.seitz.bioinformatics.RNA.SequenceTooLongException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your DNA sequence:");
        Scanner scanner = new Scanner(System.in);
        String dnaSequence = scanner.nextLine();
        DnaToRnaTranscriber transcriber = new DnaToRnaTranscriber(new DnaSequenceValidator());
        try {
            System.out.println(transcriber.transcribeDnaToRna(dnaSequence));
        } catch (InvalidNucleotideException | SequenceTooLongException e) {
            e.printStackTrace();
        }
    }
}