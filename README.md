# JSON_Custom_Parser
Finds any JSON file, single or batch, that contains a user-given identifier, and outputs a txt including all file names w/accompanying line

There were over 450 I needed to go through, line by line, identifying the ill-use of global variables in Lua code, executed through a 
C# interface, and make them "local."  This is not exactly a challenging task, but more of a time-consuming task.

So, I wrote this script here to automate it a bit, identify all the instances of this in all of the files, and then not only output a .txt file
with all of the identified files, and the included line-number position, I further automated the script to include the necessary
changes, which was actually easier said than done.

I also built a string output that included the previous unchanged line next to the change line, to verify that it was properly done,
a bit like how version control software shows before and after changes of software through highlighting.
