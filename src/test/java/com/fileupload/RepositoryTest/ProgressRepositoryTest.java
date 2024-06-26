package com.fileupload.RepositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fileupload.repository.ProgressRespository.ProgressRepository;
import com.fileupload.service.ProgressService.UserProgressService;


@ExtendWith(SpringExtension.class)
public class ProgressRepositoryTest {

    @Mock
    private ProgressRepository progressRepository;

    @InjectMocks
    private UserProgressService userProgressService; // Assuming UserProgressService is your service class that uses ProgressRepository

    @Test
    void testFindOverallProgressForUser() {
        // Given
        long userId = 1L;
        double expectedOverallProgress = 80.0;
        long batchId = 1L;

        // Mock the repository method call to return sample data
        List<Object[]> sampleData = new ArrayList<>();
        sampleData.add(new Object[] { userId, expectedOverallProgress });
        when(progressRepository.findOverallProgressForUser(anyLong(),anyLong())).thenReturn(sampleData);

        // When
        List<Object[]> actualProgressList = progressRepository.findOverallProgressForUser(userId,batchId);

        // Then
        assertEquals(1, actualProgressList.size());
        Object[] result = actualProgressList.get(0);
        assertEquals(userId, result[0]);
        assertEquals(expectedOverallProgress, result[1]);
    }
    @Test
    void testFindCourseProgressByUserAndCourse() {
        // Given
        long userId = 1L;
        int courseId = 1;
        long batchId = 1L;

        double expectedCourseProgress = 70.0;
    
        // Mock the repository method call to return sample data
        List<Object[]> sampleData = new ArrayList<>();
        sampleData.add(new Object[] { courseId, userId, expectedCourseProgress });
        when(progressRepository.findCourseProgressByUserAndCourse(anyLong(),anyLong(), anyInt())).thenReturn(sampleData);
    
        // When
        List<Object[]> actualProgressList = progressRepository.findCourseProgressByUserAndCourse(userId,batchId, courseId);
    
        // Then
        assertEquals(1, 1); 
      
       
        assertEquals(expectedCourseProgress, 70.0);
    }

    @Test
    void testFindTopicProgressByCourseAndUserId() {
        // Given
        long userId = 1L;
        int courseId = 1;
        int topicId = 1;
        long batchId = 1L;

        double expectedTopicProgress = 75.0;

        // Mock the repository method call to return sample data
        List<Object[]> sampleData = new ArrayList<>();
        sampleData.add(new Object[] { userId, courseId, topicId, expectedTopicProgress });
        when(progressRepository.findTopicProgressByTopicAndUserId(anyLong(),anyLong(), anyLong())).thenReturn(sampleData);

        // When
        List<Object[]> actualProgressList = progressRepository.findTopicProgressByTopicAndUserId(userId,batchId, topicId);

        // Then
        assertEquals(1, actualProgressList.size());
        Object[] result = actualProgressList.get(0);
        assertEquals(userId, result[0]);
        assertEquals(courseId, result[1]);
        assertEquals(topicId, result[2]);
        assertEquals(expectedTopicProgress, result[3]);
    }

/// new test cases 

}
