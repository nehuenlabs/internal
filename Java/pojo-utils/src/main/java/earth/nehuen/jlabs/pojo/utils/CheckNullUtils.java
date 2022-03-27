/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earth.nehuen.jlabs.pojo.utils;

import java.util.Optional;
import java.util.function.Supplier;


/**
 *
 * @author marcello
 */
public class CheckNullUtils {

    public static <T> T getReferenceOrNull(Supplier<T> reference) {
    
        try {
                return reference.get();
        
        } catch (NullPointerException e) {
        
            return null;
        }
    }
    
    public static <T> Optional<T> getOptionalValue(Supplier<T> reference) {
    
        try {
                return Optional.of( reference.get() );
        
        } catch (NullPointerException e) {
        
            return Optional.empty();
        }
    }
}
