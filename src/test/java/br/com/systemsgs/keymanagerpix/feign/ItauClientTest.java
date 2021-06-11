package br.com.systemsgs.keymanagerpix.feign;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import br.com.systemsgs.keymanagerpix.dto.ModelUsuarioDTO;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;

public class ItauClientTest {
	
	private ItauClient itauClient;
	
	private static String BASE_URL_ITAU_CLIENT = "http://localhost:9091";
	private static String RESULT_STATIC_CLIENT_ITAU = 
			"[{\r\n"
			+ "    \"tipo\": \"CONTA_CORRENTE\",\r\n"
			+ "    \"instituicao\": {\r\n"
			+ "      \"nome\": \"ITAÚ UNIBANCO S.A.\",\r\n"
			+ "      \"ispb\": \"apaguei\"\r\n"
			+ "    },\r\n"
			+ "    \"agencia\": \"apaguei\",\r\n"
			+ "    \"numero\": \"apaguei\",\r\n"
			+ "    \"titular\": {\r\n"
			+ "      \"id\": \"c56dfef4-7901-44fb-84e2-a2cefb1578900\",\r\n"
			+ "      \"nome\": \"Rafael M C Ponte\",\r\n"
			+ "      \"cpf\": \"apaguei\"\r\n"
			+ "    }\r\n"
			+ "  }]";
	
	@Test
	public void testeRequisicaoItauClient() {
		this.builderFeignClient(new MockClient().ok(HttpMethod.GET,
				 BASE_URL_ITAU_CLIENT,
				RESULT_STATIC_CLIENT_ITAU));
		
		List<ModelUsuarioDTO> listaUsuariosItau = itauClient.retornaTodosClientesItau();
		
		assertFalse(listaUsuariosItau.isEmpty());
		
	}
	
	private void builderFeignClient(MockClient mockClient) {
		itauClient = Feign.builder()
				.client(mockClient)
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.contract(new SpringMvcContract())
				.target(ItauClient.class, BASE_URL_ITAU_CLIENT);
	}
	
}
