package de.lisa.studiumsorganisationswebscraper;

import de.lisa.studiumsorganisationswebscraper.controller.PDFReader;

public class Main {
    public static void main(String[] args) {
     /*   Webscraper.scrapeWebPage("https://www.hochschule-bochum.de/studium-lehre/studienangebote/masterstudiengaenge/");
        Webscraper.scrapeWebPage("https://www.hochschule-bochum.de/ba-studium/");
       */ PDFReader.analysePDFFiles();
        System.out.println(PDFReader.allModules.size());
    }
}
