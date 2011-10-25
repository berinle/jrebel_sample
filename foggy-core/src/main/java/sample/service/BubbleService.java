package sample.service;

import sample.Bubble;

import java.util.List;

public interface BubbleService {
	Long addBubble(Bubble b);
	List<Bubble> getBubbles();
}