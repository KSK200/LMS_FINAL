package com.fileupload.ExceptionTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fileupload.Exception.ProgressExceptions.BatchIdNotFoundException;
import com.fileupload.Exception.ProgressExceptions.CourseNotFoundException;
import com.fileupload.Exception.ProgressExceptions.ExceptionHandlerpro;
import com.fileupload.Exception.ProgressExceptions.NotFoundException;
import com.fileupload.Exception.ProgressExceptions.ResourceIdNotFoundException;
import com.fileupload.Exception.ProgressExceptions.TopicIdNotFoundException;
import com.fileupload.Exception.ProgressExceptions.UserNotFoundException;


public class ExceptionHandlerproTest {

    @Test
    void testHandleNotFoundException() {
        // Given
        NotFoundException ex = new NotFoundException("Not found");
        ExceptionHandlerpro handler = new ExceptionHandlerpro();

        // When
        ResponseEntity<Object> response = handler.handleNotFoundException(ex, null);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Not found", response.getBody());
    }

    @Test
    void testHandleUserNotFoundException() {
        // Given
        UserNotFoundException ex = new UserNotFoundException("User not found");
        ExceptionHandlerpro handler = new ExceptionHandlerpro();

        // When
        ResponseEntity<Object> response = handler.handleUserNotFoundException(ex, null);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("User not found", response.getBody());
    }

    @Test
    void testHandleCourseNotFoundException() {
        // Given
        CourseNotFoundException ex = new CourseNotFoundException("Course not found");
        ExceptionHandlerpro handler = new ExceptionHandlerpro();

        // When
        ResponseEntity<Object> response = handler.handleCourseNotFoundException(ex, null);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Course not found", response.getBody());
    }

    @Test
    void testHandleBatchIdNotFoundException() {
        // Given
        BatchIdNotFoundException ex = new BatchIdNotFoundException("Batch ID not found");
        ExceptionHandlerpro handler = new ExceptionHandlerpro();

        // When
        ResponseEntity<Object> response = handler.handleBatchIdNotFoundException(ex, null);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Batch ID not found", response.getBody());
    }

    @Test
    void testHandleTopicIdNotFoundException() {
        // Given
        TopicIdNotFoundException ex = new TopicIdNotFoundException("Topic ID not found");
        ExceptionHandlerpro handler = new ExceptionHandlerpro();

        // When
        ResponseEntity<Object> response = handler.handleTopicIdNotFoundException(ex, null);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Topic ID not found", response.getBody());
    }

    @Test
    void testHandleResourceIdNotFoundException() {
        // Given
        ResourceIdNotFoundException ex = new ResourceIdNotFoundException("Resource ID not found");
        ExceptionHandlerpro handler = new ExceptionHandlerpro();

        // When
        ResponseEntity<Object> response = handler.handleResourceIdNotFoundException(ex, null);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Resource ID not found", response.getBody());
    }
}

