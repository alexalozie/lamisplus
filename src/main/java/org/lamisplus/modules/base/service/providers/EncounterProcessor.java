package org.lamisplus.modules.base.service.providers;

import org.lamisplus.modules.base.domain.entity.Encounter;

public interface EncounterProcessor {
    void process(Encounter encounter);
}
