package com.fileupload.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgressDTO {
    
    private Long userId;
    private Long batchId;
    private List<CourseDTO> courses;
}
