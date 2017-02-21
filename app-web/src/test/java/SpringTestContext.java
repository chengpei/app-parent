import com.alibaba.fastjson.JSON;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringTestContext {

    protected final Log logger = LogFactory.getLog(getClass());

    @Test
    public void webserviceTest() throws AxisFault {
        RPCServiceClient client = new RPCServiceClient();
        Options options = client.getOptions();
        // 调用地址
        EndpointReference target = new EndpointReference("http://localhost:8083/services/WhpeService?wsdl");
        options.setTo(target);
        // 调用action
        options.setAction("isLogin");
        // 调用方法（xmlns attribute、method）
        QName optName = new QName("http://webservices.whpe.com", "isLogin");
        // 参数
        Object[] paramObjs = new Object[]{ "123" };
        // 调用
        OMElement element = client.invokeBlocking(optName, paramObjs);
        // 返回
        String result = element.getFirstElement().getText();
        logger.info(result);
    }

    @Test
    public void httpTest() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8083/fileupload/http.do");
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("username", "vip"));
//        nvps.add(new BasicNameValuePair("password", "secret"));
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("username", "chengpei123");
        requestBody.put("password", "123456321");
        StringEntity entity = new StringEntity(JSON.toJSONString(requestBody), "UTF-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        CloseableHttpResponse response2 = httpclient.execute(httpPost);

        try {
            logger.info(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity2.getContent()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                logger.info(line);
            }
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
        }
    }

}