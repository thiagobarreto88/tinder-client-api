package com.brrt.tinder.client.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.brrt.tinder.client.constants.URLConstants;
import com.brrt.tinder.client.domain.auth.AuthenticationResponse;
import com.brrt.tinder.client.domain.auth.FacebookAuthDomain;
import com.brrt.tinder.client.domain.like.LikeResponse;
import com.brrt.tinder.client.domain.message.Message;
import com.brrt.tinder.client.domain.message.MessageRequest;
import com.brrt.tinder.client.domain.message.MessageResponse;
import com.brrt.tinder.client.domain.recs.RecommendationsRequest;
import com.brrt.tinder.client.domain.recs.RecommendationsResponse;
import com.brrt.tinder.client.domain.recs.Result;
import com.brrt.tinder.client.domain.update.location.UpdateLocationRequest;
import com.brrt.tinder.client.domain.update.location.UpdateLocationResponse;
import com.brrt.tinder.client.domain.update.profile.UpdateProfileRequest;
import com.brrt.tinder.client.domain.updates.Match;
import com.brrt.tinder.client.domain.updates.UpdatesRequest;
import com.brrt.tinder.client.domain.updates.UpdatesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TinderClient {
	
	@SuppressWarnings("deprecation")
	static DefaultHttpClient httpClient = new DefaultHttpClient();
	
	static RestTemplate restTemplate = new RestTemplate();
	static List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	static MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
	
	static String authToken = null;
	static String tinderUserId;
	
	public static void initObjects(){
		messageConverters.add(map);
		restTemplate.setMessageConverters(messageConverters);
	}
	
	public static void setAuthToken(String value){
		authToken = value;
	}
	
	public static void main(String[] args) throws JsonProcessingException{
			
		messageConverters.add(map);
		restTemplate.setMessageConverters(messageConverters);
		 
		
		//String facebookToken = "EAAGm0PX4ZCpsBAGiPrKHHqAKHjHWaQPrAups2Gxx8XYfIxzhJj8j2RkgBDAAmZAq4NpoiZBJQjPqntZA2UvM6uiiGFiZBLaKjgSvdjjyTtdFE4mdZCSMVP7G32dO3nynzVJVVfIoZCQmpbPOkA8LmoskzwVAwZAkQ4Hv2bKDGaZAeZCmUOZAv8tLh6ZA";
		//String facebookToken = "EAAGm0PX4ZCpsBAGrFCy2cVMvOvwkPFEzvZC1BDRI9sskUgsiZADrAfAPbxHk5jK5KaSCEsxI7DX05G9M57fLcgvVa01p66bi3prLMcS6el8Utd9Y53bLLU5YcEZCYM7ZAan12VwakqEajeDTPZCarWjvWgviuabA6cfZAGZBipo27cCD6IqgpX0TUZB8SwhECklPK8q67YOsQsZByzh2KZBYmT4l0JjXdem4WGKuZC7YhZBSZC9YkvLLj0xekMNsy9W1nRquUZD";
		String facebookToken = "EAAGm0PX4ZCpsBALP9EyfRyCp4YDkvi9lA7Hbr6Y5byFEYCcIduWQPmqxfJlM1GxUK6M4sxbsBXlC6ksv83LCjc5ZCJikhTYDtWBTcvzVyvoW3qsQTJmuLloVbCoKlFW6Nz7AHPSGvGw2VRinjOI0jRDApMrARZAZBecEVZAyG0wkgyCA3yDU4uKv8vWeIGQFtrd8TdOF1CPe9ZAIwRNZC5ZBmqCuqLdeDnqmp4PeXol89x8l1Sr09iJd9TjZA08ZBR2LoZD";
		String facebookUserId = "100002031514194";
		
		//autenticacao
		//AuthenticationResponse authResponse = authenticate(facebookToken, facebookUserId);
		
		//Calcula data para pesquisa de updates
		//activeTime=2016-08-06T04:06:37.957Z
		//{"last_activity_date":"2016-08-06T13:18:16.911Z"}
		//String lastActivityDate= authResponse.getUser().getActiveTime();
		//String lastActivityDateToSearch = getLastActivityDateToSearch(lastActivityDate);
		
		//atualiza o token de autenticacao do Tinder para ser utilizado em todos os requests as demais APIs
		//authToken = authResponse.getAuthToken();
		//authToken = "e8b8efda-d08d-4de0-91b3-89abcc795b30";
		authToken = "6e7accc0-d1cb-4c9a-baf0-620216a26fb3";
		//tinderUserId = authResponse.getUser().getId();
		
		 //Atualiza localizacao  
		//updateLocation();
		
		// Atualiza perfil - Idades desejadas e distancia 
		//updateProfile(6);
		
		// Recupera as atualizacoes (Matches, mensagens)  
		//FIXME alterar para recuperar as ultimas atualizacoes
		//ESTA FIXO UMA DATA 
		//UpdatesResponse updatesRespone = getUpdates(lastActivityDateToSearch);
		//handleUpdates(updatesRespone, lastActivityDate);
		
		/* Recupera as recomendacoes de acordo com o perfil (idades e distancia) */
		/*int i = 0;
		while(i < 15){
			i++;
			RecommendationsResponse response = getRecommendations();
			
			if(response != null && response.getResults() != null && !response.getResults().isEmpty()){
				for(Result rec : response.getResults()){
					//Da Like em uma recomendacao 
					Object likeResult = likePerson(rec.getId());
					
					//Se o like retornou match imediato envia mensagem padrao "Oi, tudo bem?"
					if(likeResult.toString().contains("match=true")){
						//sendMessage(rec.getId(), "Oi, tudo bem?");
					}
					
				}
			}
		}*/
		
		LikeResponse likeResult = likePerson("5b43acde6ac7bb08232f3cb5");
		
			
	}
	
	private static String getLastActivityDateToSearch(String lastActivityDate) {
		System.out.println(lastActivityDate);
		String[] split = lastActivityDate.split("T");
		String date = split[0];
		String time = split[1];
		String hour = time.substring(0, 2);
		String hourRest = time.substring(2, 13);
		
		Integer hourInt = Integer.valueOf(hour);
		hourInt = hourInt - 4;
		if(hourInt.intValue() < 0){
			hourInt = 00;
		}
		
		String searchLastActivityDate = null;
		
		if(hourInt.intValue() < 10){
			searchLastActivityDate = date + "T" + "0" + hourInt + hourRest;
		}else{
			searchLastActivityDate = date + "T" + hourInt + hourRest;
		}
		
		System.out.println(searchLastActivityDate);
		
		return searchLastActivityDate;
	}
	
	private static void handleUpdates(UpdatesResponse updatesRespone, String searchLastActivityDate){
		/* Itera a lista de updates */
		if(updatesRespone != null && updatesRespone.getMatches() != null && !updatesRespone.getMatches().isEmpty()){
			List<Match> matches = updatesRespone.getMatches();
			
			/* Itera a lista de updates - Por Match */
			for(Match match : matches){
				
				//verifica a data de atualizacao do match - Se for menor que a da busca, nao faz nada
				String lastActivityDateFromMatch = match.getLastActivityDate();
				
				if(searchLastActivityDate.compareTo(lastActivityDateFromMatch) < 0){
					List<Message> messages = match.getMessages();
					
					//Match sem nenhuma mensagem - Envia mensagem padrao "Oi, tudo bem?"
					if(messages.isEmpty()){
						sendMessage(match.getId(), "Oi, tudo bem?");
						
					}
				}
				
				/*//Verifica que eh uma nova mensagem
				if("true".equals(match.getIsNewMessage())){

					 Itera a lista de mensagens - Por Match 
					for(Message message : messages){
						
						 Se a mensagem foi enviada pela outra pessoa, entao envia mensagem 
						if(!tinderUserId.equals(message.getFrom())){
							 Enviar mensagem padrao 
							sendMessage(match.getId(), ".");
							break;
						}
						
					}	
				}*/
				
			}	
		}
	}
	
	public static AuthenticationResponse authenticate(String facebookToken, String facebookUserId){
		initObjects();
		FacebookAuthDomain authDomain = new FacebookAuthDomain();
		authDomain.setFacebookToken(facebookToken);
		//authDomain.setFacebookId(facebookUserId);
		authDomain.setLocale("pt");
			
		HttpEntity<FacebookAuthDomain> entity = new HttpEntity<FacebookAuthDomain>(authDomain, Util.getHeaders(authToken));
		ResponseEntity<AuthenticationResponse> response = restTemplate.exchange(URLConstants.authenticationURL, HttpMethod.POST, entity, AuthenticationResponse.class);
		System.out.println(response);
		
		//return null;
		return response.getBody();
		
	}
	
	public static void updateLocation(){
		
		UpdateLocationRequest updateLocationRequest = new UpdateLocationRequest();
		updateLocationRequest.setLatitude(19.0822507);
		//updateLocationRequest.setLatitude(-34.603684);

		//"lat": 19.0822507, "lon": 72.8812041}
		updateLocationRequest.setLongitude(72.8812041);
		//updateLocationRequest.setLongitude(-58.381559);

		
		HttpEntity<UpdateLocationRequest> entity = new HttpEntity<UpdateLocationRequest>(updateLocationRequest, Util.getHeaders(authToken));
		
		ResponseEntity<UpdateLocationResponse> response = restTemplate.exchange(URLConstants.updateLocationURL, HttpMethod.POST, entity, UpdateLocationResponse.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(response.getBody()));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response);
		
	}
	
	/**
	 * Atualiza o perfil - Idades desejadas e distancia
	 */
	public static void updateProfile(int distanceFilter){
		
		UpdateProfileRequest request = new UpdateProfileRequest();
		request.setAgeFilterMin(18);
		request.setAgeFilterMax(40);
		//request.setGender("0");
		request.setDistanceFilter(distanceFilter);
		
		HttpEntity<UpdateProfileRequest> entity = new HttpEntity<UpdateProfileRequest>(request, Util.getHeaders(authToken));
		Object response = restTemplate.exchange(URLConstants.profileURL, HttpMethod.POST, entity, Object.class);
		System.out.println(response);

	}
	
	/**
	 * 
	 * @return 11 recomendacoes de like
	 * @throws JsonProcessingException 
	 */
	public static RecommendationsResponse getRecommendations() throws JsonProcessingException{
		initObjects();
		RecommendationsRequest request = new RecommendationsRequest();
		HttpEntity<RecommendationsRequest> entity = new HttpEntity<RecommendationsRequest>(request, Util.getHeaders(authToken));
		//Object recommendations = restTemplate.exchange(URLConstants.recommendationsURL, HttpMethod.GET, entity, Object.class);
		ResponseEntity<RecommendationsResponse> recommendations = restTemplate.exchange(URLConstants.recommendationsURL, HttpMethod.GET, entity, RecommendationsResponse.class);
		System.out.println(recommendations.getBody());
		ObjectMapper mapper = new ObjectMapper();
		String jsonResponse = mapper.writeValueAsString(recommendations.getBody());
		System.out.println(jsonResponse);

		//return null;
		return recommendations.getBody();
		
	}
	
	/**
	 * Da like em um usuario
	 * @param userId
	 * @return
	 */
	public static LikeResponse likePerson(String userId){
		
		HttpEntity<Object> entity = new HttpEntity<Object>(Util.getHeaders(authToken));
		try{
			ResponseEntity<LikeResponse> response = restTemplate.exchange(URLConstants.likeURL, HttpMethod.GET, entity, LikeResponse.class, userId);
			System.out.println(response.toString());
		
			return response.getBody();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void sendMessage(String id, String message){
		
		MessageRequest request = new MessageRequest();
		request.setMessage(message);
		
		HttpEntity<MessageRequest> entity = new HttpEntity<MessageRequest>(request, Util.getHeaders(authToken));
		
		ResponseEntity<MessageResponse> response = restTemplate.exchange(URLConstants.messageURL, HttpMethod.POST, entity, MessageResponse.class, id);		
		System.out.println(response);
		
	}
	
	public static UpdatesResponse getUpdates(String lastActivityDate){
		
		UpdatesRequest request = new UpdatesRequest();
		request.setLastActivityDate(lastActivityDate);
		
		HttpEntity<UpdatesRequest> entity = new HttpEntity<UpdatesRequest>(request, Util.getHeaders(authToken));
		ResponseEntity<UpdatesResponse> response = restTemplate.exchange(URLConstants.updatesURL, HttpMethod.POST, entity, UpdatesResponse.class);	
		System.out.println(response);
		
		return response.getBody();
		
	}
	
	public static UpdatesResponse getProfile(String lastActivityDate){
		
		UpdatesRequest request = new UpdatesRequest();
		request.setLastActivityDate(lastActivityDate);
		
		HttpEntity<UpdatesRequest> entity = new HttpEntity<UpdatesRequest>(request, Util.getHeaders(authToken));
		ResponseEntity<UpdatesResponse> response = restTemplate.exchange(URLConstants.updatesURL, HttpMethod.POST, entity, UpdatesResponse.class);	
		System.out.println(response);
		
		return response.getBody();
		
	}
	

}