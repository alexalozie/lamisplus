package org.lamisplus.modules.base.extension.nims;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.base.repository.OrganisationUnitRepository;
import org.lamisplus.modules.base.util.RandomCodeGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class SampleOrderService {
    private final SampleOrderRepository sampleOrderRepository;
    private final OrganisationUnitRepository organisationUnitRepository;
    private ObjectMapper objectMapper;

    public List<SampleOrder> findAll(){
        return this.sampleOrderRepository.findAll();
    }

    public List<SampleOrder> save(SampleOrderDTO sampleOrderDTO) throws JsonProcessingException {
        sampleOrderDTO.setOriginCode("");
        sampleOrderDTO.setOriginName("");
        sampleOrderDTO.setOrderId(RandomCodeGenerator.randomAlphanumericString(7));
        String order = objectMapper.writeValueAsString(sampleOrderDTO);

        SampleOrder sampleOrder = new SampleOrder();
        sampleOrder.setDetails(order);
        return (List<SampleOrder>) this.sampleOrderRepository.save(sampleOrder);
    }

}
