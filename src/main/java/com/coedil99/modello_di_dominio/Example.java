package com.coedil99.modello_di_dominio;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Igor on 23/01/2016.
 */
@XmlRootElement
public class Example {
    private String ciao;
    private String c2;

    public Example() {
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getCiao() {
        return ciao;
    }

    public void setCiao(String ciao) {
        this.ciao = ciao;
    }
}
