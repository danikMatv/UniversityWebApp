package com.foxmided.univerweb.Repository;

import com.foxmided.univerweb.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
    @Query(value = "SELECT v.groupid FROM Group v WHERE groupname = :groupname",nativeQuery = true)
    Integer findGroupIdByGroupName(@Param("groupname") String name) throws SQLException;

    void deleteGroupsByGroupId(Integer groupId);
    @Query("SELECT g FROM Group g WHERE g.groupId = ?1")
    Optional<Group> findGroupById(@Param("groupId") Integer groupId);
    @Query(value = "SELECT c FROM Group c")
    List<Group> getAll();
}
