package cn.zlion.crawl.retrive;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by zzs on 2016/11/13.
 */
public class RetrivePage {

    /**
     * 简单传入url并获取页面的内容，最后转化为String类型返回, 该方法使用了URL的openstream方法来做
     * @param path 请求的页面url
     * @return 页面的内容，这里是转化为String类型的内容
     * @throws MalformedURLException
     * @throws IOException
     */
    public static String downloadPage(String path)
        throws MalformedURLException, IOException{

        URL pageURL = new URL(path);
        StringBuilder pageBuffer = new StringBuilder();

        /**
         * 1. use bufferReader to read page.
         */
//        BufferedReader reader = new BufferedReader(new InputStreamReader(pageURL.openStream()));
//        String line;
//        while ((line = reader.readLine()) != null){
//            pageBuffer.append(line);
//        }

        /**
         * 2. use scanner to read page.
         */
        //ues scanner to read page data encode with utf-8
        Scanner scanner = new Scanner(new InputStreamReader(pageURL.openStream(), "utf-8"));
        //正则表达式分段读取
        scanner.useDelimiter("\\z");
        while(scanner.hasNext()){
            pageBuffer.append(scanner.next());
        }

        return pageBuffer.toString();
    }

    public static void downloadPageBySocket(String host, int port, String file)
            throws IOException{

        Socket s = new Socket(host, port);
        OutputStream out = s.getOutputStream();
        PrintWriter outw = new PrintWriter(out, false);
        outw.print("GET " + file + " HTTP/1.0\r\n");
        outw.print("Accept: text/plain, text/html, text/*\r\n");
        outw.print("\r\n");
        outw.flush();//song GET command

        InputStream in = s.getInputStream();
        InputStreamReader inr = new InputStreamReader(in, "utf-8");
        BufferedReader br = new BufferedReader(inr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }

}
