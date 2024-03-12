package com.foxmided.univerweb.Service.ModelService;

import com.foxmided.univerweb.Models.Group;
import com.foxmided.univerweb.Repository.GroupRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService
{
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Transactional
    public void save(Group entity) {
        groupRepository.save(entity);
    }

    @Transactional
    public void deleteGroupsByGroupId(Integer groupId) {
        groupRepository.deleteGroupsByGroupId(groupId);
    }

    public Integer findGroupIdByGroupName(String name) throws SQLException {
        return groupRepository.findGroupIdByGroupName(name);
    }

    public Optional<Group> findGroupById(Integer groupId) {
        return groupRepository.findGroupById(groupId);
    }

    public List<Group> getAll(){
        return groupRepository.findAll();
    }
}
