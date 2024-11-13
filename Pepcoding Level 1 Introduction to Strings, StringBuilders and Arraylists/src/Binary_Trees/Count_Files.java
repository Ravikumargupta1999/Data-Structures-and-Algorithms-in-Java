package Binary_Trees;

import java.io.File;

class DirFileCounter {
    public static void main(String args[]) {
        File directory = new File("E:\\JAVA\\Playlist Code With Harry\\Videos");
        int fileCount = directory.list().length;
        System.out.println("File Count:" + fileCount);
    }
}