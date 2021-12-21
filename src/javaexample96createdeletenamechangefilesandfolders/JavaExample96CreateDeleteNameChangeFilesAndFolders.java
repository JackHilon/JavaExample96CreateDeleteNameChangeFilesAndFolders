
package javaexample96createdeletenamechangefilesandfolders;

import java.io.*;


public class JavaExample96CreateDeleteNameChangeFilesAndFolders {

    
    public static void main(String[] args) {
        
        PrintWriter pw = new PrintWriter(System.out, true);
        
        try
        {
            File myFolder = new File("myFolder");
            
            String[] files = myFolder.list();
            
            pw.print("Files: ");
            for (int i = 0; i < files.length; i++) {
                pw.print(files[i] + " ");
            }
            pw.println();
            
            File fil1 = new File(myFolder, files[0]);
            
            // change name
            /*
            fil1.renameTo(fil1);
            ---------------------------------
            Renames the file denoted by this abstract pathname.
            
            Many aspects of the behavior of this method are inherently 
            platform-dependent: The rename operation might not be able to 
            move a file from one filesystem to another, it might not be atomic, 
            and it might not succeed if a file with the destination abstract 
            pathname already exists. The return value should always be 
            checked to make sure that the rename operation was successful.
            
            Note that the Files class defines the move method to move or 
            rename a file in a platform independent manner.
            */
            File f = new File(myFolder, "myNewFile.txt");
            fil1.renameTo(f);
            
            // after name-changing
            files = myFolder.list();
            pw.print("Files (after name changing): ");
            for (int i = 0; i < files.length; i++) {
                pw.print(files[i] + " ");
            }
            pw.println();
            
            // delete all files in myFolder folder
            files = myFolder.list();
            for (int i = 0; i < files.length; i++) {
                fil1 = new File(myFolder, files[i]);
                fil1.delete();
            }
            
            // delete folder
            myFolder.delete();
            
            // create new folder
            myFolder = new File("ThisFolderAfterDeleteOldOne");
            myFolder.mkdir();
            
            // create new file in this folder
            fil1 = new File(myFolder, "thirdNewFile.txt");
            fil1.createNewFile();
            
            
        }// end-try
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        catch(Exception e)
        {
            pw.println(e.toString());
            pw.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
}
