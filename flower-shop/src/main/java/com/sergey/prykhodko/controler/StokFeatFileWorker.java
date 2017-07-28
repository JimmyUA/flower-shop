package com.sergey.prykhodko.controler;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ListsFeatFileWorker {
    private XStream xStream;

    public ListsFeatFileWorker() {
        xStream = new XStream(new DomDriver());
    }

    public void storeListToFile(List list, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.write(xStream.toXML(list));
    }

    public List getListFromFile(File file) throws FileNotFoundException {
        List result = new ArrayList();
        FileInputStream inputStream = new FileInputStream(file);
        xStream.fromXML(inputStream, result);
        return result;
    }
}
