package architecture.dao.impl;

import architecture.PriceParityApplicationTests;
import architecture.bean.BidRankBean;
import architecture.dao.BidRankDao;
import architecture.entity.BidRankEntity;
import architecture.jest.ClientFactory;
import architecture.jest.JestService;
import io.searchbox.client.JestClient;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * test of bid rank impl
 * @author cuihao
 */
public class BidRankDaoImplTest extends PriceParityApplicationTests {

    @Test
    public void findAll1() throws Exception {
        System.out.println(bidRankDao.findAll(-1,-1));
    }

    @Test
    public void findById() throws Exception {
        System.out.println(bidRankDao.findById("AVtlyrxx2QcGvg77hiED"));
    }

    @Test
    public void create1() throws Exception {
        BidRankEntity entity = new BidRankEntity();
        entity.setCommodityId("Test id");
        entity.setMoney(1);
        BidRankBean bidRankBean = bidRankDao.create(entity);
        System.out.println(bidRankBean);
        System.out.println(bidRankBean==null?"null":bidRankBean.getId());
    }

    @Test
    public void save1() throws Exception {
    }

    @Test
    public void delete() throws Exception {
        JestClient client = factory.getClient();
        jestService.delete(client, "srs");
    }

    @Resource
    private BidRankDao bidRankDao;

    @Resource
    private JestService jestService;

    @Resource
    private ClientFactory factory;

}