package com.diegoandcontroll.dslearnbds.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.diegoandcontroll.dslearnbds.domain.pk.EnrrolmentPK;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {
  
  @EmbeddedId
  private EnrrolmentPK id = new EnrrolmentPK();
  
  private Instant enrollMoment;
  private Instant refundMoment;
  private boolean available;
  private boolean onlyUpdate;

  @ManyToMany(mappedBy = "enrollmentsDone")
  private Set<Lesson> lessonsDone = new HashSet<>();

  @OneToMany(mappedBy = "enrollment")
	private List<Deliver> deliveries = new ArrayList<>();
  
  public List<Deliver> getDeliveries() {
    return deliveries;
  }

  public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean available,
      boolean onlyUpdate) {
    id.setUser(user);
    id.setOffer(offer);
    this.enrollMoment = enrollMoment;
    this.refundMoment = refundMoment;
    this.available = available;
    this.onlyUpdate = onlyUpdate;
  }

  public Enrollment() {
  }

  public User getUser() {
    return id.getUser();
  }

  public void setUser(User user) {
    id.setUser(user);
  }

  public Offer getOffer() {
    return id.getOffer();
  }

  public void setOffer(Offer offer) {
    id.setOffer(offer);
  }

  public Instant getEnrollMoment() {
    return enrollMoment;
  }

  public void setEnrollMoment(Instant enrollMoment) {
    this.enrollMoment = enrollMoment;
  }

  public Instant getRefundMoment() {
    return refundMoment;
  }

  public void setRefundMoment(Instant refundMoment) {
    this.refundMoment = refundMoment;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public boolean isOnlyUpdate() {
    return onlyUpdate;
  }

  public void setOnlyUpdate(boolean onlyUpdate) {
    this.onlyUpdate = onlyUpdate;
  }
}
