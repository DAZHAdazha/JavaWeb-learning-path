package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

//选择器查询
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {

        //2.1获取student.xml的path
        String path = JsoupDemo5.class.getClassLoader().getResource("cn/itcast/xml/student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取DOM树-->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.查询name标签
        Elements elements = document.select("name");
        System.out.println(elements);

        //4.查询id值为itcast的元素
        System.out.println("--------------------");
        Elements elements1 = document.select("#itcast");
        System.out.println(elements1);

        //5.获取student标签并且number属性值为itcast_0001的age子标签
        System.out.println("--------------------");
        //5.1 获取student标签并且number属性值为itcast_0001
        Elements elements2 = document.select("student[number='itcast_0001']");
        //5.2 获取age子标签
        Elements elements3 = document.select("student[number='itcast_0001'] > age");
        System.out.println(elements3);
    }
}
