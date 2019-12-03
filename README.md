# SMS-LATAM-Challenge

El challenge fue resuelto hasta el nivel 3, quedando pendiende el deploy a heroku
repositorio en github : https://github.com/TiagoQuinteros/SMS-LATAM-Challenge


To run application: mutantDetector

By default it's run in localhost:8989

requirements

postgresql
git
maven
postman or similar


steps:

1- execute this comand in a empty folder: git clone https://github.com/TiagoQuinteros/SMS-LATAM-Challenge.git
2- execute this comand: mvn clean compile spring-boot:run
3- open postman and use the services

example of curls to use the services

example 1: Mutant

curl -X POST \
  http://localhost:9898/mutant/ \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: eaba5b0a-2093-4c71-8ebe-e9e1e66d9abb' \
  -H 'cache-control: no-cache' \
  -d '{
"dna":["AAGTGC","AAATGC","AAGTGC","AAATGC"]
}
'
reponse: STATUS 200 OK

example 2: noMutant

curl -X POST \
  http://localhost:9898/mutant/ \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 30' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:9898' \
  -H 'Postman-Token: 6681627a-689e-4a46-af82-dacbfe6d9d7f,f0b72247-6958-492e-a054-74b18cc21785' \
  -H 'User-Agent: PostmanRuntime/7.19.0' \
  -H 'cache-control: no-cache' \
  -d '{
"dna":["AAGTGC","AAATGC"]
}
'
response: STATUS: 403 Forbidden

example 3: stats

curl -X GET \
  http://localhost:9898/stats \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 48' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:9898' \
  -H 'Postman-Token: 77d7f890-ff7f-4a9a-8ca4-cc688d474f0e,7e66e64f-4ec9-4127-86bf-18dbf9b1ffaa' \
  -H 'User-Agent: PostmanRuntime/7.19.0' \
  -H 'cache-control: no-cache' \
  -d '{
"dna":["AAGTGC","AAATGC","AAGTGC","AAATGC"]
}
'

response: 
{
    "count_mutant_dna": 1.0,
    "count_human_dna": 1.0,
    "ratio": 0.5
}


evidencia test 

GROUP,PACKAGE,CLASS,INSTRUCTION_MISSED,INSTRUCTION_COVERED,BRANCH_MISSED,BRANCH_COVERED,LINE_MISSED,LINE_COVERED,COMPLEXITY_MISSED,COMPLEXITY_COVERED,METHOD_MISSED,METHOD_COVERED
mutantDetector (1) (02/12/2019 12:38:52)/mutantDetector/src/main/java,com.SMSLATAM.app,statsResponse,0,24,0,0,0,10,0,7,0,7
mutantDetector (1) (02/12/2019 12:38:52)/mutantDetector/src/main/java,com.SMSLATAM.app.domain.service,AdnApi,10,26,0,0,4,12,3,5,3,5
mutantDetector (1) (02/12/2019 12:38:52)/mutantDetector/src/main/java,com.SMSLATAM.app.domain.service.Impl,MutantDetectorServiceImpl,0,346,1,47,0,68,1,29,0,6
mutantDetector (1) (02/12/2019 12:38:52)/mutantDetector/src/test/java,com.SMSLATAM.rest,MutantDetectorServiceTest,6,283,6,6,0,40,6,8,0,8



