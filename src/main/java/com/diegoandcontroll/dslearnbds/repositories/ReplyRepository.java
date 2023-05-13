package com.diegoandcontroll.dslearnbds.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoandcontroll.dslearnbds.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
}
