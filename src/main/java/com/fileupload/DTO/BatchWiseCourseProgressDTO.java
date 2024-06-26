package com.fileupload.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BatchWiseCourseProgressDTO {
    private long batchId;
    private long courseId;
    private double courseProgress;
}
