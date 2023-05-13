package com.diegoandcontroll.dslearnbds.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_offer")
public class Offer {
  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  private String edition;
  private Instant startMoment;
  private Instant endMoment;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  @OneToMany(mappedBy = "offer")
  private List<Resource> resources = new ArrayList<>();

  @OneToMany(mappedBy = "offer")
	private List<Topic> topics = new ArrayList<>();	
  
  public Offer(Long id, String edition, Instant startMoment, Instant endMoment, Course course) {
    Id = id;
    this.edition = edition;
    this.startMoment = startMoment;
    this.endMoment = endMoment;
    this.course = course;
  }

  public Offer() {
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((Id == null) ? 0 : Id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Offer other = (Offer) obj;
    if (Id == null) {
      if (other.Id != null)
        return false;
    } else if (!Id.equals(other.Id))
      return false;
    return true;
  }

  public List<Resource> getResources() {
    return resources;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public Instant getStartMoment() {
    return startMoment;
  }

  public void setStartMoment(Instant startMoment) {
    this.startMoment = startMoment;
  }

  public Instant getEndMoment() {
    return endMoment;
  }

  public void setEndMoment(Instant endMoment) {
    this.endMoment = endMoment;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }
}
