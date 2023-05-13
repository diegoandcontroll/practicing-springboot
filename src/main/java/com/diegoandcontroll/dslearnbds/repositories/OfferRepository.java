package com.diegoandcontroll.dslearnbds.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoandcontroll.dslearnbds.domain.Offer;

public interface OfferRepository extends JpaRepository<Offer,Long> {
}
