package com.fileupload.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DeleteProgressOfUsersDTOTest {
     @Test
    void testNoArgsConstructor() {
        // Test default constructor
        DeleteProgressOfUsersDTO dto = new DeleteProgressOfUsersDTO();

        // Assertions
        assertEquals(0,dto.getBatchId());
        assertNull(dto.getUserIds());
    }

    @Test
    void testAllArgsConstructor() {
        // Test constructor with parameters
        long batchId = 1L;
        List<Long> userIds = List.of(1L, 2L, 3L);
        DeleteProgressOfUsersDTO dto = new DeleteProgressOfUsersDTO(batchId, userIds);

        // Assertions
        assertEquals(batchId, dto.getBatchId());
        assertEquals(userIds, dto.getUserIds());
    }

    @Test
    void testSetterGetterBatchId() {
        // Test setter and getter for batchId
        DeleteProgressOfUsersDTO dto = new DeleteProgressOfUsersDTO();
        dto.setBatchId(1L);

        // Assertion
        assertEquals(1L, dto.getBatchId());
    }

    @Test
    void testSetterGetterUserIds() {
        // Test setter and getter for userIds
        DeleteProgressOfUsersDTO dto = new DeleteProgressOfUsersDTO();
        List<Long> userIds = List.of(1L, 2L, 3L);
        dto.setUserIds(userIds);

        // Assertion
        assertEquals(userIds, dto.getUserIds());
    }
}
