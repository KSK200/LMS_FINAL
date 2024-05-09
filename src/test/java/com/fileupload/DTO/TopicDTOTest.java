package com.fileupload.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TopicDTOTest {

    @Test
    void testNoArgsConstructor() {
        // Test default constructor
        TopicDTO dto = new TopicDTO();

        // Assertions
        assertEquals(0, dto.getTopicId());
        assertEquals(0.0, dto.getProgress());
    }

    @Test
    void testAllArgsConstructor() {
        // Test constructor with parameters
        long topicId = 1L;
        double progress = 0.75;
        TopicDTO dto = new TopicDTO(topicId, progress);

        // Assertions
        assertEquals(topicId, dto.getTopicId());
        assertEquals(progress, dto.getProgress());
    }

    @Test
    void testSetterGetterTopicId() {
        // Test setter and getter for topicId
        TopicDTO dto = new TopicDTO();
        dto.setTopicId(1L);

        // Assertion
        assertEquals(1L, dto.getTopicId());
    }

    @Test
    void testSetterGetterProgress() {
        // Test setter and getter for progress
        TopicDTO dto = new TopicDTO();
        double progress = 0.75;
        dto.setProgress(progress);

        // Assertion
        assertEquals(progress, dto.getProgress());
    }}

