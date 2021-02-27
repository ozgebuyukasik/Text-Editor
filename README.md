# Text-Editor

Text editor has a text file as dictionary. While user typing text editor get the words and control them if they are exist in dictionary text file. When text editor couldn't find the word in dictionary, it controls single transposition situation. Single transposition is 2 letters that next to each other change places situation. 
For example 
example -> eaxmple
If a word is not in dictionary file and doesn't have single transposition that means this word is invalid. Text editor after user type the word controls all these situations and if a word is invalid write the word in color red. If the word has single transposition, text editor corrects the word.
All operations are processing at the run time.

To write cleaner code, design patterns that listed below are used.
Command, Strategy and Observer Design Patterns.
