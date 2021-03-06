package architecture.service;

import architecture.bean.*;
import architecture.entity.*;

import java.util.List;

/**
 * Created by cxworks on 17-4-12.
 */
public interface ManageService {

    //block ip
    public List<BlockIpBean> getBlockIP(int offset, int size);

    public BlockIpBean create(BlockIpEntity blockIpBean);

    BlockIpBean save(BlockIpBean bean);

    BlockIpBean deleteIP(String id);


    //block word
    List<BlockWordBean> getBlockWord(int offset, int size);


    BlockWordBean create(BlockWordEntity entity);


    BlockWordBean save(BlockWordBean bean);


    BlockWordBean deleteWord(String id);

    //synonym???
    List<SynonymBean> getSynonym(int offset, int size);

    SynonymBean create(SynonymEntity entity);


    SynonymBean save(SynonymBean bean);

    SynonymBean findSynonymByid(String id);


    SynonymBean deleteSynonym(String id);

    //bidrank
    List<BidRankBean> getBidRank(int offset, int size);

    BidRankBean create(BidRankEntity bidRankEntity);

    BidRankBean save(BidRankBean bidRankEntity);

    BidRankBean deleteBidRank(String id);

    BidRankBean findBidRankByid(String id);


    //blockrecord
    List<BlockRecordBean> getBlockRecord(int offset, int size);

    BlockRecordBean create(BlockRecordEntity entity);

    BlockRecordBean save(BlockRecordBean bean);


}
