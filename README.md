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
