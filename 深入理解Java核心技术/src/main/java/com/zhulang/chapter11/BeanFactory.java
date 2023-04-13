package com.zhulang.chapter11;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射与工厂模式实现IOC
 * @Author zhulang
 * @Date 2023-03-28
 **/
public class BeanFactory {
    private static Map<String, Object> beanMap = new HashMap<>();


    static {
        initialization();
    }
    
    public Object getBean(String name){
        return beanMap.get(name);
    }
    
    private static void initialization(){
        Document document = null;
        try {
            DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = bdf.newDocumentBuilder();
            // 注意路径怎么取相对路径
            document = documentBuilder.parse("/Users/zhulang013/IdeaProjects/JavaAlgorithm/深入理解Java核心技术/src/main/resources/bean.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        NodeList beanNodes = document.getElementsByTagName("bean");
        
        for (int i = 0; i < beanNodes.getLength(); i++){
            Element bean = (Element) beanNodes.item(i);

            NodeList childNodes = bean.getChildNodes();
            Map<String, String> attributeMap = getAttribute(childNodes);
            
            String id = bean.getAttribute("id");
            String beanClass = bean.getAttribute("class");
            
            Object instance = null;
            try {
                Class clazz = Class.forName(beanClass);
                instance = clazz.newInstance();

                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields){
                    field.setAccessible(true);
                    String name = field.getName();
                    field.set(instance, attributeMap.get(name));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            beanMap.put(id, instance);
        }
    }

    private static Map<String, String> getAttribute(NodeList attributeNodes){
        Map<String, String> keyValue = new HashMap<>();
        for (int i = 0; i < attributeNodes.getLength(); i++){
            Node filed = attributeNodes.item(i);
            if (filed.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) filed;
                String fileName = element.getAttribute("name");
                String value = element.getFirstChild().getNodeValue();
                keyValue.put(fileName, value);
            }
        }
        return keyValue;
    }
}
