package org.lamisplus.modules.base.extension.nims;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class SampleOrderDTO {
    private String orderId;
    private String testType;
    private String originName;
    private String originCode;
    private String destinationName;
    private String destinationCode;
    private List<SampleId> sampleIds;
    private LocalDate creationDate;
    private LocalTime creationTime;
    private String location;
    private String info;
}
