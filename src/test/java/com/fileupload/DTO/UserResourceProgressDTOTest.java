package com.fileupload.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserResourceProgressDTOTest {
     @Test
    void testNoArgsConstructor() {
        // Test default constructor
        UserResourceProgressDTO dto = new UserResourceProgressDTO();

        // Assertions
        assertEquals(0, dto.getUserId());
        assertEquals(0.0, dto.getResourceProgress());
    }

    @Test
    void testAllArgsConstructor() {
        // Test constructor with parameters
        long userId = 1L;
        double resourceProgress = 0.75;
        UserResourceProgressDTO dto = new UserResourceProgressDTO(userId, resourceProgress);

        // Assertions
        assertEquals(userId, dto.getUserId());
        assertEquals(resourceProgress, dto.getResourceProgress());
    }

    @Test
    void testSetterGetterUserId() {
        // Test setter and getter for userId
        UserResourceProgressDTO dto = new UserResourceProgressDTO();
        dto.setUserId(1L);

        // Assertion
        assertEquals(1L, dto.getUserId());
    }

    @Test
    void testSetterGetterResourceProgress() {
        // Test setter and getter for resourceProgress
        UserResourceProgressDTO dto = new UserResourceProgressDTO();
        double resourceProgress = 0.75;
        dto.setResourceProgress(resourceProgress);

        // Assertion
        assertEquals(resourceProgress, dto.getResourceProgress());
    }
}
