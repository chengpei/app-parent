import com.whpe.bean.SysModel;
import com.whpe.dao.SysModelMapper;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/2/22.
 */
public class TestJdbc extends SpringTestContext{

    @Resource
    private SysModelMapper sysModelMapper;

    @Test
    public void test1(){
        SysModel sysModel = sysModelMapper.selectByPrimaryKey("f499f372-3422-452b-ac48-412af7351c0b");
        logger.info(sysModel.getModelName());
    }
}
