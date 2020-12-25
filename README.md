In the epamTests project created 7 successful tests out of 8.
In the last test, the .hover () method does not have time to work out clickOnButtonLAboutTab
Actions actions = new Actions(driver);
actions.moveToElement(aboutTab).build().perform();
I used MacOS and Intellij Idea
Also required for work Automation API WebDriver and Testing Framework NUnit
To run the tests you only need to go to Intellij Idea, open the epamTests project and start it by clicking "Run"
