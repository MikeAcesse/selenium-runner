package info2soft.qa;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/8/5 15:38
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ADFTimeout {
	int value();
}
