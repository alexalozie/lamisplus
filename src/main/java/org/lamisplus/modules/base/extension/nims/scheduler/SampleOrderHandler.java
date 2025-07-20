package org.lamisplus.modules.base.extension.nims.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.base.extension.nims.SampleOrder;
import org.lamisplus.modules.base.extension.nims.SampleOrderRepository;
import org.lamisplus.modules.base.util.HttpConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class SampleOrderHandler {

    private final SampleOrderRepository sampleOrderRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Value("${nims.api.sample.order}")
    private String endpoint;

    public void dispatch()  {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Retrieve sample order all not yet dispatched
        List<SampleOrder> sampleOrders = sampleOrderRepository.findSampleOrderByDispatchedFalse();
        if(sampleOrders.size() > 0) {
            sampleOrders.forEach(sampleOrder -> {
                String order = (String) sampleOrder.getDetails();
                try {
                    new HttpConnectionManager().post(order, endpoint);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }


}
