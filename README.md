Image-Lister
============

Java EE 6 app that displays image thumbnails and allows user to remove images within a directory and subdirectories. Security is implemented via password. Does not require a database.

This app's security and directories is based on app.properties file, which has a format of:

Valid properties are 'pass' and 'baseDir'

For example, to create a user named 'testuser' with a password of 'testpass' and whose image directory is located at '/home/testuser/images', the file would read:

testuser.pass = testpass testuser.baseDir = /home/testuser/images

For Windows, the baseDir would be in the 'DRIVE:/PATH' format: Ex: C:/tmp/imglister/images

To add more users, simply add more users using the same properties. 

