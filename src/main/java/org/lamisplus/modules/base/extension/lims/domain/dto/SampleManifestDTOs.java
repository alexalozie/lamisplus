package org.lamisplus.modules.base.extension.lims.domain.dto;

import lombok.Data;
import org.lamisplus.modules.base.extension.lims.domain.dto.SampleManifestDTO;

import java.io.Serializable;
import java.util.List;

@Data
public class SampleManifestDTOs implements Serializable  {
    private List<SampleManifestDTO> sampleManifests;
}
