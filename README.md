The project "Address book" was used as learning and example project during the Java course at
Vilnius Coding School in the spring 2017. However, lecturer was explaining main principles and
was introducing main classes and a few methods. While fully operational application was 
accomplished as a homework.

This application is console application. Three main subversions were developed: 
1) content of the address book was stored in RAM,
2) content of the address book was stored in XML file,
3) content of the address book was stored in MySQL data base.
Accordingly, entry points of application are:
1) lt.vcs.addresbook.ui.console -> ConsoleApplicationRAM,
2) lt.vcs.addresbook.ui.console -> ConsoleApplicationXmlFile,
3) lt.vcs.addresbook.ui.console -> ConsoleApplicationJavaSqlConn.

The best way to test the application is to run ConsoleApplicationXmlFile when initial content of
the address book is loaded from the XML file. In case of ConsoleApplicationRAM the content of the
address book has to be manually populated every time before other functionality can be tested.
It is possible to test ConsoleApplicationJavaSqlConn; however, MySQL DB has to be installed on the
computer appropriated data base (address_book_MySQL57_DB.zip is attached to the project) imported
into MySQL and appropriate settings should be adjusted.

The functionality of the application is shortly explained immediatly after startup of the
application.
