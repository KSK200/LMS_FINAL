package com.fileupload.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchWiseResourceProgressDTO {
    private long batchId;
    private long resourceId;
    private double progress;
}
