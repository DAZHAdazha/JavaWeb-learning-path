package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//Document/Element对象功能
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {

        //2.1获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("cn/itcast/xml/student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取DOM树-->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.获取元素对象
        //3.1获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);
        System.out.println("------------");
        //3.2获取属性名为id的对象们
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("------------");
        //3.3获取number属性值为itcast_0001
        Elements elements2 = document.getElementsByAttributeValue("number", "itcast_0001");
        System.out.println(elements2);
        System.out.println("----------");

        //3.4获取id属性值的对象 注意这里是返回Element对象
        Element element = document.getElementById("itcast");
        System.out.println(element);
    }
}
