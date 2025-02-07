# final_Project

10/17/23 Part 1:
* Added all files in project.

10/18/23 Part 1:
* Added phase 1 sheet.
* Removed unneeded import, added a definition of phoneNum variable, and implemented the textColors interface into the Contacts.java.

10/19/23 Part 1:
* Added a condition in the comparable method in contacts to see if the last names are equal, then goes to the first name if yes.
* Fixed response to an empty arraylist in Main.java.

10/21/23 Part 1:
* Added checks in the set first and last name methods to see if the input was null or empty.
* Changed return in first char to upper to not set it to str when it returns.

10/24/23 Part 1:
* Added a contacts interface to guide the making of my class and implemented it into the contacts class.
* Added more constructors in the contacts class.
* Removed set Creation Time method.
* Added address, birthday, and notes variables and added setters and getters for those.
* Fixed the compareTo method to better sort the list, ie checks the first name if the last names are the same.

10/25/23 Part 1:
* Commented unneeded variables in the textColor interface.
* Changed some variable names in the contactInterface and reflected it in the contact class.
* Touched up the constructors in the contact class and a few text color changes.
* Added the method structures of the needed methods in the main class and adjusted the class as such.

10/25/23 Part 2:
* Added the javadocs of the project into a created folder called javadocs.

10/26/23 Part 1:
* Removed a constructor in contact.
* Removed an unneeded comment in main.java.
* Updated javadoc folder.

10/26/23 Part 2:
* Added conditions in the set birthday method.
* Consolidated the boolean in the isLeapYear method.
* Updated javadocs folder.

10/26/23 Part 3:
* Removed some unneeded comments.

10/26/23 Part 4:
* Added comments in the contactsInterface class and added getName() method.
* Implemented the get name method in the contact class.
* Switched the format of the return of the birthdate from mm/dd/yy to mm/dd/yyyy in contact class.
* Updated javadocs folder.

10/26/23 Part 5:
* Added comments in the text colors interface and contact class.
* Added a check in firstChartoUpper to see if it's null, have it return null and see if string to see if it's empty and return "".
* Also removed some more unneeded comments.
* Updated javadocs folder.

10/26/23 Part 6:
* Added comments in main class.
* Updated javadocs.

10/26/23 Part 7:
* Added phase 2 doc.
* Moved all project docs to project docs/ folder.

10/27/23 Part 1:
* Fixed the javadocs comments.

10/27/23 Part 2:
* More fixes to the javadocs comments.

10/28/23 Part 1:
* Made some parameters in methods check if parameter is not null in the main and contact classes.
* Change the coloring in the toString return in Contact class.

10/28/23 Part 2:
* Filled in the returnContact method in main class.
  * Changed it from one contact to potentially multiple contacts with given name.
  * Also added a better javadocs method.

10/28/23 Part 3:
* Added @throws in the javadocs in contacts and main classes.
* Fixed up conditions in returnContact method to look more closely for "first" and "last" in first input.
* Updated javadocs folder.
* Touched up all the javadocs comments in all classes.

10/28/23 Part 4:
* Fixed comments in the contact class and interface contactInterface; switched where the @see were in all methods and got rid of unneeded overriding @param.

10/28/23 Part 5:
* Fixed the javadocs folder.

10/29/23 Part 1:
* Removed the sleep method from Main class and adjusted code as such.
* Updated a few comments in main class as well.
* Updated the Javadocs folder.

10/29/23 Part 2:
* Fixed comments in contact class to inherit all of the comments from the interface.
* Updated the Javadocs folder.

10/30/23 Part 1:
* Switched all signatures that had @NotNull in them to not at all and used conditions in those methods to check if they're null.
* Added isNull method in Main class.
* Fixed return in getNotes method in contact class.

10/30/23 Part 2:
* Removed unneeded lines of code in the firstCharToUpper method in contact class.
* Removed unneeded comments in the main class.

10/30/23 Part 3:
* Removed unneeded lines of comments/code in the textColor interface.
* Updated the Javadocs folder.

10/30/23 Part 4:
* Removed unneeded lines of comments/code in the textColor interface.

