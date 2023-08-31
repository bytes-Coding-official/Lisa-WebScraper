# Web Scraper and PDF Analyzer

This is a Java project that performs web scraping and PDF analysis on specific web pages to extract and list certain module names from PDF files. 

## Components

1. `Webscraper`: This class connects to the provided URLs and downloads PDF files found within certain specified elements on the page. It then saves these PDFs to a 'downloads' directory.

2. `PDFReader`: This class loads the downloaded PDFs from the 'downloads' directory and analyzes the text. It extracts module names based on specific patterns and lists the different module names found across all PDFs. 

3. `Main`: This is the main class that calls functions of the `Webscraper` and `PDFReader` classes to perform the web scraping and PDF analysis operations.

## Usage

Run the `Main` class' `main` method. This will start the web scraping process for the specified URLs and then analyze all downloaded PDFs. 

The output will be the list of unique module names found within the analyzed PDF files, along with the total number of unique module names. 

## Note

The project requires certain dependencies such as Jsoup for web scraping and Apache PDFBox for PDF analysis.
