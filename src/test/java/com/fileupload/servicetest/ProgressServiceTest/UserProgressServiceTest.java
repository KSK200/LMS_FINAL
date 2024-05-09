package com.fileupload.servicetest.ProgressServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fileupload.controller.ProgressControllers.UserProgressController;
import com.fileupload.DTO.ProgressDTO;
import com.fileupload.DTO.UserCourseProgressDTO;
import com.fileupload.DTO.UserProgressDTO;
import com.fileupload.DTO.UserResourceProgressDTO;
import com.fileupload.DTO.UserTopicProgressDTO;
import com.fileupload.Exception.ProgressExceptions.CourseNotFoundException;
import com.fileupload.Exception.ProgressExceptions.ResourceIdNotFoundException;
import com.fileupload.Exception.ProgressExceptions.TopicIdNotFoundException;
import com.fileupload.Exception.ProgressExceptions.UserNotFoundException;
import com.fileupload.model.ProgressModel.Progress;
import com.fileupload.repository.ProgressRespository.ProgressRepository;
import com.fileupload.service.ProgressService.UserProgressService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserProgressServiceTest {

@Mock
    private ProgressRepository progressRepository;

    @InjectMocks
    private UserProgressService userProgressService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCalculateOverallProgressForUser_Success() throws UserNotFoundException {
        // Mock data
        Long userId = 1L;
        Long batchId = 1L;
        List<Object[]> results = new ArrayList<>();
        results.add(new Object[]{userId, 0.75});
        when(progressRepository.findOverallProgressForUser(userId, batchId)).thenReturn(results);

        // Test method
        UserProgressDTO result = userProgressService.calculateOverallProgressForUser(userId, batchId);

        // Assertions
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        assertEquals(0.75, result.getOverallProgress());
    }

    @Test
    void testCalculateOverallProgressForUser_UserNotFoundException() {
        // Mock data
        Long userId = 1L;
        Long batchId = 1L;
        when(progressRepository.findOverallProgressForUser(userId, batchId)).thenReturn(null);

        // Test method and assertions
        assertThrows(UserNotFoundException.class,
                () -> userProgressService.calculateOverallProgressForUser(userId, batchId));
    }

    @Test
    void testCalculateCourseProgressForUser_Success() throws CourseNotFoundException {
        // Mock data
        Long userId = 1L;
        Long batchId = 1L;
        Long courseId = 1L;
        List<Object[]> results = new ArrayList<>();
        results.add(new Object[]{userId, userId, 0.75});
        when(progressRepository.findCourseProgressByUserAndCourse(userId, batchId, courseId)).thenReturn(results);

        // Test method
        UserCourseProgressDTO result = userProgressService.calculateCourseProgressForUser(userId, batchId, courseId);

        // Assertions
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        assertEquals(0.75, result.getCourseProgress());
    }

    @Test
    void testCalculateCourseProgressForUser_CourseNotFoundException() {
        // Mock data
        Long userId = 1L;
        Long batchId = 1L;
        Long courseId = 1L;
        when(progressRepository.findCourseProgressByUserAndCourse(userId, batchId, courseId)).thenReturn(null);

        // Test method and assertions
        assertThrows(CourseNotFoundException.class,
                () -> userProgressService.calculateCourseProgressForUser(userId, batchId, courseId));
    }


    @Test
    void testCalculateUserTopicProgress_TopicIdNotFoundException() {
        // Mock data
        Long userId = 1L;
        Long batchId = 1L;
        Long topicId = 1L;
        when(progressRepository.findTopicProgressByTopicAndUserId(userId, batchId, topicId)).thenReturn(null);

        // Test method and assertions
        assertThrows(TopicIdNotFoundException.class,
                () -> userProgressService.calculateUserTopicProgress(userId, batchId, topicId));
    }

    

    @Test
    void testCalculateResourceProgressForUser_ResourceIdNotFoundException() {
        // Mock data
        Long userId = 1L;
        Long batchId = 1L;
        Long resourceId = 1L;
        when(progressRepository.findByUserIdAndBatchIdAndResourceId(userId, batchId, resourceId)).thenReturn(null);

        // Test method and assertions
        assertThrows(ResourceIdNotFoundException.class,
                () -> userProgressService.calculateResourceProgressForUser(userId, batchId, resourceId));
    }


    @Test
    void testGetUserProgress_UserNotFoundException() {
        // Mock data
        Long userId = 1L;
        Long batchId = 1L;
        List<Long> courseIds = Arrays.asList(1L, 2L);
        when(progressRepository.findByUserIdAndBatchId(userId, batchId)).thenReturn(new ArrayList<>());

        // Test method and assertions
        assertThrows(UserNotFoundException.class,
                () -> userProgressService.getUserProgress(userId, batchId, courseIds));
    }

    @Test
    void testGetUserProgress_CourseNotFoundException() {
        // Mock data
        Long userId = 1L;
        Long batchId = 1L;
        List<Long> courseIds = Arrays.asList(1L, 2L);
        when(progressRepository.getUserProgress(userId, batchId, courseIds)).thenReturn(new ArrayList<>());
        when(progressRepository.findByUserIdAndBatchId(userId, batchId)).thenReturn(new ArrayList<>());

        // Test method and assertions
        assertThrows(UserNotFoundException.class,
                () -> userProgressService.getUserProgress(userId, batchId, courseIds));
    }

    @Test
    void testDeleteProgressOfUsers() {
        // Mock data
        Long batchId = 1L;
        List<Long> userIds = Arrays.asList(1L, 2L);

        // Test method
        userProgressService.deleteProgressOfUsers(userIds, batchId);

        // Verify
        verify(progressRepository, times(2)).deleteByUserIdAndBatchId(anyLong(), anyLong());
    }


}

