# Readability_Score

### This is a console program which determines how difficult the text (in English) is and for which age it is most suitable. Program implements four scientific approaches:
### - Automated readability index
### - Flesch–Kincaid readability tests
### - SMOG index
### - Coleman–Liau index

#### To run the program, the user needs to put a file with the analyzed text to the "resources" directory and provide a filename as a command-line parameter. As a result, the program will display a number of: words, sentences, characters, syllables and polysyllables (words with at least 3 syllables), and will ask to choose preferred index. If the user chooses "all" then the program will display estimations for each index, and additionally, the average age based on the aforementioned indexes. If file is not found or file is empty than default values will be displayed.