import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import sample.Bubble;
import sample.service.BubbleService;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author berinle
 */

@TransactionConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext-web.xml","classpath:test-config.xml"})
public class ServiceConsumerTest extends AbstractJUnit4SpringContextTests {
    @Qualifier("httpBubbleService")
    @Inject
    BubbleService service;

    @SuppressWarnings("unchecked")
    @Test
    public void retrieveBubbles(){

        List bubbles = service.getBubbles();
        assertThat((List<Object>)bubbles, is(not(empty())));
        assertThat(bubbles.size(), is(3));
        assertThat((List<Object>)bubbles, hasItem(hasProperty("name", anyOf(is("baz"), is("foo")))));

    }

    @SuppressWarnings("unchecked")
    @Rollback
    @Test
    public void addBubble(){
        Bubble bubble = new Bubble();
        bubble.setName("bayo");
        Long id = service.addBubble(bubble);
        assertThat(id, is(notNullValue()));
        
        List aList = service.getBubbles();
        assertThat((List<Object>)aList, hasItem(hasProperty("name", is("bayo"))));
    }
}
