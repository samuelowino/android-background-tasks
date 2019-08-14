package org.aplusscreators.background_task_labs.files;

import android.content.Context;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void createInternalStorageFile(Context context, String filename) {
        File file = new File(context.getFilesDir(), filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File[] readInternalFileSystem(Context context) {
        File[] files = context.getFilesDir().listFiles();

        return files;
    }
}
