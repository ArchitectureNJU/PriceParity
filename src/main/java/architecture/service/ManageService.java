package architecture.service;

import architecture.bean.BidRankBean;
import architecture.bean.BlockIpBean;
import architecture.bean.BlockWordBean;
import architecture.bean.SynonymBean;
import architecture.entity.BidRankEntity;
import architecture.entity.BlockRecordEntity;
import architecture.entity.BlockWordEntity;
import architecture.entity.SynonymEntity;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cxworks on 17-4-12.
 */
public interface ManageService {

    //block ip
    public Iterator<BlockIpBean> getBlockIP(int offset, int size);

    public BlockIpBean create(BlockWordEntity blockIpBean);

    BlockIpBean save(BlockIpBean bean);

    BlockIpBean deleteIP(long id);


    //block word
    Iterator<BlockWordBean> getBlockWord(int offset, int size);


    BlockWordBean create(BlockRecordEntity entity);


    BlockWordBean save(BlockWordBean bean);


    BlockWordBean deleteWord(long id);

    //synonym???
    Iterator<SynonymBean> getSynonym(int offset, int size);

    SynonymBean create(SynonymEntity entity);


    SynonymBean save(SynonymBean bean);


    SynonymBean delete(long id);

    //bidrank
    Iterator<BidRankBean> getBidRank(int offset, int size);

    BidRankBean create(BidRankEntity bidRankEntity);

    BidRankBean save(BidRankBean bidRankEntity);
}
