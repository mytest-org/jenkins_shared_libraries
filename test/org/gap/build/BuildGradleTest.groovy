package org.gap.build

import org.gap.IStepExecutor
import org.gap.ioc.ContextRegistry
import org.gap.ioc.IContext
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.*;

/**
 * Test class
 */
public class BuildGradleTest {
    private IContext _context
    private IStepExecutor _steps

    @Before
    public void setup() {
        _context = mock(IContext.class)
        _steps = mock(IStepExecutor.class)

        when(_context.getStepExecutor()).thenReturn(_steps)

        ContextRegistry.registerContext(_context)
    }

    @Test
    public void build_callsShStep() {
        // prepare
        String goals = "clean build";
        BuildGradle build = new BuildGradle(goals)

        // execute
        build.build()

        // verify
        verify(_steps).sh(anyString())
    }

    @Test
    public void build_shStepReturnsStatusNotEqualsZero_callsErrorStep() {
        // prepare
        String goals = "clean build";
        BuildGradle build = new BuildGradle(goals)

        when(_steps.sh(anyString())).thenReturn(-1)

        // execute
        build.build()

        // verify
        verify(_steps).error(anyString())
    }
}