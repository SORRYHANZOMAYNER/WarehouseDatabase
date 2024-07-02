package org.example.base.repository;

import org.example.base.models.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail,Long>{
    Detail findByDetailName(String detailName);
}
