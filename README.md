# 설정
## docker 설정
https://soyoung-new-challenge.tistory.com/73

docker-compose.yml 디렉토리로 이동
```
docker-compose up -d
```

## vue 사용법

### NVM 설치
https://kjchoi.co.kr/20

### src > front 하위 폴더 이동
```
nvm use 16
npm install
```

### devServer 개발
```
npm run serve
```
### Spring 프로젝트에 Vue 빌드
```
npm run build
```

nginx 설정
```
server {
    listen 80;
    server_name your_domain.com; # 도메인 이름 또는 IP 주소로 변경

    location / {
        proxy_pass http://127.0.0.1:8080; # 프록시할 서버 주소와 포트로 변경
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    }
}
```