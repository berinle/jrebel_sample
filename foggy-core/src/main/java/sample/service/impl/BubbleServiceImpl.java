package sample.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.Bubble;
import sample.dao.BubbleDao;
import sample.service.*;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
class BubbleServiceImpl implements BubbleService {
    @Inject
    private BubbleDao dao;

    public Long addBubble(Bubble b) {
        return dao.addBubble(b);
    }

    public List<Bubble> getBubbles() {
        return dao.getBubbles();
    }
}