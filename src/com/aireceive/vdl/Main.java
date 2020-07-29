package com.aireceive.vdl;
import java.io.PrintWriter;
public class Main {

    public static void main(String[] args) {
        public static void main(String[] args) {
            String download_path="C:\\videos_downloaded_via_java";
            String url="https://www.youtube.com/watch?v=s34CqtrUS0A";
            String[] command =
                    {
                            "cmd",
                    };
            Process p;
            try {
                p = Runtime.getRuntime().exec(command);
                new Thread(new DLSync(p.getErrorStream(), System.err)).start();
                new Thread(new DLSync(p.getInputStream(), System.out)).start();
                PrintWriter stdin = new PrintWriter(p.getOutputStream());
                stdin.println("cd \""+download_path+"\"");
                stdin.println(download_path+"\\youtube-dl "+url);
                stdin.close();
                p.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
