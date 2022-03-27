/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earth.nehuen.jlabs.pojo.utils;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author marcello
 */
public class CheckNullUtilsTest {

    @Test
    public void a_quick_test_null() {
        
        NestedContainer nestedExample = new NestedContainer();
    
        NestedContainer testOutput = 
            CheckNullUtils.getReferenceOrNull(() -> 
                nestedExample.getNestedProperty()       // 2
                                .getNestedProperty()    // 3
                                .getNestedProperty()    // 4
                                .getNestedProperty() ); // 5
        
        assertNull(testOutput);
    }

    @Test
    public void a_quick_test_optional() {
        
        NestedContainer nestedExample = new NestedContainer();
    
        Optional<Object> testOutput =
            CheckNullUtils.getOptionalValue(() -> 
                nestedExample.getNestedProperty()       // 2
                                .getNestedProperty()    // 3
                                .getNestedProperty()    // 4
                                .getNestedProperty() ); // 5
        
        assertNotNull(testOutput);
        assertTrue(testOutput.isEmpty());
    }
}

class NestedContainer {

    private NestedContainer nestedProperty;
    
    public NestedContainer getNestedProperty() {
    
        return this.nestedProperty;
    }
    
    public void setNestedProperty(final NestedContainer nc) {
    
        this.nestedProperty = nc;
    }
}
