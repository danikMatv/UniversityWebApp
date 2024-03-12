package com.foxmided.univerweb.Service.ModelService;

import com.foxmided.univerweb.Models.Group;
import com.foxmided.univerweb.Repository.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GroupServiceTest {

    @Mock
    GroupRepository groupRepository;
    @InjectMocks
    GroupService groupService;

    @Test
    void save()
    {
        Group group = new Group("Pmk - 21");
        groupService.save(group);
    }

    @Test
    void deleteGroup()
    {
    }
    @BeforeEach
    void setup() throws SQLException
    {
        Group group = new Group("Rml-11");
        Mockito.when(groupRepository.findGroupIdByGroupName("Pmp-21")).thenReturn(group.getGroupId());
    }

    @Test
    void findGroupIdByGroupName() throws SQLException
    {
        String name = "Pmp-21";
        int findGroupId = groupService.findGroupIdByGroupName(name);
        assertEquals(0,findGroupId);
    }
}
