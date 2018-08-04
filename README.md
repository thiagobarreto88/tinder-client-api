Como utilizar o fiddler (<a href="https://www.telerik.com/fiddler">Link</a>) para capturar trafego de rede de smartphone

Link: shttp://www.cantoni.org/2013/11/06/capture-android-web-traffic-fiddler

Premissa:

	1. Ter uma conta no facebook
	

Desafio: 

	Via postman, soapUI, java, etc.

		1. Autenticar no Tinder
		2. Atualizar a localização para um lugar qualquer do mapa através de latitude e longitude (só consegui fazer via java e via SoapUI).
		3. Recuperar as recomendações.
		4. Dar "likes" nas recomendações.

		
	1. Autenticar no Tinder

		A autenticação no Tinder é feita através do access_token do Facebook e do ID do facebook.
		
		1.1. Acessar a URL abaixo no Google Chrome:
			https://www.facebook.com/v2.6/dialog/oauth?redirect_uri=fb464891386855067%3A%2F%2Fauthorize%2F&display=touch&state=%7B%22challenge%22%3A%22IUUkEUqIGud332lfu%252BMJhxL4Wlc%253D%22%2C%220_auth_logger_id%22%3A%2230F06532-A1B9-4B10-BB28-B29956C71AB1%22%2C%22com.facebook.sdk_client_state%22%3Atrue%2C%223_method%22%3A%22sfvc_auth%22%7D&scope=user_birthday%2Cuser_photos%2Cuser_education_history%2Cemail%2Cuser_relationship_details%2Cuser_friends%2Cuser_work_history%2Cuser_likes&response_type=token%2Csigned_request&default_audience=friends&return_scopes=true&auth_type=rerequest&client_id=464891386855067&ret=login&sdk=ios&logger_id=30F06532-A1B9-4B10-BB28-B29956C71AB1&ext=1470840777&hash=AeZqkIcf-NEW6vBd
		1.2.Realizar login do facebook com usuário e senha
		1.3.	Utilizando o inspect do Chrome (F12) verificar as requisiçoes realizadas
			Após clicar no 'OK', é visto uma chamada Ajax (POST) para a URL https://www.facebook.com/v2.6/dialog/oauth/confirm?dpr=1 com o access_token na aba response

		Utilizar o access_token para realizar chamada a API de autenticacao do Tinder conforme detalhado abaixo.
		Em caso de sucesso "api_token" que é o token interno do Tinder utilizado nas demais APIs do Tinder (busca, like, envio de mensagens, etc) enviadon o header "X-Auth-Token".

		Método HTTP: POST
		URL: https://api.gotinder.com/auth
		
		Body (utilizar o access_token gerado no passo acima):
			{"facebook_token": "<ACCESS_TOKEN>", "facebook_id": "<FACEBOOK_ID>"}

			<ACCESS_TOKEN>: utilizar o access_token gerado no passo acima
			<FACEBOOK_ID>: Para recupera o facebook_id abrir a URL no browser: https://graph.facebook.com/me?access_token=<ACCESS_TOKEN> e pegar o valor do campo "id" do JSON retornado.
			
		IMPORTANTE: Caso nao consiga recuperar o access_token do Facebook e nem realizar a autenticacao da API do Tinder é possível utilizar o Tinder Web (https://tinder.com) e na aba "Network" do Google Chrome verificar os requests internos realizados para as demais APIS e identificar o header "X-Auth-Token" utilizado para realizar as chamadas as outras APIs.
		
	2. Atualizar a localização para um lugar qualquer do mapa através de latitude e longitude.

		EU SÓ CONSEGUI FAZER FUNCIONAR VIA SOAPUI E VIA JAVA, por algum motivo via Postman não funciona. Acho que é o User-Agent do Chrome que gera o erro.

		Método HTTP: POST
		URL: https://api.gotinder.com/user/ping
		Headers: 
			X-Auth-Token: <TOKEN GERADO NA AUTENTICACAO DO TINDER, NAO É O ACCESS_TOKEN>
			User-Agent: Tinder Android Version 5.3.4
		Body (exemplo de latitude e longitude da India):
			{"lat": 19.0822507, "lon": 72.8812041}

		Sucesso: {"status":"200","error":null}
		Erro:  { "status": 200, "error": "major position change not significant"} - ESTE ERRO OCORRE QUANDO A SUA POSICAO NAO MUDOU SIGNIFICAMENTE

		Para recuperar a latitude e longitude de um lugar é possível usar o site abaixo:
		https://www.latlong.net/

	3. Recuperar as recomendações.

		Método HTTP: GET
		URL: https://api.gotinder.com/user/recs
		Header: X-Auth-Token: <TOKEN GERADO NA AUTENTICACAO DO TINDER, NAO É O ACCESS_TOKEN>
		
		Esta API retorna no máximo 11 resultados. O id (campo _id) de cada resultado é utilizar para realizar o like ou dislike.
		

	4. Dar "likes" nas recomendações.
		
		Método HTTP: GET
		URL: https://api.gotinder.com//like/{id} 
		Header: X-Auth-Token: <TOKEN GERADO NA AUTENTICACAO DO TINDER, NAO É O ACCESS_TOKEN>
		
		O {id} deve ser substituido pelo campo _id retornado no passo 3.
	

<a href="https://github.com/fbessez/Tinder">Link com detalhe sobre as APIs do TINDER</a>
