package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//Jsoup对象功能
public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {

        //2.1获取student.xml的path
        String path = JsoupDemo2.class.getClassLoader().getResource("cn/itcast/xml/student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取DOM树-->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);
        //第二种方式 Jsoup.parse(String html): 解析xml或html字符串
        String str = "<!--?xml version=\"1.0\" encoding=\"UTF-8\" ?-->\n" +
                "<html>\n" +
                " <head></head>\n" +
                " <body>\n" +
                "  <students> \n" +
                "   <student number=\"itcast_0001\"> \n" +
                "    <name>\n" +
                "     tom\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     18\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     male\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "   <student number=\"itcast_0002\"> \n" +
                "    <name>\n" +
                "     peny\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     18\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     female\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "  </students>\n" +
                " </body>\n" +
                "</html>\n";
        Document document2 = Jsoup.parse(str);
        System.out.println(document2);

        //3.parse(URL url, int timeoutMillis):通过网络路径获取指定的html或xml文档对象
        URL url = new URL("https://jsoup.org/download");//
        Document document3 = Jsoup.parse(url,10000);
        System.out.println(document3);
    }
}
