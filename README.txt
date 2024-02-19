Mortage Plan

This application shows you your monthly payment amount for your mortage.

How to use the application:
    1. Go to MortagePlan > src > main.MortageCalculator.java.
    2. In the private void readFile(), change the String pathname to the path to or name of your file.
    3. Run the application.

File format:
    * The file should be in the following format:
        -  the first line is ignored, meant for a local header
        - each customer has one line
        - the order of the data should be: Customer, Total loan, Interest, Years

Testing
    * you might have to add junit or jupiter to your classpath in order for the code to work
    * changing the set methods and the asserts allows for modification of the tests

Debugging:
    * Check the file provided and how the data is written
    * Check the pathname given and the location of your file