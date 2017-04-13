package architecture.dao.impl;

import architecture.PriceParityApplicationTests;
import architecture.bean.BidRankBean;
import architecture.dao.BidRankDao;
import architecture.entity.BidRankEntity;
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
    }

    @Test
    public void findById() throws Exception {
        System.out.println(bidRankDao.findById("AVtlyrxx2QcGvg77hiED"));
    }

    @Test
    @Rollback
    @Transactional
    public void create1() throws Exception {
        BidRankEntity entity = new BidRankEntity();
        entity.setCommodityId(0);
        entity.setMoney(0);
        BidRankBean bidRankBean = bidRankDao.create(entity);
        System.out.println(bidRankBean);
        System.out.println(bidRankBean==null?"null":bidRankBean.getId());
    }

    @Test
    public void save1() throws Exception {
    }

    @Test
    public void delete() throws Exception {
        System.out.println(bidRankDao.delete("AVtl30Va2QcGvg77hiEK"));
    }

    @Resource
    private BidRankDao bidRankDao;

}