package com.yzq.javaio;

import org.junit.jupiter.api.Test;

import java.io.File;

/**<p><img src='https://www.runoob.com/wp-content/uploads/2013/12/iostream2xx.png' /></p>
 * @author yanni
 * @date time 2021/10/14 12:11
 * @modified By:
 */
public class FileOperate {
    @Test
    void removeFile() {

        File f = new File("/opt");
        String[] list = f.list();
        assert list != null;
        for (String s : list) {
            File fchild = new File(f + File.separator + s);
            if ("newf".equals(s)) {
                System.out.println("reach newf");
                File newfile = new File("/opt/newf");
                deleteFolder(newfile);
            } else {
                System.out.println("not found");
            }
        }
    }

    private static void deleteFolder(File newf) {
        File[] files = newf.listFiles();
        assert files != null;
        for (File f : files) {
            System.out.println(f.getName());
            if (f.isDirectory()) {
                deleteFolder(f);
            } else {
                f.delete();
            }
        }
        newf.delete();
    }
}
