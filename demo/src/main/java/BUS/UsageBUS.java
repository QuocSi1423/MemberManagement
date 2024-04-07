package BUS;

import java.sql.Date;

import java.util.List;

import DAL.IDAL.IUsageDAL;
import DAL.UsageDAL;
import Entity.Usage;

public class UsageBUS {
    private IUsageDAL store;

    public UsageBUS() {
        this.store = new UsageDAL();
    }

    public UsageBUS(IUsageDAL store) {
        this.store = store;
    }

    
    public void CreateUsage(Usage Usage) {
        try {
            store.insertUsage(Usage);
        } catch (Exception e) {
            throw e;
        }
    }

    public void RemoveUsage(Integer id) {
        try {
            store.deleteUsage(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public Usage getUsage(Integer id) {
        return store.getUsage(id);
    }

    public List<Usage> GetBorrowingListByFilter(Integer filter, Date startDate, Date endDate) {
        try {
            return store.getBorrowingListByFilter(filter, startDate, endDate);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Usage> GetBorrowingListByMemberId(Integer memberId) {
        try {
            return store.getBorrowingListByMemberId(memberId);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Usage> GetEntryList(Date startDate, Date endDate) {
        try {
            return store.getEntryList(startDate, endDate);
        } catch (Exception e) {
            throw e;
        }
    }

    public void AddReturnTimeOfUsage(Integer usageId, Date returnTime) throws Exception {
        try {
            Date currentTime = new Date(System.currentTimeMillis());
            if (currentTime.compareTo(returnTime) > 0) {
                throw new Exception("invalid status");
            }
            store.insertReturnTime(usageId, returnTime);
        } catch (Exception e) {
            throw e;
        }
    }

    public void RemoveReturnTimeOfUsage(Integer usageId) {
        try {
            store.deleteReturnTime(usageId);
        } catch (Exception e) {
            throw e;
        }
    }

}