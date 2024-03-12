package com.foxmided.univerweb.Repository;

import com.foxmided.univerweb.Models.Teaching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingRepository extends JpaRepository<Teaching,Long>
{
    void deleteTeachingByTeacherId(Integer teachingId);
}
