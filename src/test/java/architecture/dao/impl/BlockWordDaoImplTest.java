package architecture.dao.impl;

import architecture.PriceParityApplicationTests;
import architecture.bean.BlockWordBean;
import architecture.dao.BlockWordDao;
import architecture.entity.BlockWordEntity;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2017/4/14.
 */
public class BlockWordDaoImplTest extends PriceParityApplicationTests {

    @Resource
    private BlockWordDao blockWordDao;

    @Test
    public void findAll() throws Exception {
        System.out.println(blockWordDao.findAll(0,10));
    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void create() throws Exception {
        BlockWordEntity entity = new BlockWordEntity();
        entity.setEndTime(System.currentTimeMillis());
        entity.setKeyWord("习近平");
        BlockWordBean bean = blockWordDao.create(entity);
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}