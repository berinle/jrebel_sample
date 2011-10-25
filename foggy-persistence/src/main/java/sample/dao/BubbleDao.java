package sample.dao;

import sample.Bubble;

import java.util.List;

/**
 * @author berinle
 */
public interface BubbleDao {
    Long addBubble(Bubble b);
    List<Bubble> getBubbles();
}
