package com.diegoandcontroll.dslearnbds.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoandcontroll.dslearnbds.domain.Deliver;

public interface DeliverRepository extends JpaRepository<Deliver,Long> {
}
