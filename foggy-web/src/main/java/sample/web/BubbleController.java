package sample.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.Bubble;
import sample.service.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
class BubbleController {

    public static final Logger log = Logger.getLogger(BubbleController.class);
    
    @Inject
	private BubbleService service;

    @RequestMapping("/list")
	public String list(Map<String, Object> model){
        log.debug("BubbleController.list");
        //List<Bubble> bubbles = service.getBubbles();
        List<Bubble> bubbles = createDummyData();
        model.put("bubbles", bubbles);
        return "home";
	}
    
    private List<Bubble> createDummyData(){
        ArrayList<Bubble> bubbles = new ArrayList<Bubble>();
        bubbles.add(new Bubble(1l, "foo"));
        bubbles.add(new Bubble(2l, "bar"));
        bubbles.add(new Bubble(3l, "baz"));
        return bubbles;
    }
	
}