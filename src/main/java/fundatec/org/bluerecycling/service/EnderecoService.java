//package fundatec.org.bluerecycling.service;
//
//import com.google.gson.Gson;
//import fundatec.org.bluerecycling.model.Endereco;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
//import org.springframework.http.HttpEntity;
//import org.springframework.stereotype.Service;
//import java.io.IOException;
//
//@Service
//public class EnderecoService {
//    public Endereco getEndereco(String cep) throws ClientProtocolException, IOException {
//        Endereco endereco = null;
//        HttpGet request = new HttpGet("https://viacep.com.br/ws/"+cep+"/json/");
//        try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
//            CloseableHttpResponse response = httpClient.execute(request))
//            {
//                HttpEntity entity = response.getEntity();
//                if (entity != null) {
//                    String result = EntityUtils.toString(entity);
//                    Gson gson = new Gson();
//                    endereco = gson.fromJson(result, Endereco.class);
//                }
//            }
//        }
//    }
//}
