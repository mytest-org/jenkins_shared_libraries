package org.gap.build

import org.gap.IStepExecutor
import org.gap.ioc.ContextRegistry

class BuildGradle {

    private String _goals

    BuildGradle(String goals) {
        _goals = goals
    }

    void build() {
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        int returnStatus = steps.sh("${this._goals}")
        if (returnStatus != 0) {
            steps.error("Errors while building with gradle.")
        }
    }
}
