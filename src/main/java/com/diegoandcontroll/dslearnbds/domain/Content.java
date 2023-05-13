package com.diegoandcontroll.dslearnbds.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_content")
public class Content extends Lesson {
  private static final long serialVersionUID = 1L;
  
  private String textContent;
  private String videoUrl;

  public Content(Long id, String title, Integer position, Section section, String textContent, String videoUrl) {
    super(id, title, position, section);
    this.textContent = textContent;
    this.videoUrl = videoUrl;
  }

  public Content(String textContent, String videoUrl) {
    this.textContent = textContent;
    this.videoUrl = videoUrl;
  }

  public Content() {

  }

  public String getTextContent() {
    return textContent;
  }

  public void setTextContent(String textContent) {
    this.textContent = textContent;
  }

  public String getVideoUrl() {
    return videoUrl;
  }

  public void setVideoUrl(String videoUrl) {
    this.videoUrl = videoUrl;
  }
}
