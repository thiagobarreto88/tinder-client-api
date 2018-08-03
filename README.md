Como utilizar o fiddler (<a href="https://www.telerik.com/fiddler"Link</a>) para capturar trafego de rede de smartphone

http://www.cantoni.org/2013/11/06/capture-android-web-traffic-fiddler

OAuth do Facebook
	
	1. Acessar a URL abaixo no Google Chrome:
		https://www.facebook.com/v2.6/dialog/oauth?redirect_uri=fb464891386855067%3A%2F%2Fauthorize%2F&display=touch&state=%7B%22challenge%22%3A%22IUUkEUqIGud332lfu%252BMJhxL4Wlc%253D%22%2C%220_auth_logger_id%22%3A%2230F06532-A1B9-4B10-BB28-B29956C71AB1%22%2C%22com.facebook.sdk_client_state%22%3Atrue%2C%223_method%22%3A%22sfvc_auth%22%7D&scope=user_birthday%2Cuser_photos%2Cuser_education_history%2Cemail%2Cuser_relationship_details%2Cuser_friends%2Cuser_work_history%2Cuser_likes&response_type=token%2Csigned_request&default_audience=friends&return_scopes=true&auth_type=rerequest&client_id=464891386855067&ret=login&sdk=ios&logger_id=30F06532-A1B9-4B10-BB28-B29956C71AB1&ext=1470840777&hash=AeZqkIcf-NEW6vBd
	2.Realizar login do facebook com usuário e senha
	3.	Utilizando o inspect do Chrome (F12) verificar as requisiçoes realizadas
		Após clicar no 'OK', é visto uma chamada Ajax (POST) para a URL https://www.facebook.com/v2.6/dialog/oauth/confirm?dpr=1 com o access_token na aba response

	Utilizar o access_token para realizar chamada a API de autenticacao do Tinder
	Em caso de sucesso sera retornado um token que deve ser utilizado nas chamadas as demais APIs do Tinder (no header "X-Auth-Token").
	

Caso nao consiga recuperar o access_token do Facebook e nem realizar a autenticacao da API do Tinder é possível utilizar o Tinder Web (https://tinder.com) e na aba "Network" do Google Chrome
verificar os requests internos realizados para as demais APIS e identificar o header "X-Auth-Token" utilizado para realizar as chamadas as outras APIs.

<a href="https://github.com/fbessez/Tinder">API do TINDER</a>