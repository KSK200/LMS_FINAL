package com.fileupload.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseDTOTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        // Test data
        long courseId = 1L;
        double courseProgress = 0.75;
        List<TopicDTO> topics = new ArrayList<>();
        TopicDTO topic1 = new TopicDTO(1L, 0.5);
        TopicDTO topic2 = new TopicDTO(2L, 0.8);
        topics.add(topic1);
        topics.add(topic2);

        // Create CourseDTO object using AllArgsConstructor
        CourseDTO courseDTO = new CourseDTO(courseId, courseProgress, topics);

        // Test getters
        assertEquals(courseId, courseDTO.getCourseId());
        assertEquals(courseProgress, courseDTO.getCourseProgress());
        assertEquals(topics, courseDTO.getTopics());
    }

    @Test
    void testNoArgsConstructorAndGettersAndSetters() {
        // Test data
        long courseId = 1L;
        double courseProgress = 0.75;
        List<TopicDTO> topics = new ArrayList<>();
        TopicDTO topic1 = new TopicDTO(1L, 0.5);
        TopicDTO topic2 = new TopicDTO(2L, 0.8);
        topics.add(topic1);
        topics.add(topic2);

        // Create empty CourseDTO object using NoArgsConstructor
        CourseDTO courseDTO = new CourseDTO();

        // Test setters
        courseDTO.setCourseId(courseId);
        courseDTO.setCourseProgress(courseProgress);
        courseDTO.setTopics(topics);

        // Test getters
        assertEquals(courseId, courseDTO.getCourseId());
        assertEquals(courseProgress, courseDTO.getCourseProgress());
        assertEquals(topics, courseDTO.getTopics());
    }

    @Test
    void testGetterAndSetterForCourseId() {
        // Test data
        long courseId = 1L;

        // Create CourseDTO object
        CourseDTO courseDTO = new CourseDTO();

        // Test setter and getter for courseId
        courseDTO.setCourseId(courseId);
        assertEquals(courseId, courseDTO.getCourseId());
    }

    @Test
    void testGetterAndSetterForCourseProgress() {
        // Test data
        double courseProgress = 0.75;

        // Create CourseDTO object
        CourseDTO courseDTO = new CourseDTO();

        // Test setter and getter for courseProgress
        courseDTO.setCourseProgress(courseProgress);
        assertEquals(courseProgress, courseDTO.getCourseProgress());
    }

    @Test
    void testGetterAndSetterForTopics() {
        // Test data
        List<TopicDTO> topics = new ArrayList<>();
        TopicDTO topic1 = new TopicDTO(1L, 0.5);
        TopicDTO topic2 = new TopicDTO(2L, 0.8);
        topics.add(topic1);
        topics.add(topic2);

        // Create CourseDTO object
        CourseDTO courseDTO = new CourseDTO();

        // Test setter and getter for topics
        courseDTO.setTopics(topics);
        assertEquals(topics, courseDTO.getTopics());
    }
}

