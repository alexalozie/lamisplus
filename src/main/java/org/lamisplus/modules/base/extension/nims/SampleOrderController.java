package org.lamisplus.modules.base.extension.nims;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sample-orders")
public class SampleOrderController {
    private SampleOrderService sampleOrderService;

    public ResponseEntity <List<SampleOrder>> save(@RequestBody SampleOrderDTO sampleOrderDTO) throws URISyntaxException, JsonProcessingException {
        return ResponseEntity.ok(this.sampleOrderService.save(sampleOrderDTO));
    }
}
