package architecture.dao.impl;

import architecture.PriceParityApplicationTests;
import architecture.bean.CommodityBean;
import architecture.dao.CommodityDao;
import architecture.entity.CommentEntity;
import architecture.entity.CommodityEntity;
import architecture.jest.ClientFactory;
import architecture.jest.JestService;
import io.searchbox.client.JestClient;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2017/4/14.
 */
public class CommodityDaoImplTest extends PriceParityApplicationTests{

    @Test
    public void mapping() throws Exception {
        JestClient client = clientFactory.getClient();
        jestService.createIndexMapping(client,"srs","commodity","");
    }

    @Test
    public void findById() throws Exception {
        System.out.println(commodityDao.findById("AVtrz9WEWl2TViG5FV4v"));
    }

    @Test
    public void findByKeyWord() throws Exception {
        List<String> keywords = new ArrayList<>();
        List<CommodityBean> commodityBeans = commodityDao.findByKeyWord(keywords, 0, 10);
        System.out.println(commodityBeans);
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void create() throws Exception {
        CommodityEntity entity = new CommodityEntity();
        entity.setAvatar("https://img14.360buyimg.com/n0/jfs/t3067/308/5815960105/98807/97ab361d/5880849cNe6f36103.jpg");
        List<CommentEntity> commentEntities = new ArrayList<>();
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setContent("非常好用！");
        commentEntity.setCreated_at(new Date(System.currentTimeMillis()));
        commentEntity.setSource("京东");
        commentEntity.setStatus(1);
        commentEntity.setUrl("https://item.jd.com/4294178.html?abt=search_main&from=cps&cu=true&utm_source=gou.jd.com&utm_medium=uniongou&utm_campaign=t_45363_&utm_term=3bc851adcc81421ba75d65d5d95f1cc5&abt=3");
        commentEntity.setUrl("京东买家1211");
        commentEntities.add(commentEntity);
        entity.setComments(commentEntities);
        entity.setDescription("【新加的数据】(HP)惠普商用360°翻转轻薄触控笔记本新品上市！接口齐全！带触控笔！");
        entity.setName("This is a test title");
        entity.setPrice(5999.0);
        entity.setSource("京东");
        entity.setSummary("惠普笔记本电脑");
        entity.setUpdated_at(new Date(System.currentTimeMillis()));
        entity.setUrl("https://item.jd.com/4294178.html?abt=search_main&from=cps&cu=true&utm_source=gou.jd.com&utm_medium=uniongou&utm_campaign=t_45363_&utm_term=3bc851adcc81421ba75d65d5d95f1cc5&abt=3");
        CommodityBean bean = commodityDao.create(entity);
        System.out.println(bean);
    }

    @Resource
    private CommodityDao commodityDao;

    @Resource
    private JestService jestService;

    @Resource
    private ClientFactory clientFactory;

}