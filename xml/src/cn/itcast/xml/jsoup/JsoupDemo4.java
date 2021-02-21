package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

//Element对象功能
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {

        //2.1获取student.xml的path
        String path = JsoupDemo4.class.getClassLoader().getResource("cn/itcast/xml/student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取DOM树-->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //通过Document对象获取name标签，获取所有的name标签，可以获取两个
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());

        //获取子标签对象 只能获取一个
        Element element_student = document.getElementsByTag("student").get(0);
        Elements elements1 = element_student.getElementsByTag("name");
        System.out.println(elements1.size());

        //获取student对象的属性值，不区分大小写
        String number = element_student.attr("nuMbEr");
        System.out.println(number);

        //获取文本内容
        String text1 = elements.text();
        String html = elements.html();
        System.out.println(text1);
        System.out.println(html);
    }
}
