package io.proleap.vb6.asg.newtests.d;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Arrays;

import org.junit.Test;

import io.proleap.vb6.VbTestBase;
import io.proleap.vb6.asg.metamodel.ClazzModule;
import io.proleap.vb6.asg.metamodel.Program;
import io.proleap.vb6.asg.metamodel.StandardModule;
import io.proleap.vb6.asg.metamodel.Variable;
import io.proleap.vb6.asg.metamodel.statement.enumeration.Enumeration;
import io.proleap.vb6.asg.metamodel.statement.enumeration.EnumerationConstant;
import io.proleap.vb6.asg.metamodel.statement.function.Function;
import io.proleap.vb6.asg.runner.impl.VbParserRunnerImpl;

public class TestD extends VbTestBase {

    @Test
    public void test() throws Exception {
        final File clsSoundInputFile = new File(
                "src/test/resources/io/proleap/vb6/asg/newtests/d/clsSound.cls");
        
        final File modGeneralInputFile = new File(
                "src/test/resources/io/proleap/vb6/asg/newtests/d/modGeneral.bas");

        final Program program = new VbParserRunnerImpl().analyzeFiles(Arrays.asList(clsSoundInputFile, modGeneralInputFile));
        
        {
            final ClazzModule clsSound = program.getClazzModule("clsSound");
            assertNotNull(clsSound);

            {
                final Variable cmdPlay = clsSound.getVariable("cmdPlay");
                assertNotNull(cmdPlay);
                assertEquals(2, cmdPlay.getVariableCalls().size());
            }
        }
        
        {
            final StandardModule modGeneral = program.getStandardModule("modGeneral");
            assertNotNull(modGeneral);

            {
                final Enumeration eSoundAction = modGeneral.getEnumerations().get("eSoundAction");
                assertNotNull(eSoundAction);

                {
                    final EnumerationConstant cmdPlay = eSoundAction.getEnumerationConstant("cmdPlay");
                    assertNotNull(cmdPlay);
                    assertEquals(0, cmdPlay.getEnumerationConstantCalls().size());
                }
            }
        }
    }
}