11/1/23 Part 1:
* Got rid of an unneeded comment in the returnContact method in main class and also changed the toLowerCase.
* Changed the return methods in the contact class to return the N/A in each variable as red and then resets it.
* Fixed toString in Contact class.
* Fixed getName method to return "no name given" if there's no first and last name.
* Edited code to start taking input from user to see what they would like to do with contact list.
* Added shut down hook to say thanks for using program.
* Updated javadocs folder.

11/1/23 Part 2:
* Updated comments in the textClasses interface.
* Updated javadocs folder.

11/2/23 Part 1:
* Updated comments in the textClasses interface.
* Updated javadocs folder.
* Added DrawingPanel and added some code to adjust to it for fun.
* Made scanner and the arraylist final in main class.

11/2/23 Part 2:
* Removed DrawingPanel and any code associated with it.
* Updated javadocs folder.
* Added a condition in the remove method to see if the contact list is empty. If true, it returns saying there's no list.

11/2/23 Part 3:
* Got rid of the gitIgnore since it's unneeded.
* Changed option message in the main class to be clearer.
* Added a check in edit method in main class to see if the contact list is empty or not. If yes, rejects the user from trying to edit a contact.
* Added the YELLOW_BOLD_BRIGHT variable in textColors interface and implemented it in the main class in the input message.
* Removed unneeded printlns in main method in main class.
* Updated javadocs folder.

11/3/23 Part 1:
* Added functionality to the add contact method in main class.

11/3/23 Part 2:
* Fixed what happens in a catch in the add method of main to skip the conditions if invalid input type.
* Removed unneeded commented out lines of code in textColors interface.
* Fixed a few comments in main class.
* Moved some code around to make the conditions first in the returnContact method in main.
* Added new lines in the printContacts list to space out the contacts as they print.
* Added cleanlist method in main class to remove any and all empty contacts.
  * Added usage of it in the addContact method.
* Added the isContactEmpty method in contact class to see if all of the variables are not defined.
  * Added in interface as well.
* Updated javadocs folder.

11/4/23 Part 1:
* Added a condition in range method option to see if the contact list is empty or not. Can't print if there's nothing in the list.
* Fixed a few comments in contact class.
  * Removed a @throw that wasn't actually being thrown in the method.
  * Added a @throw in a method that was.

11/5/23 Part 1:
* Added functionality to the range method in main class.
* Created IllegalLengthException class for when there's an illegal length of input or variables and implemented in the classes.
  * Updated javadocs to mention the throw.
* Fixed up some javadocs comments.
* Updated javadocs folder.
* Renamed package name.
* Added better functionality to the setPhoneNumber method in contact class.

11/11/23 Part 1:
* Changes the compare to method in contact class to look more at the variables, not the methods.
* Added creation time in the toString method in contact.
* Added color to the println in the closing thread and closed the scanner too in main class.
* Added an option to print a contact and implemented the method for it.
  * Changed the method with the arraylist return to only print the one contact instead.
* Updated the switch and enhanced it.
* Added/removed some comments.
* Implemented the remove method.
* Moved the check to see if the characters given from the user in the range method are digits or not into the other range method.
* Updated Javadocs folder.

11/13/23 Part 1:
* Added a cleanList call in each method in main class.
* Renamed package the project is in.

11/14/23 Part 1:
* Replaced a few conditions in contact class to be more universal.
* Updated the aesthetics of some of the prints.
* Added functionality to edit method in the main class.
* Removed unused variables in the textColors Class.
* Updated javadocs folder.
* Changed all e.toString() to e.getMessage() (in try catches for the Exceptions).

11/15/23 Part 1:
* Removed unneeded comments.

11/19/23 Part 1:
* Removed unneeded lines of code.
* Fixed a parameter.
* Updated javadocs folder.

11/24/23 Part 1:
* Moved some and/or added some "\n" in needed places in main class.

11/26/23 Part 1:
* Added a throw null exception in set date.

11/26/23 Part 2:
* Made some methods that are universal public in main class and contact class.
* Removed unneeded comments in the contact class.
* Updated javadocs folder.

11/28/23 Part 1:
* Fixed the clean list method/handling in main class.
* Fixed the is empty contact method in contact class.
  * Implemented boolean that turns to false if something has been added to the contact.
