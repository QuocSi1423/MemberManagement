package DAL.IDAL;

import java.sql.Date;
import java.util.List;

import Entity.Usage;

public interface IUsageDAL {
    public static final Integer FILTER_ALL = 0; 
    public static final Integer FILTER_RETURNED = 1; 
    public static final Integer FILTER_NOT_YET_RETURNED = 2;
    
    
    public void insertUsage(Usage usage);

    public void deleteUsage(Integer usageId);
    
    public Usage getUsage(Integer usageId);
    
    public List<Usage> getBorrowingListByFilter(Integer filter,  Date startDate, Date endDate);

    public List<Usage> getEntryList(Date startDate, Date endDate);

    public void insertReturnTime(Integer usageId, Date returnTime);

    public void deleteReturnTime(Integer usageId);

}
