package org.lamisplus.modules.base.extension.lims.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TestResultRequest implements Serializable  {
    private String manifestID;
    private String facilityID;
    private String sendingPCRLabID;
    private String testType;
}
