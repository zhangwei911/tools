package com.viz.tools.file;

import android.content.Context;
import com.viz.tools.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by viz on 2014/11/11.
 */
public class FileManager {
    private Context context;

    public FileManager(){

    }

    //得到传入的上下文对象的引用
    public FileManager(Context context) {
        this.context = context;
    }

    /**
     * 保存文件
     *
     * @param fileName 文件名
     * @param content  文件内容
     * @throws Exception
     */
    public void save(String fileName, String content) throws Exception {

        // 由于页面输入的都是文本信息，所以当文件名不是以.txt后缀名结尾时，自动加上.txt后缀
//        if (!fileName.endsWith(".txt")) {
//            fileName = fileName + ".txt";
//        }

        byte[] buf = fileName.getBytes("iso8859-1");

        Log.e(new String(buf, "utf-8"));

        fileName = new String(buf, "utf-8");

        Log.e(fileName);

        // Context.MODE_PRIVATE：为默认操作模式，代表该文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖原文件的内容，如果想把新写入的内容追加到原文件中。可以使用Context.MODE_APPEND
        // Context.MODE_APPEND：模式会检查文件是否存在，存在就往文件追加内容，否则就创建新文件。
        // Context.MODE_WORLD_READABLE和Context.MODE_WORLD_WRITEABLE用来控制其他应用是否有权限读写该文件。
        // MODE_WORLD_READABLE：表示当前文件可以被其他应用读取；MODE_WORLD_WRITEABLE：表示当前文件可以被其他应用写入。
        // 如果希望文件被其他应用读和写，可以传入：
        // openFileOutput("output.txt", Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);

        FileOutputStream fos = context.openFileOutput(fileName,Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
        fos.write(content.getBytes());
        fos.close();
    }

    /**
     * 读取文件内容
     *
     * @param fileName 文件名
     * @return 文件内容
     * @throws Exception
     */
    public String read(String fileName) throws Exception {

        // 由于页面输入的都是文本信息，所以当文件名不是以.txt后缀名结尾时，自动加上.txt后缀
        if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }

        FileInputStream fis = context.openFileInput(fileName);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];
        int len = 0;

        //将读取后的数据放置在内存中---ByteArrayOutputStream
        while ((len = fis.read(buf)) != -1) {
            baos.write(buf, 0, len);
        }

        fis.close();
        baos.close();

        //返回内存中存储的数据
        return baos.toString();

    }

    /**
     * 递归删除 文件/文件夹
     *
     * @param file
     */
    public static void deleteFile(File file) {

//        Log.i("delete file path=" + file.getAbsolutePath());

        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
            file.delete();
        } else {
//            Log.e("delete file no exists " + file.getAbsolutePath());
        }
    }
}
