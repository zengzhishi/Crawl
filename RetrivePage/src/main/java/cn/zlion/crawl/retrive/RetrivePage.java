package cn.zlion.crawl.retrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zzs on 2016/11/13.
 */
public class RetrivePage {

    /**
     * 简单传入url并获取页面的内容，最后转化为String类型返回
     * @param path 请求的页面url
     * @return 页面的内容，这里是转化为String类型的内容
     * @throws MalformedURLException
     * @throws IOException
     */
    public static String downloadPage(String path)
        throws MalformedURLException, IOException{

        URL pageURL = new URL(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(pageURL.openStream()));
        String line;
        StringBuilder pageBuffer = new StringBuilder();
        while ((line = reader.readLine()) != null){
            pageBuffer.append(line);
        }
        return pageBuffer.toString();
    }

}
