INITIAL CONFIGURATION:

This is a Java application for storing private notes after encrypting them.
The application is password protected.
**Set password variable in Diary.java file

You need to SET YOUR DEFAULT NOTES DIRECTORY for Windows and linux in Notes.java in these 4 lines:
****        if(System.getProperty("os.name").startsWith("Windows"))
                defaultDirectory="D:\\neeraj\\notes\\";   //replace with your Windows notes directory
            else
                defaultDirectory="/media/Data/neeraj/notes/"; //replace with your Linux notes directory

The right directory will be chosen according to whether you run the app in Linux or Windows.



HOW TO USE(After configuration):
1.)Launch app
2.)Replace "Enter password" with "asd" or whatever password you have chosen.
3.1) You will be automatically shown a file corresponding to today's date e.g. 2015_1_7.txt . If you had written something on today's date early today then it will automatically be shown and available for editing. Otherwise a new file for today e.g. 2015_1_7.txt will be created and you are free to write your thoughts.

3.2)You are free to open old files, edit and save them. However you should only open files that have been saved after encryption via this application.

Enjoy!!!
