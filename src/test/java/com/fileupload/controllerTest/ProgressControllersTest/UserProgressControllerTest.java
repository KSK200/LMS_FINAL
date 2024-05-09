package com.fileupload.controllerTest.ProgressControllersTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fileupload.controller.ProgressControllers.UserProgressController;
import com.fileupload.DTO.ProgressDTO;
import com.fileupload.DTO.ProgressRequest;
import com.fileupload.DTO.ResourceProgressDTO;
import com.fileupload.DTO.UserCourseProgressDTO;
import com.fileupload.DTO.UserProgressDTO;
import com.fileupload.DTO.UserResourceProgressDTO;
import com.fileupload.DTO.UserTopicProgressDTO;
import com.fileupload.DTO.UserTopicRequestDTO;
import com.fileupload.Exception.ProgressExceptions.ResourceIdNotFoundException;
import com.fileupload.service.ProgressService.UserProgressService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserProgressControllerTest {

    @Mock
    private UserProgressService userProgressService;

    @InjectMocks
    private UserProgressController userProgressController;

    @Test
    void testCalculateOverallProgressFound() {
        long userId = 123;
        long batchId=1;
        UserProgressDTO mockProgress = new UserProgressDTO();
        when(userProgressService.calculateOverallProgressForUser(userId,batchId)).thenReturn(mockProgress);

        ResponseEntity<UserProgressDTO> response = userProgressController.calculateOverallProgress(userId,batchId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProgress, response.getBody());

        verify(userProgressService, times(1)).calculateOverallProgressForUser(userId,batchId);
    }

    @Test
    void testCalculateOverallProgressNotFound() {
        long userId = 456;
        long batchId=1;

        when(userProgressService.calculateOverallProgressForUser(userId,batchId)).thenReturn(null);

        ResponseEntity<UserProgressDTO> response = userProgressController.calculateOverallProgress(userId,batchId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(userProgressService, times(1)).calculateOverallProgressForUser(userId,batchId);
    }




    @Test
    void testCalculateResourceProgressNotFound() {
        long userId = 789;
        int resourceId = 101;
        when(userProgressService.calculateResourceProgressForUser(userId, resourceId, userId)).thenReturn(null);

        ResponseEntity<UserResourceProgressDTO> response = userProgressController.calculateResourceProgress(resourceId,
                userId, userId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(userProgressService, times(1)).calculateResourceProgressForUser(userId, resourceId, userId);
    }

    @Test
    void testGetUserProgress() {
        ProgressRequest request = new ProgressRequest();
        request.setUserId(123L);
        request.setCourseIds(Collections.singletonList(456L));

        ProgressDTO mockProgress = new ProgressDTO();
        when(userProgressService.getUserProgress(request.getUserId(),request.getBatchId(), request.getCourseIds())).thenReturn(mockProgress);

        ProgressDTO response = userProgressController.getUserProgress(request);

        assertEquals(mockProgress, response);

        verify(userProgressService, times(1)).getUserProgress(request.getUserId(),request.getBatchId(), request.getCourseIds());
    }




    // @Test
    // void testFindProgressByUserIdAndTopics() {
    //     // Mocking input data
    //     UserTopicRequestDTO userTopicRequest = new UserTopicRequestDTO(1L,List.of(1L,1L, 2L));
 
    //     // Mocking service response
    //     List<ResourceProgressDTO> expectedProgressList = new ArrayList<>();
    //     // Populate expectedProgressList with some test data
 
    //     when(userProgressService.findProgressByUserIdAndTopics(1L, List.of(1L,1L 2L))).thenReturn(expectedProgressList);
 
    //     // Call the controller method
    //     List<ResourceProgressDTO> actualProgressList = userProgressController
    //             .findProgressByUserIdAndTopics(userTopicRequest);
 
    //     // Assertions
    //     assertEquals(expectedProgressList, actualProgressList);
    //     verify(userProgressService, times(1)).findProgressByUserIdAndTopics(1L, List.of(1L, 2L));
    // }
    ///



    
}
