package cn.xu419.util;

import cn.xu419.domain.Radio;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLtransverter {
    private XMLtransverter(){}


    public static List<Radio> xmlToRadios(String XMLpath){
        List<Radio> list = new ArrayList<>();
        try {
            System.out.println("开始解析XML");
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = db.parse(XMLpath);

            NodeList radios = document.getElementsByTagName("radio");
            Radio newRadio = new Radio();
            for (int i = 0; i < radios.getLength(); i++) {
                Node radio = radios.item(i);
                NamedNodeMap namedNodeMap = radio.getAttributes();
                newRadio.setCourse(namedNodeMap.item(0).getTextContent());
                newRadio.setNum(Integer.parseInt(namedNodeMap.item(1).getTextContent()));
                newRadio.setScore(Integer.parseInt(namedNodeMap.item(2).getTextContent()));
                NodeList option = radio.getChildNodes();
                newRadio.setStem(option.item(0).getNodeValue());
                newRadio.setOptionOne(option.item(1).getNodeValue());
                newRadio.setOptionTwo(option.item(2).getNodeValue());
                newRadio.setOptionThree(option.item(3).getNodeValue());
                newRadio.setOptionFour(option.item(4).getNodeValue());

                System.out.println(newRadio.getStem());

                list.add(newRadio);


            }
            System.out.println("XML解析结束");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("XML解析失败");
        }
        return list;
    }
    public static void radiosToXml(String XMLpath,List<Radio> list){
        System.out.println("开始生成XML");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();
            Element radios = document.createElement("radios");

            System.out.println("共有"+list.size()+"道题");

            for (int i = 0; i < list.size(); i++) {
                Element radio = document.createElement("radio");
                radio.setAttribute("num",String.valueOf(list.get(i).getNum()));
                radio.setAttribute("score",String.valueOf(list.get(i).getScore()));
                radio.setAttribute("course",String.valueOf(list.get(i).getCourse()));

                Element stem = document.createElement("stem");
                stem.setTextContent(list.get(i).getStem());
                Element optionOne = document.createElement("optionOne");
                optionOne.setTextContent(list.get(i).getOptionOne());
                Element optionTwo = document.createElement("optionTwo");
                optionTwo.setTextContent(list.get(i).getOptionTwo());
                Element optionThree = document.createElement("optionThree");
                optionThree.setTextContent(list.get(i).getOptionThree());
                Element optionFour = document.createElement("optionFour");
                optionFour.setTextContent(list.get(i).getOptionFour());
                radio.appendChild(stem);
                radio.appendChild(optionOne);
                radio.appendChild(optionTwo);
                radio.appendChild(optionThree);
                radio.appendChild(optionFour);
                radios.appendChild(radio);
            }
            document.appendChild(radios);


            Transformer tf = TransformerFactory.newInstance().newTransformer();

            tf.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            File file = new File(XMLpath);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fileOutputStream);

            tf.transform(new DOMSource(document),new StreamResult(pw));

        } catch (ParserConfigurationException | TransformerException | FileNotFoundException e) {
            System.out.println("XML文件生成出错！");
            e.printStackTrace();
        }
    }
}
