# WaffleWords
A Java program for finding waffle words--so called for their similarity to pancake words

WaffleWords.java takes as input an integer and outputs "waffle words" that are the same length as that integer. Waffle words have the following qualities:

1. They are words that can be found in a dictionary (e.g., a text file, such as the one provided, which contain a list of words). 
2. If you choose the right letter to remove from a waffle word, the resulting word will also be a waffle word. The letter that is removed can be at any location in the waffle word.

WaffleWords.java was inspired by the following riddle from Quora (source below): 
	What eight letter word can have a letter taken away and it still makes a word? Take another letter away and it still makes a word. Keep on doing that until you have one letter left. What is that word?

In a separate file called "waffle-words-length-8" I have listed the 1431 waffle words that are answers to this riddle. 

## Usage

WaffleWords.java requires a dictionary of words that is read and added to a dictionary object during the execution of the program. The dictionary object is an ArrayList of ArrayLists of type String. There are 26 "inner" ArrayLists, each corresponding to a letter of the English alphabet and containing an alphabetical list of words from the dictionary text file. 

WaffleWords.java looks for a text file on your desktop called "english-words.txt". The program uses the words in this text file to populate the dictionary object. 


## Note on Intellectual Property

I do not own the dictionary text file "english-words.txt". I found this text file online. You can find the source (ENGLISH - 194,000 words) by following the link below. 

Find english-words.txt here:
<http://www.gwicks.net/dictionaries.htm>

Find Quora riddle here:
<https://www.quora.com/What-eight-letter-word-can-have-a-letter-taken-away-and-it-still-makes-a-word-Take-another-letter-away-and-it-still-makes-a-word-Keep-on-doing-that-until-you-have-one-letter-left-What-is-that-word>
