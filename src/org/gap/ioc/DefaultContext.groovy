package org.gap.ioc

import org.gap.IStepExecutor
import org.gap.StepExecutor

class DefaultContext implements IContext, Serializable {
    // the same as in the StepExecutor class
    private _steps

    DefaultContext(steps) {
        this._steps = steps
    }

    @Override
    IStepExecutor getStepExecutor() {
        return new StepExecutor(this._steps)
    }
}
