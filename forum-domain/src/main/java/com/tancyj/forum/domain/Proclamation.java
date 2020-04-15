package com.tancyj.forum.domain;

import com.tancyj.forum.utils.DateUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

public class Proclamation implements Serializable {
    private Integer proid;
    private String procontent;
    private Integer prosta;
    private Date prodate;
    private String prodateStr;

    @Override
    public String toString() {
        return "Proclamation{" +
                "proid=" + proid +
                ", procontext='" + procontent + '\'' +
                ", prosta=" + prosta +
                ", prodate=" + prodate +
                ", prodateStr=" + prodateStr +
                '}';
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getProcontent() {
        return procontent;
    }

    public void setProcontent(String procontent) {
        this.procontent = procontent;
    }

    public Integer getProsta() {
        return prosta;
    }

    public void setProsta(Integer prosta) {
        this.prosta = prosta;
    }

    public Date getProdate() {
        return prodate;
    }

    public void setProdate(String prodate) throws ParseException {
        this.prodate = DateUtils.stringtoDate(prodate,"yyyy-MM-dd");
    }

    public String getProdateStr() {
        if(prodate != null){
            prodateStr = DateUtils.datetoString(prodate,"yyyy-MM-dd HH:mm:ss");
        }
        return prodateStr;
    }

    public void setProdateStr(String prodateStr) {
        this.prodateStr = prodateStr;
    }
}
