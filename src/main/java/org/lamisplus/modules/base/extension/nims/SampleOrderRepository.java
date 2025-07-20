package org.lamisplus.modules.base.extension.nims;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SampleOrderRepository  extends JpaRepository<SampleOrder, Long>, JpaSpecificationExecutor {
    List<SampleOrder> findSampleOrderByDispatchedFalse();
}
