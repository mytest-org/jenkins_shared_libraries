package org.gap.build

import org.gap.IStepExecutor
import org.gap.ioc.ContextRegistry

class ExecuteBuild {

    private String _tool
    private String _args

    ExecuteBuild(String tool, String args) {
        _tool = tool
        _args = args

    }

    void build() {
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        int returnStatus = steps.sh("${this._tool} ${this._args}")
        if (returnStatus != 0) {
            steps.error("Errors while building with ${this._tool} with arguments ${this._args}.")
        }
    }

}
