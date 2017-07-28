package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.stock.Stok;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;


import java.io.*;
import java.util.Collection;


public class StokFeatFileWorker {
    private XStream xStream;

    public StokFeatFileWorker() {
        xStream = new XStream(new DomDriver());
    }

    public void storeStokToFile(Stok stok, File file) throws IOException {
        xStream.toXML(stok, new FileWriter(file));
    }

    public Stok getStokFromFile(File file) throws FileNotFoundException {
        Stok result = new Stok();
        FileInputStream inputStream = new FileInputStream(file);
        xStream.fromXML(inputStream, result);
        return result;
    }

}
