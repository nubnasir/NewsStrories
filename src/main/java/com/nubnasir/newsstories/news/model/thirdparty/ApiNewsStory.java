package com.nubnasir.newsstories.news.model.thirdparty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ApiNewsStory {

    @XmlElement
    private long id;
    @XmlElement
    private String title;
    @XmlElement
    private String contentBody;
    @XmlElement
    private String publishDate;
    @XmlElement
    private String publisherName;
}
