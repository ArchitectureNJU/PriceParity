package architecture.service.impl;

import architecture.bean.*;
import architecture.dao.*;
import architecture.entity.*;
import architecture.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cxworks on 17-4-13.
 */
@Component
@Transactional
public class ManageImpl implements ManageService {
    @Autowired
    BlockIpDao blockIpDao;
    @Autowired
    BlockWordDao blockWordDao;
    @Autowired
    BidRankDao bidRankDao;
    @Autowired
    SynonymDao synonymDao;
    @Autowired
    BlockRecordDao blockRecordDao;

    @Override
    public Iterator<BlockIpBean> getBlockIP(int offset, int size) {
        return blockIpDao.findAll(offset, size).iterator();
    }

    @Override
    public BlockIpBean create(BlockIpEntity blockIpBean) {
        return blockIpDao.create(blockIpBean);
    }

    @Override
    public BlockIpBean save(BlockIpBean bean) {
        return blockIpDao.save(bean);
    }

    @Override
    public BlockIpBean deleteIP(String id) {
        return blockIpDao.delete(id);
    }

    @Override
    public Iterator<BlockWordBean> getBlockWord(int offset, int size) {
        return blockWordDao.findAll(offset, size).iterator();
    }

    @Override
    public BlockWordBean create(BlockWordEntity entity) {
        return blockWordDao.create(entity);
    }

    @Override
    public BlockWordBean save(BlockWordBean bean) {
        return blockWordDao.save(bean);
    }

    @Override
    public BlockWordBean deleteWord(String id) {
        return blockWordDao.delete(id);
    }

    @Override
    public Iterator<SynonymBean> getSynonym(int offset, int size) {
        return synonymDao.findAll(offset, size).iterator();
    }

    @Override
    public SynonymBean create(SynonymEntity entity) {
        return synonymDao.create(entity);
    }

    @Override
    public SynonymBean save(SynonymBean bean) {
        return synonymDao.save(bean);
    }

    @Override
    public SynonymBean deleteSynonym(String id) {
        return synonymDao.delete(id);
    }

    @Override
    public Iterator<BidRankBean> getBidRank(int offset, int size) {
        return bidRankDao.findAll(offset, size).iterator();
    }

    @Override
    public BidRankBean create(BidRankEntity bidRankEntity) {
        return bidRankDao.create(bidRankEntity);
    }

    @Override
    public BidRankBean save(BidRankBean bidRankEntity) {
        return bidRankDao.save(bidRankEntity);
    }

    @Override
    public Iterator<BlockRecordBean> findAll(int offset, int size) {
        return blockRecordDao.findAll(offset, size).iterator();
    }

    @Override
    public BlockRecordBean create(BlockRecordEntity entity) {
        return blockRecordDao.create(entity);
    }

    @Override
    public BlockRecordBean save(BlockRecordBean bean) {
        return blockRecordDao.save(bean);
    }

    @Override
    public BlockRecordBean deleteRecord(String id) {
        return blockRecordDao.delete(id);
    }
}
