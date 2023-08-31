package de.lisa.studiumsorganisationswebscraper.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDFReader {
    public static HashSet<String> allModules = new HashSet<>();

    public static void analysePDFFiles() {
        File folder = new File("downloads");
        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                allModules.addAll(extractModuleNames(fileEntry));
            }

        }
        System.out.println("All module names:");
        for (String moduleName : allModules) {
            System.out.println(moduleName);
        }
    }

    public static List<String> extractModuleNames(File file) {
        List<String> moduleNames = new ArrayList<>();
        try {
            //create pdf document object from file
            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);

            // Matches "CVH-* SPACE *Prof." and captures the *.
            Pattern pattern = Pattern.compile("(?<=CVH-(BA|MA)-[A-Z1-9]*\\s)[^\\d]+?(?=\\sProf.|\\sN\\.N\\.)");
            Matcher matcher = pattern.matcher(text);
           while (matcher.find()) {
                moduleNames.add(matcher.group());
            }
            Pattern pattern2 = Pattern.compile("(?<=[)-]\\s)[A-Za-z]*[A-Za-z][A-Za-z][A-Za-z]*[^\\d]*(?=\\s\\d)");
            Matcher matcher2 = pattern2.matcher(text);
          
            while (matcher2.find()) {
                moduleNames.add(matcher2.group());
            }
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return moduleNames;
    }

    

}
