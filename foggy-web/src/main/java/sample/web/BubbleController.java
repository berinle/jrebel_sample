package sample.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.Bubble;
import sample.service.*;

import javax.inject.Inject;
import javax.inject.Qualifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
class BubbleController {

    public static final Logger log = Logger.getLogger(BubbleController.class);

    @org.springframework.beans.factory.annotation.Qualifier("httpBubbleService")
    @Inject
	private BubbleService service;

    @RequestMapping("/list")
	public String list(Map<String, Object> model){
        log.debug("BubbleController.list");
        List<Bubble> bubbles = service.getBubbles();
        
        if(bubbles.isEmpty()){
            log.debug("creating fake data");
            bubbles = createDummyData();
        }

        model.put("bubbles", bubbles);
        return "home";
	}
    
    private List<Bubble> createDummyData(){
        ArrayList<Bubble> bubbles = new ArrayList<Bubble>();
        bubbles.add(new Bubble(1l, "fake-foo"));
        bubbles.add(new Bubble(2l, "fake-bar"));
        bubbles.add(new Bubble(3l, "fake-baz"));
        return bubbles;
    }
	
}