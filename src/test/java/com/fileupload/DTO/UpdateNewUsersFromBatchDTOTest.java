package com.fileupload.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UpdateNewUsersFromBatchDTOTest {
        @Test
    void testNoArgsConstructor() {
        // Test default constructor
        UpdateNewUsersFromBatchDTO dto = new UpdateNewUsersFromBatchDTO();

        // Assertions
        assertEquals(0,dto.getBatchId());
        assertNull(dto.getUserIds());
    }

    @Test
    void testAllArgsConstructor() {
        // Test constructor with parameters
        long batchId = 1L;
        List<Long> userIds = List.of(1L, 2L, 3L);
        UpdateNewUsersFromBatchDTO dto = new UpdateNewUsersFromBatchDTO(batchId, userIds);

        // Assertions
        assertEquals(batchId, dto.getBatchId());
        assertEquals(userIds, dto.getUserIds());
    }

    @Test
    void testSetterGetterBatchId() {
        // Test setter and getter for batchId
        UpdateNewUsersFromBatchDTO dto = new UpdateNewUsersFromBatchDTO();
        dto.setBatchId(1L);

        // Assertion
        assertEquals(1L, dto.getBatchId());
    }

    @Test
    void testSetterGetterUserIds() {
        // Test setter and getter for userIds
        UpdateNewUsersFromBatchDTO dto = new UpdateNewUsersFromBatchDTO();
        List<Long> userIds = List.of(1L, 2L, 3L);
        dto.setUserIds(userIds);

        // Assertion
        assertEquals(userIds, dto.getUserIds());
    }
}
