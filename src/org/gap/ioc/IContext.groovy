package org.gap.ioc

import org.gap.IStepExecutor


interface IContext {
    IStepExecutor getStepExecutor()
}