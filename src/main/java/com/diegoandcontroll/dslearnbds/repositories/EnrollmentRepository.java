package com.diegoandcontroll.dslearnbds.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoandcontroll.dslearnbds.domain.Enrollment;
import com.diegoandcontroll.dslearnbds.domain.pk.EnrrolmentPK;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrrolmentPK> {
}
