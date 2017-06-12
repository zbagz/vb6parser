package io.proleap.vb6.asg.newtests.b;

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

public class TestB extends VbTestBase {

    @Test
    public void test() throws Exception {
        final File clsSoundInputFile = new File(
                "src/test/resources/io/proleap/vb6/asg/newtests/a/clsSound.cls");

        final File modGeneralInputFile = new File(
                "src/test/resources/io/proleap/vb6/asg/newtests/b/modGeneral.bas");

        final File clsDuplicateInputFile = new File(
                "src/test/resources/io/proleap/vb6/asg/newtests/b/clsDuplicate.cls");
        
        final File clsTestInputFile = new File(
                "src/test/resources/io/proleap/vb6/asg/newtests/b/clsTest.cls");

        final File modTestInputFile = new File(
                "src/test/resources/io/proleap/vb6/asg/newtests/b/modTest.bas");
        

        final Program program = new VbParserRunnerImpl().analyzeFiles(Arrays.asList(clsTestInputFile,
                modGeneralInputFile, clsSoundInputFile, clsDuplicateInputFile, modTestInputFile));

        {
            final ClazzModule clsSound = program.getClazzModule("clsSound");
            assertNotNull(clsSound);

            {
                final Function Sound_Play = clsSound.getFunction("Sound_Play");
                assertNotNull(Sound_Play);
                assertEquals(2, Sound_Play.getFunctionCalls().size()); // returns 0 but there're 2
            }

        }
        
        {
            final ClazzModule clsDuplicate = program.getClazzModule("clsDuplicate");
            assertNotNull(clsDuplicate);

            {
                final Variable Sound = clsDuplicate.getVariable("Sound");
                assertNotNull(Sound);
                assertEquals(0, Sound.getVariableCalls().size()); // returns 2 but there're 0
            }
        }
    }
}
