package Repository;

import org.json.simple.JSONObject;

import java.io.*;
import java.nio.channels.FileChannel;

public class ModifyFiles {

    // Copy the JSON file to save it if there is an error
    public static String saveJSONFile(String linkJSONFile) {
        String extensionRemoved = linkJSONFile.split("\\.")[0];
        String newFile = extensionRemoved + ".copy.json";
        try {
            ModifyFiles.copyFile(linkJSONFile, newFile);
            return newFile;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    // remove the JSON file when it was a copy
    public static void removeCopyJSONFile(String linkJSONFile) {
        String extensionRemoved = linkJSONFile.split("\\.")[0];
        String newFile = extensionRemoved + ".copy.json";
        ModifyFiles.removeFile(newFile);
    }

    // Put the copy of the file on the default path
    public static void reputOriginalJsonFile(String linkJSONFile) {
        String newFile = ModifyFiles.saveJSONFile(linkJSONFile);
        ModifyFiles.removeFile(newFile);
    }

    // remove a file with the path
    public static void removeFile(String linkJSONFile) {
        try {
            File file = new File(linkJSONFile);

            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Copie file with path source and path destination
    public static void copyFile(String s, String d) throws IOException {
        File source = new File(s);
        File dest = new File(d);

        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
    }

    // Generate file
    public static void write(String path, JSONObject jsonObject) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();

            ModifyFiles.removeCopyJSONFile(path);
        } catch (IOException e) {
            // Delete the origial path
            ModifyFiles.removeFile(path);
            // Put the copy on the default file
            ModifyFiles.reputOriginalJsonFile(path);
            e.printStackTrace();
        }
    }
}