* Updated Javadocs folder.
* Made sure that the list sorts in each method that need to print the list in main.

12/2/23 Part 1:
* Fixed some comments in main and contact classes.
  * Updated javadocs folder.
* Fixed imports in main class.

12/2/23 Part 2:
* Fixed compareTo method in contact class to sort by creation time if the 2 contacts have the same first and last name.
* Changed isNull method to ensureNotNull.
  * Checks if the object given is null. If it is, it'll throw an exception with given error message.
  * Implemented the method into the rest of the class.
* Updated javadocs folder.

12/2/23 Part 3:
* Removed isNull Method in main class since it is only used once.
  * Used the ensureInRange method in contacts instead for the only use of isNull in main.
* Updated comments in classes.
* Updated javadocs.

12/4/23 Part 1:
* Fixed thread to shorten it in main class (shutdown thread).

12/4/23 Part 2:
* Realigned the contacts interface and the exception class.
* Removed some unneeded lines in all of the files.

12/5/23 Part 1:
* Made messages to user more clear on the instructions on handling and inputting/editing their contacts in the main class.
* Added in the range method to say there aren't any contacts in that range if there aren't any.
* Updated the setPhoneNumber method to add dashes to the phone number when it is certain lengths in contact class.
  * Specifically for when it is length 6, 7, 8, and 9 (on top of when it is length 10).
* Fixed compareTo method in contact class to compare the creation dates more properly.

12/5/23 Part 2:
* Changed condition in setPhoneNumber method to check the length to see if it is also bigger than 10.
  * Throws exception if it is.

12/5/23 Part 3:
* Added a pdf file to explain how to use the project.
* Modified phase 2 doc to update the methods used in project.

12/5/23 Part 4:
* Fixed a javadoc comment (made the link in colorText interface open in new tab).
* Updated javadocs folder.

12/7/23 Part 1:
* Enhanced the range method.
* Added the gitignore

12/7/23 Part 2:
* Fixed invalid input statements in main class to specify that the input must be numbers or in range of the menu numbers.

12/7/23 Part 3:
* Deleted the ensureNotNull method in contact class and replaced all uses of it in program with 'Objects.requireNonNull'.
* Updated javadocs folder.

12/12/23 Part 1:
* Updated the phase 2 doc.
* Added in a condition in the set names to see if the first letter of the first and last names were letters in contact class.

12/12/23 Part 2:
* Removed unneeded @Override in Contact class.

12/12/23 Part 3:
* Created a file and added it to gitignore since it is not needed for the public eye.

12/12/23 Part 4:
* Updated gitignore and some project docs.

12/20/23 Part 1:
* Made the requireNonNull method into the method call in main class instead of being two lines.
* Adjusted some javadocs comments in contact class.
  * Updated javadocs folder.

12/24/23 Part 1:
* Removed unneeded code and condensed other spots that could be condensed.

12/28/23 Part 1:
* setPhoneNumber method in Contact class:
  * Simplified code.
  * Added a check to see if it contains letters and non-dash punctuation. If so, throws an exception.
  * Updated javadocs comment.
* Updated javadocs folder.

12/28/23 Part 2:
* Fixed problems with the setPhoneNumber method in contact class, specifically checking for punctuation.
* Also added a check in setPhoneNumber to see if the first and last characters are dashes.
  * Updated the javadoc comment and folder.
* Fixed getNotes method in contact class to add some color to it.
  * Updated the toString to accommodate.

12/29/23 Part 1:
* Touched up some of the code in the Main class.

10/2/24 Part 1:
* In contact, added last updated variable and setter and getter for it and added it to every method that sets variables and the toString().
* Added a date format variable since it is needed across the Contact program now.
* Added compareDate method to make sure the date given for the birthday isn't after the current one.
* Enhanced the isLeapYear method.
* Updated javadocs folder.
* Made small logistic changes to Main that doesn't affect anything.

2/6/25 Part 1:
* Updated setUpdatedTime method to be set directly from the system time.
* Better checked the last names in print in range method in main.
* Made Contact class cloneable and implemented a method and private constructor for it.
* Made date formatter in contact M/d/yyyy instead of M/dd/yyyy.
* Updated Javadocs folder.
