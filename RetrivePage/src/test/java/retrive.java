import cn.zlion.crawl.retrive.RetrivePage;
import org.junit.Test;

/**
 * Created by zzs on 2016/11/13.
 */
public class retrive {

    @Test
    public void retrivePageTest()
        throws Exception{
//        String url = "http://www.baidu.com";
//        System.out.println(RetrivePage.downloadPage(url));

        String host = "www.baidu.com";
        int port = 80;
        String file = "/index.html";
        RetrivePage.downloadPageBySocket(host, port, file);
    }

}
