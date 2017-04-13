package architecture.dao.impl;

import architecture.PriceParityApplicationTests;
import architecture.dao.BidRankDao;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * test of bid rank impl
 * @author cuihao
 */
public class BidRankDaoImplTest extends PriceParityApplicationTests {

    @Resource
    private BidRankDao bidRankDao;

    @Test
    public void findAll() throws Exception {
        bidRankDao.findAll(0,0);
    }

    @Test
    public void findByKeyWord() throws Exception {
    }

    @Test
    public void create() throws Exception {

    }

    @Test
    public void save() throws Exception {
    }

}