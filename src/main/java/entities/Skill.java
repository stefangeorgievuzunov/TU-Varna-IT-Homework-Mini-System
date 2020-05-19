package entities;

import com.sun.xml.bind.XmlAccessorFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Skill {
    private String name;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        if(value>100){
            this.value=100;
        }else if(value<0){
            this.value=0;
        }else{
            this.value = value;
        }
    }
}
